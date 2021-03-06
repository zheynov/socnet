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
 
 
INSERT INTO profile VALUES (1, 'admin', 'admin', '1911-11-11', 'admin@admin.com', 6, 'male', 'Atlantis', NULL);
INSERT INTO user VALUES (1, 'admin@admin.com', 'admin',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 1, 1);
 
INSERT INTO profile VALUES (2, 'Vadim', 'Zheynov', '1983-11-25', 'vadim@gmail.com', 33, 'male', 'Minsk', 0293453445);
INSERT INTO user VALUES (2, 'vadim@gmail.com', 'Vadim',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 2, 2);

INSERT INTO profile VALUES (3, 'James', 'Gosling', '1955-05-19', 'gosling@java.com', 61, 'male', 'Calgary', 101010101010);
INSERT INTO user VALUES (3, 'gosling@java.com', 'gosling',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 3, 2);
 
INSERT INTO profile VALUES (4, 'Redlaw', 'Redstar', '1988-02-28', 'Redlaw@redlaw.by', 28, 'female', 'New-York', 1116666666);
INSERT INTO user VALUES (4, 'Redlaw@redlaw.by', 'Redlaw',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 4, 2);
 
INSERT INTO profile VALUES (5, 'Борис', 'Ельцин', '1920-11-05', 'borya@mail.ru', 86, 'male', 'Москва', 564656466);
INSERT INTO user VALUES (5, 'borya@mail.ru', 'boris',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 5, 2);
 
INSERT INTO profile VALUES (6, 'Bruce', 'Wayne', '1990-03-18', 'batman@batman.ru', 36, 'male', 'Gotham', 666666);
INSERT INTO user VALUES (6, 'gmail@mail.ru', 'batman',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 6, 2);
 
INSERT INTO profile VALUES (7, 'uzerr', 'neim', '1980-06-18', 'zhabinka@tut.ru', 36, 'male', 'Жабинка', 049378442);
INSERT INTO user VALUES (7, 'zhabinka@tut.ru', 'uzerr',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 7, 2);
 
INSERT INTO profile VALUES (8, 'Armin', 'Van Burren', '1970-12-15', 'armin@armin.com', 55, 'female', 'Amsterdam', 564656466);
INSERT INTO user VALUES (8, 'armin@armin.com', 'Armin',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 8, 2);
 
INSERT INTO profile VALUES (9, 'Vladimir', 'Putin', '1953-05-05', 'putin@putin.com', 33, 'male', 'Moscow', 11111111111);
INSERT INTO user VALUES (9, 'putin@putin.com', 'putin',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 9, 2);

INSERT INTO profile VALUES (10, 'Ivan', 'Dorn', '1993-06-05', 'dorn@dorn.com', 33, 'male', 'Kiev', 22222222222);
INSERT INTO user VALUES (10, 'dorn@dorn.com', 'dorn',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 10, 2);

INSERT INTO profile VALUES (11, 'Tony', 'Stark', '1903-07-07', 'iron@man.com', 33, 'male', 'LA', 75476756745);
INSERT INTO user VALUES (11, 'iron@man.com', 'ironman',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 11, 2);

INSERT INTO profile VALUES (12, 'Janna', 'Dark', '1412-01-01', 'jdark@jdark.by', 25, 'female', 'Ruan', 22244455666);
INSERT INTO user VALUES (12, 'jdark@jdark.by', 'jdark',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 12, 2);

INSERT INTO profile VALUES (13, 'Don', 'Juan', '1234-02-02', 'juan@juan.by', 25, 'male', 'Madrid', 6757334557);
INSERT INTO user VALUES (13, 'juan@juan.by', 'juan',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 13, 2);

INSERT INTO profile VALUES (14, 'Hillary', 'Clintorn', '1947-10-26', 'hillary@hillary.com', 25, 'female', 'Washington', 6757334557);
INSERT INTO user VALUES (14, 'hillary@hillary.com', 'hillary',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 14, 2);

INSERT INTO profile VALUES (15, 'Elton', 'John', '1947-12-12', 'elton@elton.com', 65, 'female', 'London', 23545253557);
INSERT INTO user VALUES (15, 'elton@elton.com', 'elton',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 15, 2);

INSERT INTO profile VALUES (16, 'Bruce', 'Eckel', '1970-05-15', 'eckel@mail.ru', 46, 'male', 'Minsk', 1022030941001);
INSERT INTO user VALUES (16, 'eckel@mail.ru', 'eckel',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 16, 2);

INSERT INTO profile VALUES (17, 'Костя', 'Тцзю', '1970-05-15', 'kostyan@mail.ru', 46, 'male', 'Sidney', 1022030941001);
INSERT INTO user VALUES (17, 'kostyan@mail.ru', 'kostyan',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 17, 2);