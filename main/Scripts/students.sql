--AMAL SUJA BIJU (100838823)
--February 13, 2023
--Creates a DB Table for students

DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (
id INT PRIMARY KEY NOT NULL,
program_code VARCHAR(4),
program_description VARCHAR(255),
year INT,
FOREIGN KEY(id) REFERENCES users(id)
);

INSERT INTO students (id, program_code, program_description, year) VALUES (100111111, 'CSTY', 'Computer System Technology', 3);

INSERT INTO students (id, program_code, program_description, year) VALUES (100222221, 'CPA', 'Computer Programmer Analyst', 2);

INSERT INTO students (id, program_code, program_description, year) VALUES (100333333, 'CSTY', 'Computer System Technology', 1);

SELECT * FROM students;