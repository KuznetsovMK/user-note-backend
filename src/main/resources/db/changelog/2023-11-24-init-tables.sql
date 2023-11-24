--liquibase formatted sql

--changeset Kuznetsov.Mikhail:1

CREATE TABLE client_user
(
    id    UUID,
    login VARCHAR NOT NULL
        CONSTRAINT uq_user_login UNIQUE,
    CONSTRAINT pk_client_user PRIMARY KEY (id)
);

CREATE TABLE note
(
    id   UUID,
    text TEXT,
    CONSTRAINT pk_note PRIMARY KEY (id)
);

CREATE TABLE client_user_note
(
    id             UUID,
    client_user_id UUID NOT NULL REFERENCES client_user (id) ON DELETE CASCADE,
    note_id        UUID NOT NULL REFERENCES note (id) ON DELETE CASCADE,
    CONSTRAINT pk_user_note PRIMARY KEY (id)
);