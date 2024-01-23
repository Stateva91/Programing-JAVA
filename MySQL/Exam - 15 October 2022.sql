CREATE DATABASE `restaurant_db`;

# Section 1: Data Definition Language 
CREATE TABLE `products`(
`id` INT Primary Key AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE,
`type` VARCHAR(30) NOT NULL,
`price` DECIMAL(10,2) NOT NULL);


CREATE TABLE `clients`(
`id` INT Primary Key AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`birthdate` DATE,
`card` VARCHAR(50),
`review` TEXT
);

CREATE TABLE `tables`(
`id` INT Primary Key AUTO_INCREMENT,
`floor` INT NOT NULL,
`reserved` BOOLEAN,
`capacity` INT NOT NULL
);

CREATE TABLE `waiters`(
`id` INT Primary Key AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`phone` VARCHAR(50),
`salary` DECIMAL(10,2)
);

CREATE TABLE `orders`(
`id` INT Primary Key AUTO_INCREMENT,
`table_id` INT NOT NULL,
`waiter_id` INT NOT NULL,
`order_time` TIME NOT NULL,
`payed_status` BOOLEAN,
CONSTRAINT `fk_orders_tables`
FOREIGN KEY (table_id) REFERENCES `tables`(id),
CONSTRAINT `fk_orders_waiters`
FOREIGN KEY (waiter_id) REFERENCES `waiters`(id)
);

CREATE TABLE `orders_clients`(
`order_id` INT ,
`client_id` INT,
KEY `pk_orders_clients`(`order_id`, `client_id`),
CONSTRAINT `fk_ orders_client_orders`
FOREIGN KEY(`order_id`) REFERENCES `orders` (`id`),
CONSTRAINT `fk_ orders_client_clients`
FOREIGN KEY(`client_id`) REFERENCES `clients` (`id`)
);

CREATE TABLE `orders_products`(
`order_id` INT,
`product_id` INT,
KEY `pk_orders_products`(`order_id`, `product_id`),
CONSTRAINT `fk_ orders_product_orders`
FOREIGN KEY(`order_id`) REFERENCES `orders` (`id`),
CONSTRAINT `fk_ orders_product_products`
FOREIGN KEY(`product_id`) REFERENCES `products` (`id`)
);

#02. Insert

INSERT INTO `products` (`name`, `type`, price)
SELECT
CONCAT(`last_name` + " " + 'specialty'),
  "Cocktail",
  FORMAT(CEIL(`salary`*0.01),2)
FROM `waiters`
WHERE `id` > 6;

#03.	Update

UPDATE `orders`
SET table_id= table_id-1
WHERE id BETWEEN 12 AND 23;

#04.	Delete

DELETE w FROM `waiters` AS w
LEFT JOIN `orders` AS o ON w.`id`=o.`waiter_id`
WHERE o.`waiter_id` IS NULL;

#05.	Clients

SELECT * FROM `clients`
ORDER BY `birthdate` DESC, `id` DESC;

#06.	Birthdate
SELECT first_name, last_name, birthdate, review FROM clients
WHERE
    YEAR(`birthdate`) BETWEEN 1978 AND 1993 AND `card` IS NULL
ORDER BY `last_name` DESC , `id` ASC
LIMIT 5;

#07.	Accounts
SELECT CONCAT(last_name,
            first_name,
            CHARACTER_LENGTH(first_name),
            'Restaurant') AS `username`,
    REVERSE(SUBSTR(email, 2, 12)) AS `password`
FROM
    waiters
WHERE
    salary IS NOT NULL
ORDER BY password DESC;

#08.	Top from menu

SELECT p.`id`, p.`name`, COUNT(`product_id`) AS `count`
FROM `orders_products` AS pr
JOIN `products` AS p ON p.`id`= pr.`product_id`
GROUP BY product_id
HAVING count >=5
ORDER BY count DESC, p.`name` ASC;

#09.	Availability

SELECT 
    t.id AS table_id,
    t.capacity,
    COUNT(oc.client_id) AS count_clients,
    (CASE
        WHEN t.capacity = COUNT(oc.client_id) THEN 'Full'
        WHEN t.capacity > COUNT(oc.client_id) THEN 'Free seats'
        ELSE 'Extra seats'
    END) AS `availability`
FROM
    `tables` AS t
        JOIN
    orders AS o ON t.id = o.table_id
        JOIN
    orders_clients AS oc ON o.id = oc.order_id
WHERE
    t.floor = 1
GROUP BY t.id
ORDER BY t.id DESC;

#10.	Extract bill
DELIMITER $$
CREATE FUNCTION `udf_client_bill`(full_name VARCHAR(50)) RETURNS decimal(19,2)
    DETERMINISTIC
BEGIN
Declare f_name VARCHAR(40);
Declare l_name VARCHAR(40);
Declare space_index int;
SET space_index:=locate(' ',full_name);
SET f_name:= SUBSTRING(full_name,1,space_index-1);
SET l_name:=SUBSTRING(full_name,space_index+1);

RETURN(
SELECT sum(p.price)
FROM clients AS c
JOIN orders_clients AS oc ON c.id=oc.client_id
JOIN orders_products AS op ON oc.order_id=op.order_id
JOIN products AS p ON op.product_id=p.id
WHERE c.first_name=f_name AND c.last_name=l_name
);
END$$

#11.	Happy hour
SET SQL_SAFE_UPDATES = 0;
DELIMITER $$
CREATE PROCEDURE `udp_happy_hour`(type VARCHAR(50))
BEGIN
UPDATE products AS p SET p.price = p.price*0.8
WHERE p.price>=10.00;
END$$
DELIMITER ;

CALL udp_happy_hour ('Cognac');

