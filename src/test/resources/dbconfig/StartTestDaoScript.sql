DROP DATABASE IF EXISTS socnetTestDB;

CREATE DATABASE IF NOT EXISTS socnetTestDB;

USE socnetTestDB;

-- Table for mapping user and roles
CREATE TABLE user_role (
  id   BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  role VARCHAR(30)        NOT NULL
);

-- Table profile
CREATE TABLE profile
(
  id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  firstname   VARCHAR(30),
  lastname    VARCHAR(30),
  birthDate   DATE,
  email       VARCHAR(30) UNIQUE,
  age         INT(30)                     DEFAULT NULL,
  sex         VARCHAR(30),
  city        VARCHAR(30),
  phoneNumber VARCHAR(30)
);

-- Table user
CREATE TABLE user
(
  id        BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  email     VARCHAR(30)        NOT NULL UNIQUE,
  username  VARCHAR(30)        NOT NULL UNIQUE,
  password  VARCHAR(60)        NOT NULL,
  enabled   TINYINT            NOT NULL DEFAULT 1,
  profileID BIGINT             NOT NULL,
  roleID    BIGINT             NOT NULL,
  FOREIGN KEY (profileID) REFERENCES profile (id),
  FOREIGN KEY (roleID) REFERENCES user_role (id)
    ON DELETE CASCADE
);

-- Table for user's messages
CREATE TABLE message (
  id            BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  senderID      BIGINT             NOT NULL,
  destinationID BIGINT             NOT NULL,
  messagedate   DATETIME           NOT NULL,
  text          VARCHAR(1024),
  FOREIGN KEY (senderID) REFERENCES profile (id),
  FOREIGN KEY (destinationID) REFERENCES profile (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

-- Table to store photos
CREATE TABLE photo (
  id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  photo_file_name VARCHAR(64)        NOT NULL UNIQUE,
  profileID       BIGINT             NOT NULL,
  FOREIGN KEY (profileID) REFERENCES profile (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

-- Table for user's posts
CREATE TABLE post (
  id                    BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  text                  VARCHAR(1024),
  date                  DATETIME           NOT NULL,
  photo_file_name       VARCHAR(64) UNIQUE,
  profile_sender_id     BIGINT             NOT NULL,
  wall_owner_profile_id BIGINT             NOT NULL,
  FOREIGN KEY (profile_sender_id) REFERENCES profile (id),
  FOREIGN KEY (wall_owner_profile_id) REFERENCES profile (id)
);

-- Table to store the tokens for PersistentTokenRepository ("Remember me" feature)
CREATE TABLE persistent_logins (
  username  VARCHAR(64) NOT NULL,
  series    VARCHAR(64) PRIMARY KEY,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL
);

-- Table to store friends (ManyToMany)
CREATE TABLE friend (
  id                    BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  main_profile_id       BIGINT             NOT NULL,
  friends_profile_id    BIGINT             NOT NULL,
  friend_request_status ENUM ('PENDING_REQUEST', 'APPROVED_REQUEST', 'REJECTED_REQUEST'),
  FOREIGN KEY (main_profile_id) REFERENCES profile (id),
  FOREIGN KEY (friends_profile_id) REFERENCES profile (id),
  UNIQUE KEY main_profile_id (main_profile_id, friends_profile_id)
);

-- Insert data

INSERT INTO socnetTestDB.user_role VALUES (NULL, 'ROLE_ADMIN');
INSERT INTO socnetTestDB.user_role VALUES (NULL, 'ROLE_USER');