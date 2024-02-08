create table presidents
(
    id            int auto_increment primary key,
    first_name    varchar(255) not null,
    last_name     varchar(255) not null,
    year_of_birth int          not null,
    id_country    int UNIQUE,
    FOREIGN KEY (id_country) REFERENCES countries (id)
);

create table countries
(
    id              int auto_increment primary key,
    country_name    varchar(255) not null UNIQUE,
    population      bigint       not null,
    language        varchar(255) not null,
    area            DOUBLE       not null,
    government_form VARCHAR(100) not null
)