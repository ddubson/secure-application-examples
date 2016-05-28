CREATE DATABASE IF NOT EXISTS springsecpoc;
use springsecpoc;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
CREATE  TABLE users (
  user_id int(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(60) NOT NULL
);

CREATE TABLE users_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY unique_user_id_role (role,user_id),
  KEY fk_user_idx (user_id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

INSERT INTO users(user_id, username,password)
VALUES (1, 'dima','$2a$08$w106mkuRGEtytWq7Sl.XMeVyACTJ1caK5dbofkXlgrhcsBpz69j.W');
INSERT INTO users(user_id, username,password)
VALUES (2, 'sarah','$2a$08$w106mkuRGEtytWq7Sl.XMeVyACTJ1caK5dbofkXlgrhcsBpz69j.W');

INSERT INTO users_roles (user_id, role)
VALUES (1, 'ROLE_USER');
INSERT INTO users_roles (user_id, role)
VALUES (2, 'ROLE_ADMIN');
INSERT INTO users_roles (user_id, role)
VALUES (2, 'ROLE_USER');