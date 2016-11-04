DROP DATABASE IF EXISTS socnetDB;

CREATE DATABASE IF NOT EXISTS socnetDB;

USE socnetDB;

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
  FOREIGN KEY (profileID) REFERENCES profile (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

-- Table for mapping user and roles
CREATE TABLE user_role (
  id       BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(45)        NOT NULL,
  role     VARCHAR(45)        NOT NULL
);

-- Table to store the tokens for PersistentTokenRepository ("Remember me" feature)
CREATE TABLE persistent_logins (
  username  VARCHAR(64) NOT NULL,
  series    VARCHAR(64) PRIMARY KEY,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL
);

-- Insert data
INSERT INTO profile VALUES (1, 'admin', 'admin', NULL, 'admin@admin.com', NULL, NULL, NULL, NULL
);
INSERT INTO user VALUES (1, 'admin@admin.com', 'admin',
                          '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 1);

INSERT INTO profile VALUES (2, 'Vadim', 'Zheynov', NULL, 'vadim@gmail.com', NULL, NULL, NULL, NULL);
INSERT INTO user VALUES (2, 'vadim@gmail.com', 'Vadim',
                          '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 2);

INSERT INTO profile VALUES (3, 'Redlaw', 'Redstar', NULL, 'Redlaw@redlaw.by', NULL, NULL, NULL, NULL);
INSERT INTO user VALUES (3, 'Redlaw@redlaw.by', 'Redlaw',
                         '$2a$10$DTTv0kjndlTtHbj81VWETOPI.jo4BZYE/5krefGBEY0izb.Je96U6', 1, 3);


INSERT INTO socnetDB.user_role VALUES (NULL, 'admin', 'ROLE_ADMIN');
INSERT INTO socnetDB.user_role VALUES (NULL, 'Vadim', 'ROLE_USER');
INSERT INTO socnetDB.user_role VALUES (NULL, 'Redlaw', 'ROLE_USER');