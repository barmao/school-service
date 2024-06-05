-- V2__Update_School_Schema.sql

-- Ensure location and principal_name columns have the correct length
ALTER TABLE school MODIFY COLUMN location VARCHAR(100) NOT NULL;
ALTER TABLE school MODIFY COLUMN principal_name VARCHAR(100) NOT NULL;

-- Add unique constraint to the name column
ALTER TABLE school ADD CONSTRAINT UK_school_name UNIQUE (name);

-- Ensure the id field is set to AUTO_INCREMENT
ALTER TABLE school MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;
