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
primary key (id)
);

insert into test_inside.users (id,name,password) values('1','имя отправителя','пароль');
insert into test_inside.users (id,name,password) values('2','name','password');
insert into test_inside.users (id,name,password) values('3','sender_name','sender_password');
insert into test_inside.users (id,name,password) values('4','sname','spassword');
insert into test_inside.users (id,name,password) values('5','names','passwords');

insert into test_inside.messages (user_id,message) values('1','1');
insert into test_inside.messages (user_id,message) values('1','2');
insert into test_inside.messages (user_id,message) values('1','3');
insert into test_inside.messages (user_id,message) values('1','4');
insert into test_inside.messages (user_id,message) values('1','5');
insert into test_inside.messages (user_id,message) values('1','6');
insert into test_inside.messages (user_id,message) values('1','7');
insert into test_inside.messages (user_id,message) values('1','8');
insert into test_inside.messages (user_id,message) values('1','9');
insert into test_inside.messages (user_id,message) values('1','10');
insert into test_inside.messages (user_id,message) values('1','11');

insert into test_inside.messages (user_id,message) values('2','1');
insert into test_inside.messages (user_id,message) values('2','2');
insert into test_inside.messages (user_id,message) values('2','3');
insert into test_inside.messages (user_id,message) values('2','4');
insert into test_inside.messages (user_id,message) values('2','5');
insert into test_inside.messages (user_id,message) values('2','6');
insert into test_inside.messages (user_id,message) values('2','7');
insert into test_inside.messages (user_id,message) values('2','8');
insert into test_inside.messages (user_id,message) values('2','9');
insert into test_inside.messages (user_id,message) values('2','10');
insert into test_inside.messages (user_id,message) values('2','11');

insert into test_inside.messages (user_id,message) values('3','1');
insert into test_inside.messages (user_id,message) values('3','2');
insert into test_inside.messages (user_id,message) values('3','3');
insert into test_inside.messages (user_id,message) values('3','4');
insert into test_inside.messages (user_id,message) values('3','5');
insert into test_inside.messages (user_id,message) values('3','6');
insert into test_inside.messages (user_id,message) values('3','7');
insert into test_inside.messages (user_id,message) values('3','8');
insert into test_inside.messages (user_id,message) values('3','9');
insert into test_inside.messages (user_id,message) values('3','10');
insert into test_inside.messages (user_id,message) values('3','11');

insert into test_inside.messages (user_id,message) values('4','1');
insert into test_inside.messages (user_id,message) values('4','2');
insert into test_inside.messages (user_id,message) values('4','3');
insert into test_inside.messages (user_id,message) values('4','4');
insert into test_inside.messages (user_id,message) values('4','5');
insert into test_inside.messages (user_id,message) values('4','6');
insert into test_inside.messages (user_id,message) values('4','7');
insert into test_inside.messages (user_id,message) values('4','8');
insert into test_inside.messages (user_id,message) values('4','9');
insert into test_inside.messages (user_id,message) values('4','10');
insert into test_inside.messages (user_id,message) values('4','11');

insert into test_inside.messages (user_id,message) values('5','11');
insert into test_inside.messages (user_id,message) values('5','1');
insert into test_inside.messages (user_id,message) values('5','2');
insert into test_inside.messages (user_id,message) values('5','3');
insert into test_inside.messages (user_id,message) values('5','4');
insert into test_inside.messages (user_id,message) values('5','5');
insert into test_inside.messages (user_id,message) values('5','6');
insert into test_inside.messages (user_id,message) values('5','7');
insert into test_inside.messages (user_id,message) values('5','8');
insert into test_inside.messages (user_id,message) values('5','9');
insert into test_inside.messages (user_id,message) values('5','10');
insert into test_inside.messages (user_id,message) values('5','11');

commit;

