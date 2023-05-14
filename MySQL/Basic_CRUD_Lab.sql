SELECT 
id AS 'ID',
first_name AS 'First Name',
last_name AS 'Last Name', 
job_title AS 'Job Title' 
 FROM employees AS e
 ORDER BY id;
 
 SELECT 
`id` AS 'ID',
CONCAT(`first_name`, ' ', `last_name`) AS 'Full Name', 
job_title AS 'Job Title' 
 FROM `employees` AS e
 ORDER BY id;
 
 SELECT 
`id` AS 'ID',
CONCAT_WS(' ', `first_name`, `last_name`) AS 'Full Name', 
job_title AS 'Job Title' 
 FROM `employees` AS e
 ORDER BY id;
 
 SELECT 
 id, 
 CONCAT_WS(' ', first_name, last_name, 'Other') AS full_name,
 job_title,
 salary
 FROM employees
 WHERE salary>1000;
 
 SELECT *
 FROM employees AS e
 WHERE e.department_id=1;
 
 SELECT DISTINCT last_name FROM employees;
 
 SELECT id, first_name, department_id
 FROM employees
 WHERE department_id=1 OR department_id=2
 ;
 
 SELECT id, first_name, department_id
 FROM employees
 WHERE department_id=1 AND first_name='John';
 
 SELECT id, first_name, department_id
 FROM employees
 WHERE  NOT (department_id=1 AND first_name='John');
 
 SELECT id, first_name, department_id
 FROM employees
 WHERE  department_id BETWEEN 1 AND 5;
 
 SELECT id, first_name, department_id
 FROM employees
 WHERE  department_id IN (1, 5, 7, 8, 3);
 
 SELECT *
 FROM employees
 WHERE department_id=4 AND salary>1000
 ORDER BY id
 LIMIT 1;
 
 SELECT *
 FROM employees
 WHERE last_name= '';
 
 SELECT *
 FROM employees
 WHERE last_name IS NOT NULL;
 
SELECT *
FROM employees
ORDER BY department_id DESC, salary DESC;

CREATE VIEW v_top_paid_employee AS
SELECT *
FROM employees
ORDER BY salary DESC;
 
 SELECT first_name, salary FROM v_top_paid_employee;
 
 INSERT INTO employees VALUES(11, 'First', 'Last', 'Job', 2, 1100);
 
 INSERT INTO employees (first_name, job_title, department_id, salary)
 VALUES ('George1', 'Cook4', 3, 2200),
        ('George2', 'Cook1', 4, 2200),
        ('George4', 'Cook3', 1, 2300),
		('George3', 'Cook2', 2, 2400);
	
CREATE TABLE `created_from_select`
AS SELECT `id`, `department_id`, `job_title`
FROM `employees`;

CREATE TABLE `employee_backup`
AS SELECT *
FROM `employees`;

SELECT * FROM employees
WHERE job_title='Manager';

UPDATE employees
SET salary=salary+100
WHERE job_title='Manager';


DELETE FROM employees
WHERE id>11;

DROP TABLE employee_backup;

DELETE FROM employees
WHERE department_id=1 OR department_id=2
ORDER BY id;
 