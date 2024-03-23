--liquibase formatted sql
--changeset agakoz:1

CREATE TABLE COMMENT(
    id BIGSERIAL PRIMARY KEY,
    post_id BIGINT NOT NULL,
    content VARCHAR(255) NULL,
    created TIMESTAMP
);

ALTER TABLE COMMENT
    ADD CONSTRAINT FK_COMMENT_POST
        FOREIGN KEY (post_id) REFERENCES POST (id);