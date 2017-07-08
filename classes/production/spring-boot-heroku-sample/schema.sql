CREATE TABLE User (
  user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name    VARCHAR(32),
  age     INTEGER
);

CREATE TABLE Message (
  message_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  message    TEXT
)