package com.test.test;

import com.test.test.Service.SessionService;
import com.test.test.controller.SessionController;
import com.test.test.entity.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class SessionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SessionService sessionService;

    @InjectMocks
    private SessionController sessionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(sessionController).build();
    }

    @Test
    public void testCreateSession() throws Exception {
        Session session = new Session();
        session.setNom("Test Session");
        session.setTempstravail(50);
        session.setTempspause(10);

        mockMvc.perform(post("/Session")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nom\":\"Test Session\",\"tempstravail\":50,\"tempspause\":10}"))
                .andExpect(status().isCreated());

        verify(sessionService, times(1)).creer(any(Session.class));
    }

    @Test
    public void testGetSessions() throws Exception {
        List<Session> sessions = new ArrayList<>();
        Session session1 = new Session();
        session1.setId(UUID.randomUUID());
        session1.setNom("Session 1");
        sessions.add(session1);

        when(sessionService.listAll()).thenReturn(sessions);

        mockMvc.perform(get("/Session")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nom").value("Session 1"));

        verify(sessionService, times(1)).listAll();
    }

    @Test
    public void testGetById() throws Exception {
        UUID id = UUID.randomUUID();
        Session session = new Session();
        session.setId(id);
        session.setNom("Session Test");

        when(sessionService.getById(id)).thenReturn(session);

        mockMvc.perform(get("/Session/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Session Test"));

        verify(sessionService, times(1)).getById(id);
    }

    @Test
    public void testDeleteById() throws Exception {
        UUID id = UUID.randomUUID();

        doNothing().when(sessionService).deleteById(id);

        mockMvc.perform(delete("/Session/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(sessionService, times(1)).deleteById(id);
    }
}
