alter table person
    add column address varchar not null default '';

alter table person
    drop constraint person_age_check;
alter table person
    add constraint person_age_check check (age >= 0);
