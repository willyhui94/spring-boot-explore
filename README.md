# spring-boot-explore

CREATE TABLE IF NOT EXISTS department (
  id SERIAL NOT NULL,
  name varchar(40) NOT NULL,
  description varchar(150) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO department (id, name, description) VALUES
	(1, 'IT', 'Information Technology'),
	(2, 'TelComm', 'Telecommunication'),
	(3, 'Ins', 'Insurance'),
	(4, 'HR', 'Human Resources');

CREATE TABLE IF NOT EXISTS employee (
  id SERIAL NOT NULL,
  name varchar(40) NOT NULL,
  email varchar(150) NOT NULL,
  address varchar(250) DEFAULT NULL,
  dept_id int DEFAULT NULL,
  PRIMARY KEY(id),
  CONSTRAINT employee_ibfk_1 FOREIGN KEY(dept_id) REFERENCES department(id)
);

INSERT INTO employee (id, name, email, address, dept_id) VALUES
	(1, 'Soumitra', 'soumitra@gmail.com', NULL, 1),
	(2, 'Suman', 'suman@gmail.com', NULL, 2),
	(3, 'Avisek', 'avisek@gmail.com', NULL, 3);
