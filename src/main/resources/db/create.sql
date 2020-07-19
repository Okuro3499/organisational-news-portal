CREATE  DATABASE organisational;
\c organisational;

CREATE TABLE IF NOT EXISTS department (
id int PRIMARY KEY auto_increment,
name VARCHAR,
description VARCHAR,
totalemployees INTEGER;
);

CREATE TABLE IF NOT EXISTS news (
id int PRIMARY KEY auto_increment,
topic VARCHAR,
description VARCHAR,
departmentid int
);

CREATE TABLE IF NOT EXISTS users (
id int PRIMARY KEY auto_increment,
username VARCHAR,
departmentid int,
role VARCHAR
);

CREATE DATABASE organisation_test WITH TEMPLATE organisation;