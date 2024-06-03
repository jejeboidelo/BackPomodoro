package com.test.test.controller;

import com.test.test.Service.SessionService;
import com.test.test.entity.Session;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "Session")
public class SessionController {

    public SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }


    /**
     * Methode du controller appellant la création de la session au service
     * @param session
     */
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createSession(@RequestBody Session session){
        sessionService.creer(session);
    }

    /**
     * Methode du controller appellant la liste des sessions au service
     * @return
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Session> getSessions(){
        return sessionService.listAll();
    }

    /**
     * Methode du controller appellant une sessions au service correspondant a un Id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Session getById(@PathVariable(name = "id") UUID id){
        return sessionService.getById(id);
    }

    /**
     * Methode du controller supprimant une session correspondant à un Id en BDD via le service
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") UUID id){
        sessionService.deleteById(id);
    }
}
