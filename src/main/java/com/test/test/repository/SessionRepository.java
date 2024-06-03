package com.test.test.repository;

import com.test.test.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SessionRepository extends CrudRepository<Session, UUID> {

}
