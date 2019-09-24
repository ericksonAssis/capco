CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(100) NOT NULL,
  profile integer(2) DEFAULT NULL,
  password varchar(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



insert into user(id, username, profile, password) values(1,'user1', 1, 'secret1');
insert into user(id, username, profile, password) values(2,'admin1', 0, 'secret1');
