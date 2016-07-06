alter table users add role text;
update users set role = 'USER';
insert into users(id,name,email,password,role) values (11,'Admin','admin@example.com','admin','ADMIN');
--b6
create table if not exists rating
(
  id integer primary key autoincrement
, movieid integer
, userid integer
, rating real
, FOREIGN KEY(movieid) REFERENCES movie(id)
, FOREIGN KEY(userid) REFERENCES users(id)
);
--b11
create table if not exists poster
(
  id integer primary key autoincrement
, movieid integer
, poster blob
, FOREIGN KEY(movieid) REFERENCES movie(id)
);
--b7
ALTER TABLE movie ADD COLUMN marked2del INTEGER;