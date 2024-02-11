create database preserves_db;

CREATE TABLE continents(
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE countries(
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(40) NOT NULL UNIQUE,
country_code VARCHAR(10) NOT NULL UNIQUE,
continent_id INT NOT NULL,
CONSTRAINT `fk_countries_continents`
FOREIGN KEY(`continent_id`) REFERENCES `continents` (`id`)
);

CREATE TABLE preserves(
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(255) NOT NULL UNIQUE,
latitude DECIMAL(9,6),
longitude DECIMAL(9,6),
area INT,
type VARCHAR(20),
established_on DATE
);

CREATE TABLE positions(
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(40) NOT NULL UNIQUE,
description TEXT,
is_dangerous TINYINT(1) NOT NULL
);

CREATE TABLE workers(
id INT Primary Key AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL,
age INT,
personal_number VARCHAR(20) NOT NULL UNIQUE,
salary DECIMAL(19,2),
is_armed TINYINT(1) NOT NULL,
start_date DATE,
preserve_id INT,
CONSTRAINT `fk_workers_preserves`
FOREIGN KEY(`preserve_id`) REFERENCES `preserves` (`id`),
position_id INT,
CONSTRAINT `fk_workers_positions`
FOREIGN KEY(`position_id`) REFERENCES `positions` (`id`)
);

CREATE TABLE countries_preserves(
country_id INT,
CONSTRAINT `fk_countries_preserves_countries`
FOREIGN KEY(`country_id`) REFERENCES `countries` (`id`),
preserve_id INT,
CONSTRAINT `fk_countries_preserves_preserves`
FOREIGN KEY(`preserve_id`) REFERENCES `preserves` (`id`)
);

#02. Insert
INSERT INTO `preserves` (`name`, `latitude`, `longitude`, `area`, `type`, `established_on`)
SELECT
CONCAT(`name`, ' is in South Hemisphere'),
`latitude`,
`longitude`,
p.area*id,
LOWER(p.type),
`established_on`
FROM preserves as p
WHERE latitude<0;

#03. Update
UPDATE `workers`
SET salary=salary+500
WHERE position_id=5 OR position_id=8  OR  position_id=11  OR  position_id=13;

#04.DELETE
DELETE FROM `preserves`
WHERE `established_on` IS NULL;

#05. Most experienced workers
SELECT CONCAT(w.first_name, ' ' ,w.last_name) AS full_name,
 DATEDIFF('2024-01-01', w.start_date) AS days_of_experience 
 FROM workers as w
 WHERE DATEDIFF('2024-01-01', w.start_date) > 5*365
ORDER BY days_of_experience DESC
LIMIT 10;
 
 #06. Workers salary
 SELECT w.id As id,
 w.first_name AS first_name, 
 w.last_name AS last_name, 
 p.name AS preserve_name, 
 c.country_code AS country_code
 FROM workers AS w
  JOIN preserves AS p on p.id=w.preserve_id
  JOIN countries_preserves AS cp on cp.preserve_id=p.id
  JOIN countries AS c on c.id=cp.country_id
 WHERE w.salary>5000 AND w.age<50
 
 ORDER BY c.country_code ASC;
 
 #07. Armed workers count
 SELECT p.name AS name,
 SUM(w.is_armed) AS armed_workers
 FROM preserves AS p
 JOIN workers AS w on w.preserve_id=p.id
 GROUP BY name
 HAVING armed_workers>0
 ORDER BY armed_workers DESC, name ASC;
 
 #08. Oldest preserves
 SELECT p.name,
 c.country_code AS country_code,
 YEAR(p.established_on) AS founded_in
 FROM preserves AS p
  JOIN countries_preserves AS cp on cp.preserve_id=p.id
  JOIN countries AS c on c.id=cp.country_id
 WHERE MONTH(p.established_on)=5
 ORDER BY p.established_on ASC
 LIMIT 5;
 
 #09. Preserve categories
 SELECT p.id, p.name,
 (CASE
WHEN p.`area`<=100 THEN 'very small'
WHEN p.`area` <=1000 THEN 'small'
WHEN p.`area` <=10000 THEN 'medium'
WHEN p.`area` <=50000 THEN 'large'
ELSE 'very large'
END) AS 'category'
FROM preserves AS p
ORDER BY area DESC;

#10. Extract average salary
DELIMITER $$
CREATE FUNCTION udf_average_salary_by_position_name (name VARCHAR(40))
RETURNS DECIMAL(19,2)
DETERMINISTIC
BEGIN 
DECLARE position_average_salary DECIMAL(19,2);
SET position_average_salary :=(
SELECT AVG(w.salary)
FROM workers AS w
JOIN positions AS p ON p.id=w.position_id
WHERE name=p.name
);
RETURN position_average_salary;
END;$$
SELECT p.name, udf_average_salary_by_position_name('Forester') as position_average_salary FROM positions p 
WHERE p.name = 'Forester';

#11. Improving the standard of living
DELIMITER $$
CREATE PROCEDURE udp_increase_salaries_by_country(country_name VARCHAR(40))
BEGIN
UPDATE workers w
 JOIN preserves p on p.id = w.preserve_id
JOIN countries_preserves cp on cp.preserve_id = p.id
JOIN countries c on c.id=cp.country_id
SET w.salary=w.salary*1.05
WHERE c.name=country_name;
END$$
DELIMITER ;
CALL increase_salaries_by_country1 (Germany);

