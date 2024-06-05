-- V1__Create_School_Table.sql

CREATE TABLE school (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    principal_name VARCHAR(255) NOT NULL
);
