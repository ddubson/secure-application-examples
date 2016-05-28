CREATE DATABASE IF NOT EXISTS userbase;
use userbase;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
CREATE  TABLE users (
  userid int(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (userid));

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  userid int(11) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_userid_role (role,userid),
  KEY fk_user_idx (userid),
  CONSTRAINT fk_userid FOREIGN KEY (userid) REFERENCES users (userid));

INSERT INTO users(username,email,password,enabled)
VALUES ('dima','dima@gmail.com','$2a$08$w106mkuRGEtytWq7Sl.XMeVyACTJ1caK5dbofkXlgrhcsBpz69j.W', true);
INSERT INTO users(username,email,password,enabled)
VALUES ('sarah','sarah@gmail.com','$2a$08$w106mkuRGEtytWq7Sl.XMeVyACTJ1caK5dbofkXlgrhcsBpz69j.W', true);

INSERT INTO user_roles (userid, role)
VALUES (001, 'ROLE_USER');
INSERT INTO user_roles (userid, role)
VALUES (002, 'ROLE_ADMIN');
INSERT INTO user_roles (userid, role)
VALUES (002, 'ROLE_USER');