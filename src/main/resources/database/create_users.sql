--liquibase formatted sql
--changeset agakoz:1

CREATE TABLE USERS (
    username   VARCHAR(50) PRIMARY KEY,
    password   VARCHAR(255) NOT NULL,
    enabled    BOOLEAN NOT NULL
)