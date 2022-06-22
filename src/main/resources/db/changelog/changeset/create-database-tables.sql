----------------------------------------------------------------
-- USERS
----------------------------------------------------------------
CREATE TABLE users
(
    id       BIGSERIAL    NOT NULL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

----------------------------------------------------------------
-- ROLES
----------------------------------------------------------------
CREATE TABLE roles
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

----------------------------------------------------------------
-- TAGS
----------------------------------------------------------------
CREATE TABLE tags
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


----------------------------------------------------------------
-- AUTHORS
----------------------------------------------------------------
CREATE TABLE authors
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    url  VARCHAR(255) NOT NULL
);

----------------------------------------------------------------
-- WORKSHOP ITEMS
----------------------------------------------------------------
CREATE TABLE workshop_items
(
    id             BIGSERIAL    NOT NULL PRIMARY KEY,
    steam_id       VARCHAR(255) NOT NULL,
    name           VARCHAR(255) NOT NULL,
    url            VARCHAR(255) NOT NULL,
    description    TEXT,
    preview_image  VARCHAR(255),
    rating_in_star BIGSERIAL,
    rating         BIGSERIAL,
    size           NUMERIC(19, 2),
    posted         TIMESTAMPTZ,
    updated        TIMESTAMPTZ,
    visitors       BIGSERIAL,
    subscribers    BIGSERIAL,
    favorites      BIGSERIAL,
    comments       BIGSERIAL,
    discussions    BIGSERIAL,
    changes        BIGSERIAL
);
----------------------------------------------------------------
-- PIVOT WORKSHOP ITEM IMAGE
----------------------------------------------------------------
CREATE TABLE workshop_item_additional_images
(
    workshop_item_id    BIGSERIAL NOT NULL,
    image_name VARCHAR(255)
);

----------------------------------------------------------------
-- PIVOT ROLE USER
----------------------------------------------------------------
CREATE TABLE role_user
(
    role_id BIGINT NOT NULL REFERENCES roles (id) ON DELETE CASCADE,
    user_id BIGINT NOT NULL REFERENCES users (id) ON DELETE CASCADE
);

----------------------------------------------------------------
-- PIVOT AUTHOR WORKSHOP ITEM
----------------------------------------------------------------
CREATE TABLE author_workshop_item
(
    author_id BIGINT NOT NULL REFERENCES authors (id) ON DELETE CASCADE,
    workshop_item_id   BIGINT NOT NULL REFERENCES workshop_items (id) ON DELETE CASCADE
);

----------------------------------------------------------------
-- PIVOT TAG WORKSHOP ITEM
----------------------------------------------------------------
CREATE TABLE tag_workshop_item
(
    tag_id  BIGINT NOT NULL REFERENCES tags (id) ON DELETE CASCADE,
    workshop_item_id BIGINT NOT NULL REFERENCES workshop_items (id) ON DELETE CASCADE
);