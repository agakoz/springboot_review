--liquibase formatted sql
--changeset agakoz:1
CREATE TABLE Authorities
(
    username   VARCHAR(50) PRIMARY KEY,
    authority   VARCHAR(255) NOT NULL
);