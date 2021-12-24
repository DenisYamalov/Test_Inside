begin;

drop schema if exists test_inside cascade;
create schema test_inside;

drop table if exists test_inside.users;
create table test_inside.users (
id serial,
name varchar(100) unique not null,
password varchar(100) not null,
primary key (id)
);

drop table if exists test_inside.messages;
create table test_inside.messages (
id serial,
user_id serial not null references test_inside.users on delete cascade,
message varchar not null,
time timestamp not null,
primary key (id)
);

insert into test_inside.users (id,name,password) values('1','имя отправителя','пароль');
insert into test_inside.users (id,name,password) values('2','name','password');
insert into test_inside.users (id,name,password) values('3','sender_name','sender_password');
insert into test_inside.users (id,name,password) values('4','sname','spassword');
insert into test_inside.users (id,name,password) values('5','names','passwords');

drop SEQUENCE if exists HIBERNATE_SEQUENCE;
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 6 INCREMENT BY 1;
commit;

