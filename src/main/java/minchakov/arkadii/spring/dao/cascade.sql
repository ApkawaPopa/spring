create table "user"(
    id int primary key generated by default as identity,
    name varchar(100) not null,
    age int check ( age > 0 ) not null
);

insert into "user" values (1, 'Mega Trololo1', 15);
insert into "user" values (2, 'Mega Trololo2', 16);
insert into "user" values (3, 'Mega Trololo3', 17);

create table order1(
    user_id int references "user"(id) on delete cascade,
    id int primary key generated by default as identity,
    name varchar(100) not null
);

insert into order1(user_id, name) values (1, 'Logitech keyboard type 1');
delete from "user" where id = 1;
select * from order1; -- вернется пустая таблица

create table order2(
    user_id int references "user"(id) on delete set null,
    id int primary key generated by default as identity,
    name varchar(100) not null
);

insert into order2(user_id, name) values (2, 'Logitech keyboard type 2');
delete from "user" where id = 2;
select * from order2; -- вернется таблица где user_id будет <null>

create table order3(
    user_id int references "user"(id) on delete restrict,
    id int primary key generated by default as identity,
    name varchar(100) not null
);

insert into order3(user_id, name) values (3, 'Logitech keyboard type 3');
delete from "user" where id = 3; -- ошибка
select * from order3; -- таблица не поменялась
