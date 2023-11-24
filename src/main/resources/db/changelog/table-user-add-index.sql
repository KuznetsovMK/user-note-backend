--liquibase formatted sql

--changeset Kuznetsov.Mikhail:1
CREATE TABLE "user"
(
    id    UUID,
    login TEXT NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE note
(
    id   UUID,
    text TEXT,
    CONSTRAINT pk_note PRIMARY KEY (id)
);

CREATE TABLE user_note
(
    id      UUID,
    user_id UUID NOT NULL REFERENCES "user" (id) ON DELETE CASCADE,
    note_id UUID NOT NULL REFERENCES note (id) ON DELETE CASCADE,
    CONSTRAINT pk_user_note PRIMARY KEY (id)
);