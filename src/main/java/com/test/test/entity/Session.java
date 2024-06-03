package com.test.test.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class Session {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String nom;
    private int tempstravail;
    private int tempspause;


    public Session() {

    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTempstravail() {
        return tempstravail;
    }

    public void setTempstravail(int tempstravail) {
        this.tempstravail = tempstravail;
    }

    public int getTempspause() {
        return tempspause;
    }

    public void setTempspause(int tempspause) {
        this.tempspause = tempspause;
    }
}
