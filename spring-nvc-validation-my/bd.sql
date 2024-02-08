#  CREATE DATABASE users;
#  USE users;
create table users
(
    id             int auto_increment primary key,
    first_name     varchar(255) not null,
    last_name      varchar(255) not null,
    age            int          not null,
    marital_status boolean,
    gender         boolean,
    phone          varchar(255) not null,
    email          varchar(255) not null

);

insert into users(first_name, last_name, age, marital_status, gender, phone, email)
VALUES ('Ivan', 'Ivanov', 18, true, false, '066-666-66-66', 'ivan@gmail.com');
insert into users(first_name, last_name, age, marital_status, gender, phone, email)
VALUES ('Petr', 'Petrov', 22, false, false, '077-777-77-77', 'petr@gmail.com');
insert into users(first_name, last_name, age, marital_status, gender, phone, email)
VALUES ('Stepan', 'Stepanov', 19, false, true, '099-999-99-99', 'stepan@gmail.com');