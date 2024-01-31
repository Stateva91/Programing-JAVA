create database universities_db;

CREATE TABLE countries(
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE cities(
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(40) NOT NULL UNIQUE,
population INT,
country_id INT NOT NULL,
CONSTRAINT `fk_cities_countries`
FOREIGN KEY(`country_id`) REFERENCES `countries` (`id`)
);

CREATE TABLE universities(
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(60) NOT NULL UNIQUE,
address VARCHAR(80) NOT NULL UNIQUE,
tuition_fee DECIMAL(19,2) NOT NULL,
number_of_staff INT,
city_id INT,
CONSTRAINT `fk_universities_cities`
FOREIGN KEY(`city_id`) REFERENCES `cities` (`id`)
);

CREATE TABLE students(
id INT Primary Key AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL,
age INT,
phone VARCHAR(20) NOT NULL UNIQUE,
email VARCHAR(255) NOT NULL UNIQUE,
is_graduated BOOLEAN NOT NULL ,
city_id INT,
CONSTRAINT `fk_students_cities`
FOREIGN KEY(`city_id`) REFERENCES `cities` (`id`)
);

CREATE TABLE courses(
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(40) NOT NULL UNIQUE,
duration_hours DECIMAL(19,2),
start_date DATE,
teacher_name VARCHAR(60) NOT NULL UNIQUE,
description TEXT,
university_id INT,
CONSTRAINT `fk_courses_universities`
FOREIGN KEY(`university_id`) REFERENCES `universities` (`id`)
);

CREATE TABLE students_courses(
grade DECIMAL(19,2) NOT NULL,
student_id INT NOT NULL,
CONSTRAINT `fk_students_courses_students`
FOREIGN KEY(`student_id`) REFERENCES `students` (`id`),
course_id INT NOT NULL,
CONSTRAINT `fk_students_courses_courses`
FOREIGN KEY(`course_id`) REFERENCES `courses` (`id`)
);

#02.Insert
INSERT INTO `courses` (`name`, `duration_hours`, `start_date`, `teacher_name`, `description`, `university_id`)
SELECT 
CONCAT(`teacher_name`,' course'),
CHAR_LENGTH(`name`)/10,
DATE(`start_date`+5),
REVERSE(`teacher_name`),
CONCAT('Course',' ', `teacher_name`, REVERSE(`description`)),
DAY(`start_date`)
FROM `courses` 
WHERE `id`<=5;

#03.Update
UPDATE `universities`
SET `tuition_fee`=`tuition_fee`+300
WHERE `id` BETWEEN 5 AND 12;

#04. Delete
DELETE FROM `universities`
WHERE `number_of_staff` IS NULL;

#05. Cities
SELECT * FROM cities
ORDER BY population DESC;

#06. Students age
SELECT first_name, last_name, age, phone, email
FROM students
WHERE age>=21
ORDER BY first_name DESC, email ASC, id ASC
LIMIT 10;

#07. New students
SELECT
CONCAT(fisrt_name, " ", last_name) AS full_name,
SUBSTRING(email,2,10) AS username,
REVERSE(phone) AS password
FROM students  s
LEFT JOIN students_courses sc on s.id = sc.student_id
LEFT JOIN courses c on c.id = sc.course_id
WHERE sc.student_id IS NULL
ORDER BY password DESC;

#08. Students count
SELECT COUNT(c.id) students_count, u.name university_name
FROM universities u
JOIN courses c ON c.university_id=u.id
JOIN students_courses sc ON sc.course_id=c.id
GROUP BY u.name
having students_count>=8
ORDER BY students_count DESC, university_name DESC;

#09. Price rankings
SELECT u.name university_name, 
c.name city_name, address, 
(CASE
   WHEN  u.tuition_fee <800 THEN 'cheap'
   WHEN  u.tuition_fee  BETWEEN 800 AND 1200 THEN 'normal'
   WHEN  u.tuition_fee  BETWEEN 1200 AND 2500 THEN 'high'
   WHEN  u.tuition_fee  >=2500 THEN 'expensive'
END) AS price_rank,
tuition_fee
FROM universities AS u
JOIN cities AS c ON c.id=u.city_id
ORDER BY tuition_fee ASC;

#10. Average grades
DELIMITER $$
CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60)) 
RETURNS DECIMAL(19,2)
DETERMINISTIC
BEGIN 
DECLARE average_alumni_grade DECIMAL(19,2);
SET average_alumni_grade :=(
SELECT AVG(sc.grade)
FROM students_courses AS sc
JOIN students AS s ON s.id=sc.student_id
JOIN courses AS c ON c.id=sc.course_id
WHERE s.is_graduated=TRUE AND c.name=course_name
);
RETURN average_alumni_grade;
END;$$

#11. Graduate students
CREATE PROCEDURE udp_graduate_all_students_by_year(year_started INT)
BEGIN
UPDATE students s
JOIN students_courses sc on s.id = sc.student_id
JOIN courses c on c.id = sc.course_id
SET s.is_graduated=TRUE
WHERE YEAR(c.start_date)=year_started;
END$$
