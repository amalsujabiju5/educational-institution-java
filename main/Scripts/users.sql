--AMAL SUJA BIJU (100838823)
--February13, 2023
--Creates a DB Table for all users

CREATE EXTENSION IF NOT EXISTS pgcrypto;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users(
id INT PRIMARY KEY NOT NULL,
password VARCHAR(40) NOT NULL,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
email_address VARCHAR(255) NOT NULL,
last_access DATE,
enrol_date DATE NOT NULL,
enabled BOOLEAN NOT NULL,
type VARCHAR(1) NOT NULL
);
-- INSERT STATEMENTS to build data

-- STUDENTS:
-- STUDENT 1
INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (100111111, ENCODE(DIGEST('password', 'sha1'), 'hex'), 'Mike', 'Jones', 'mike.jones@dcmail.ca', '2022-01-30 13:04:50', '2015-09-11 12:40:20', '1', 's');
-- STUDENT 2
INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (100222221, ENCODE(DIGEST('100289547', 'sha1'), 'hex'), 'AMAL', 'S', 'amal.s@dcmail.ca', '2021-02-03 02:30:60', '2020-01-01 07:12:05', '1', 's');
-- STUDENT 3
INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (100333333, ENCODE(DIGEST('100333333','sha1'), 'hex'), 'Akhil', 'S', 'Akhil.s@dcmail.ca', '2022-03-01 13:00:00', '2021-01-27 11:26:37', '1', 's');

-- FACULTY: 
-- FACULTY 1
INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (101111111, ENCODE(DIGEST('101111111', 'sha1'), 'hex'), 'Stephen', 'Shelby', 'shelby@peakyblinders.com', '2020-01-02 12:00:00', '2019-01-08 02:06:20', '1', 'f');
-- FACULTY 2
INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (102222222, ENCODE(DIGEST('102222222', 'sha1'), 'hex'), 'Kyle', 'Stark', 'stark@imironman.com', '2023-01-02 11:00:00', '2016-01-01 13:04:24', '1', 'f');
-- FACULTY 3
INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (103333333, ENCODE(DIGEST('103333333', 'sha1'), 'hex'), 'Mac', 'White', 'walter.white@bestchemist.com', '2023-02-01 10:00:00', '2020-01-01 13:20:25', '1', 'f');

SELECT * FROM users;