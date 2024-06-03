package com.test.test.Service;

import com.test.test.entity.Session;
import com.test.test.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessionService {

    @Autowired
    SessionRepository sessionRepo;

    /**
     * Methode inscrivant la session en BDD
     * @param session
     */
    public void creer(Session session){
        sessionRepo.save(session);
    }

    /**
     * Methode listant toutes les sessions en BDD
     * @return
     */
    public List<Session> listAll(){
        return (List<Session>) sessionRepo.findAll();
    }

    /**
     * Methode listant une session en BDD correspondant à un Id
     * @param id
     * @return
     */
    public Session getById(UUID id){
        return sessionRepo.findById(id).orElse(null);
    }

    /**
     * Methode supprimant une session en BDD correspondant à un Id
     * @param id
     */
    public void deleteById(UUID id){
        sessionRepo.deleteById(id);
    }
}
