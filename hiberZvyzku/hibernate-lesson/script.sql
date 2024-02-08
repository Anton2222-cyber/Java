-- one to one
create table employees
(
    id         int auto_increment primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    phone      varchar(255) unique not null,
    department varchar(255),
    id_employees_full_info int UNIQUE,
    FOREIGN KEY (id_employees_full_info) REFERENCES employees_full_info(id)
);
create table employees_full_info
(
    id         int auto_increment primary key,
    email varchar(255) not null,
    country varchar(255) not null,
    city  varchar(255) not null,
    address      varchar(255) not null,
    is_married boolean,
    date_of_birth varchar(255) not null,
    count_children int
);

-- one to many
create table departments
(
    id         int auto_increment primary key,
    name       varchar(255) not null,
    min_salary int,
    max_salary int,
    skill     varchar(1000)
);
create table employees
(
    id             int auto_increment primary key,
    first_name     varchar(255)        not null,
    last_name      varchar(255)        not null,
    phone          varchar(255) unique not null,
    salary         int,
    id_departments int,
    FOREIGN KEY (id_departments) REFERENCES departments (id)
);

