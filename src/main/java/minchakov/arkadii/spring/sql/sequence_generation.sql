drop table person;

create table person (
    id int primary key,
    name varchar(100) not null,
    age int check ( age >= 0 )
);