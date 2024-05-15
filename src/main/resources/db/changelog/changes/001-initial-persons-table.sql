create table PERSONS
(
    name           varchar(50) not null,
    surname        varchar(50) not null,
    age            int         not null,
    phone_number   varchar(16) unique,
    city_of_living varchar(50),
    primary key (name, surname, age)
);

insert into PERSONS
values ('Bob', 'Marley', 65, '+148486547924', 'New-York');
insert into PERSONS
values ('Cary', 'Grant', 23, '+1895486465924', 'Los-Angels');
insert into PERSONS
values ('Marlon', 'Brando', 27, '+148465487924', 'New-York');
insert into PERSONS
values ('Fred', 'Aster', 45, '+148795447924', 'New-York');
insert into PERSONS
values ('Andrey', 'Mironov', 37, '+79214787647', 'Moscow');
insert into PERSONS
values ('Alexander', 'Ostrovckiy', 66, '+79214467847', 'Moscow');