create table person (
    id int primary key generated by default as identity,
    name varchar(100) not null,
    age int check ( age >= 0 )
);

insert into person (name, age) values ('Аркадий Минчаков', 21);