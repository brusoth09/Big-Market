CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));


CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

CREATE TABLE blog_posts (
  blog_post_id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  image_path varchar(200),
  content TEXT,
  status VARCHAR(20),
  created DATETIME,
  modified DATETIME,
  username varchar(45) NOT NULL,
  PRIMARY KEY (blog_post_id),
  KEY fk_blog_user_idx (username),
  CONSTRAINT fk_blog_user_idx FOREIGN KEY (username) REFERENCES users (username));

INSERT INTO users(username,password,enabled)
VALUES ('admin','123456', true);

INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_ADMIN');