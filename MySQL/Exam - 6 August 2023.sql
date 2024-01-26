CREATE DATABASE real_estate;
use real_estate;

CREATE TABLE cities(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE property_types(
id INT PRIMARY KEY AUTO_INCREMENT,
type VARCHAR(40) NOT NULL UNIQUE,
description TEXT
);

CREATE TABLE properties(
id INT PRIMARY KEY AUTO_INCREMENT,
address VARCHAR(80) NOT NULL UNIQUE,
price DECIMAL(19,2) NOT NULL,
area DECIMAL(19,2),
property_type_id INT,
CONSTRAINT properties_property_types
FOREIGN KEY(property_type_id) REFERENCES property_types(id),
city_id INT,
CONSTRAINT properties_cities
FOREIGN KEY(city_id) REFERENCES cities(id)
);

CREATE TABLE agents(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL,
phone VARCHAR(20) NOT NULL UNIQUE,
email VARCHAR(50) NOT NULL UNIQUE,
city_id INT,
CONSTRAINT agents_cities
FOREIGN KEY(city_id) REFERENCES cities(id)
);

CREATE TABLE buyers(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL,
phone VARCHAR(20) NOT NULL UNIQUE,
email VARCHAR(50) NOT NULL UNIQUE,
city_id INT,
CONSTRAINT buyers_cities
FOREIGN KEY(city_id) REFERENCES cities(id)
);

CREATE TABLE property_offers(
property_id INT NOT NULL,
CONSTRAINT property_offers_properties
FOREIGN KEY(property_id) REFERENCES properties(id),
agent_id INT NOT NULL,
CONSTRAINT property_offers_agents
FOREIGN KEY(agent_id) REFERENCES agents(id),
price DECIMAL(19,2) NOT NULL,
offer_datetime DATETIME
);

CREATE TABLE property_transactions(
id INT PRIMARY KEY AUTO_INCREMENT,
property_id INT NOT NULL,
CONSTRAINT property_transactions_properties
FOREIGN KEY(property_id) REFERENCES properties(id),
buyer_id INT NOT NULL,
CONSTRAINT property_transactions_buyers
FOREIGN KEY(buyer_id) REFERENCES buyers(id),
transaction_date DATE,
bank_name VARCHAR(30),
iban VARCHAR(40) UNIQUE,
is_successful TINYINT(1)
);

INSERT INTO property_transactions(property_id, buyer_id, transaction_date, bank_name, iban, is_successful)(
SELECT
po.agent_id + DAY(offer_datetime),
po.agent_id+ MONTH(offer_datetime),
DATE(offer_datetime),
CONCAT('Bank ', po.agent_id),
CONCAT("BG", po.price, po.agent_id) AS iban,
1
FROM property_offers as po
WHERE po.agent_id<=2
);

UPDATE properties as p
SET p.price=price-50000
WHERE p.price>=800000;

DELETE FROM property_transactions 
WHERE is_successful=FALSE;

#Agents
SELECT * FROM agents
ORDER BY city_id DESC, phone DESC;

#Offers from 2021
SELECT * FROM property_offers
WHERE YEAR(offer_datetime)=2021
ORDER BY price ASC
LIMIT 10;

#Properties without offers
SELECT 
LEFT(p.address, 6) AS agent_name,
LENGTH(p.address)*5430 AS price
FROM properties AS p
LEFT JOIN property_offers AS po ON p.id=po.property_id
WHERE po.agent_id IS NULL
ORDER BY agent_name DESC, price DESC;

#Best Banks
SELECT
 pt.bank_name, 
 COUNT(*) AS count
 FROM property_transactions as pt
 GROUP BY bank_name
 HAVING count>=9
 ORDER BY count DESC, bank_name ASC;
 
#Size of the area
SELECT p.address, p.area,
(CASE
WHEN p.area <=100 THEN 'small'
WHEN p.area <=200 THEN 'medium'
WHEN p.area <=500 THEN 'large'
ELSE 'extra large'
END) AS size
FROM properties AS p
ORDER BY area ASC, address DESC;

# Offers count in a city
CREATE FUNCTION udf_offers_from_city_name (cityName VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE offers_count INT;
SET offers_count :=(
SELECT COUNT(c.id) FROM property_offers po
JOIN properties p on po.property_id = p.id
JOIN cities c on c.id = p.city_id
 WHERE c.name = cityName);
RETURN offers_count;
END;

#Special Offer
CREATE PROCEDURE udp_special_offer(first_name VARCHAR(50))
BEGIN
  UPDATE property_offers po
JOIN agents a on a.id = po.agent_id
SET po.price = po.price * 0.9
 WHERE a.first_name = first_name;
END;

# CALL udp_special_offer('Hans');
#
# SELECT po.price,a.first_name FROM property_offers po
# JOIN agents a on a.id = po.agent_id
# WHERE first_name='hans'
