DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
CREATE  TABLE users (
  user_id int(15) PRIMARY KEY NOT NULL,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(60) NOT NULL
);

CREATE TABLE users_roles (
  user_role_id int(11) PRIMARY KEY NOT NULL,
  user_id int(11) NOT NULL,
  role varchar(45) NOT NULL
);

INSERT INTO users(user_id, username,password)
VALUES (1, 'dima','$2a$08$w106mkuRGEtytWq7Sl.XMeVyACTJ1caK5dbofkXlgrhcsBpz69j.W');
INSERT INTO users(user_id, username,password)
VALUES (2, 'sarah','$2a$08$w106mkuRGEtytWq7Sl.XMeVyACTJ1caK5dbofkXlgrhcsBpz69j.W');

INSERT INTO users_roles (user_role_id, user_id, role)
VALUES (1, 1, 'ROLE_USER');
INSERT INTO users_roles (user_role_id, user_id, role)
VALUES (2, 2, 'ROLE_ADMIN');
INSERT INTO users_roles (user_role_id, user_id, role)
VALUES (3, 2, 'ROLE_USER');