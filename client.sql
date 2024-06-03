CREATE DATABASE BACK;

CREATE TABLE session(
    ID char(36) primary key not null,
    MODE varchar(50),
    TEMPSTRAVAIL int,
    TEMPSPAUSE int
);