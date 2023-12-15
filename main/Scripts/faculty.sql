--AMAL SUJA BIJU (100838823)
--February 13, 2023
--Creates a DB Table for faculty

DROP TABLE IF EXISTS faculty CASCADE;
CREATE TABLE faculty (
id INT PRIMARY KEY NOT NULL,
school_code VARCHAR(5),
school_description VARCHAR(255),
office VARCHAR(5),
phone_extension INT,
FOREIGN KEY(id) REFERENCES users(id)
);

INSERT INTO faculty (id, school_code, school_description, office, phone_extension) VALUES (101111111, 'MI', 'MarIvanios', 'B-007', 1256);

INSERT INTO faculty (id, school_code, school_description, office, phone_extension) VALUES (102222222, 'DC', 'Durham COllege', 'X-547', 2222);

INSERT INTO faculty (id, school_code, school_description, office, phone_extension) VALUES (103333333, 'GV', 'GVHSS', 'M-8520', 3333);

SELECT * FROM faculty;