DROP DATABASE IF EXISTS socnetDB;

CREATE DATABASE IF NOT EXISTS socnetDB;

USE socnetDB;

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
    ON UPDATE CASCADE
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
  date                  DATE               NOT NULL,
  photoID               BIGINT             NOT NULL,
  profile_sender_id     BIGINT             NOT NULL,
  wall_owner_profile_id BIGINT             NOT NULL,
  FOREIGN KEY (profile_sender_id) REFERENCES profile (id),
  FOREIGN KEY (wall_owner_profile_id) REFERENCES profile (id),
  FOREIGN KEY (photoID) REFERENCES photo (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
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

-- Table to store the tokens for PersistentTokenRepository ("Remember me" feature)
CREATE TABLE persistent_logins (
  username  VARCHAR(64) NOT NULL,
  series    VARCHAR(64) PRIMARY KEY,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL
);

-- Insert data
INSERT INTO socnetDB.user_role VALUES (NULL, 'ROLE_ADMIN');
INSERT INTO socnetDB.user_role VALUES (NULL, 'ROLE_USER');


INSERT INTO profile VALUES (1, 'admin', 'nimda', '1911-11-11', 'admin@admin.com', 6, NULL, 'Atlantis', NULL);
INSERT INTO user VALUES (1, 'admin@admin.com', 'admin',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 1, 1);

INSERT INTO profile VALUES (2, 'Vadim', 'Zheynov', '1983-11-25', 'vadim@gmail.com', 33, 'male', 'Minsk', 0293453445);
INSERT INTO user VALUES (2, 'vadim@gmail.com', 'Vadim',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 2, 2);

INSERT INTO profile VALUES (3, 'Redlaw', 'Redstar', '1988-02-28', 'Redlaw@redlaw.by', 28, 'female', 'New-York', 1116666666);
INSERT INTO user VALUES (3, 'Redlaw@redlaw.by', 'Redlaw',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 3, 2);

INSERT INTO profile VALUES (4, 'Костя', 'Тцзю', '1970-05-15', 'kostyan@mail.ru', 46, 'male', 'Sidney', 1022030941001);
INSERT INTO user VALUES (4, 'kostyan@mail.ru', 'kostyan',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 4, 2);

INSERT INTO profile VALUES (5, 'Борис', 'Ельцин', '1920-11-05', 'borya@mail.ru', 86, 'male', 'Москва', 564656466);
INSERT INTO user VALUES (5, 'borya@mail.ru', 'boris',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 5, 2);

INSERT INTO profile VALUES (6, 'Bruce', 'Wayne', '1990-03-18', 'batman@batman.ru', 36, 'male', 'Gotham', 666666);
INSERT INTO user VALUES (6, 'gmail@mail.ru', 'batman',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 6, 2);


