alter table users add role text;
update users set role = 'USER';
insert into users(id,name,email,password,role) values (11,'Admin','admin@example.com','admin','ADMIN');