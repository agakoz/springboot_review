--liquibase formatted sql
--changeset agakoz:1
CREATE TABLE POST (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255)
    );
