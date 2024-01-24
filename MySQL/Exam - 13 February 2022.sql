drop database online_stores’s;
CREATE DATABASE online_stores’s;
use online_stores’s;

CREATE TABLE brands (
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE categories (
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE reviews (
id INT Primary Key AUTO_INCREMENT,
content TEXT,
rating DECIMAL(10,2) NOT NULL,
picture_url VARCHAR(80) NOT NULL,
published_at DATETIME NOT NULL
);

CREATE TABLE products (
id INT Primary Key AUTO_INCREMENT,
name VARCHAR(40) NOT NULL,
price DECIMAL(19,2) NOT NULL,
quantity_in_stock INT,
description TEXT,
brand_id INT NOT NULL,
CONSTRAINT fk_products_brands
FOREIGN KEY (brand_id) REFERENCES brands(id),
category_id INT NOT NULL,
CONSTRAINT fk_products_categories
FOREIGN KEY (category_id) REFERENCES categories(id),
review_id INT NOT NULL,
CONSTRAINT fk_products_reviews
FOREIGN KEY (review_id) REFERENCES reviews(id)
);

CREATE TABLE customers (
id INT Primary Key AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
phone VARCHAR(30) NOT NULL UNIQUE,
address VARCHAR(60) NOT NULL,
discount_card BIT(1) NOT NULL DEFAULT(FALSE)
);

CREATE TABLE orders (
id INT Primary Key AUTO_INCREMENT,
order_datetime DATETIME NOT NULL,
customer_id INT NOT NULL,
CONSTRAINT fk_orders_customers
FOREIGN KEY (customer_id)REFERENCES customers(id)
);

CREATE TABLE orders_products (
order_id INT ,
CONSTRAINT fk_orders_products_orders
FOREIGN KEY (order_id)REFERENCES orders(id),
product_id INT,
CONSTRAINT fk_orders_products_products
FOREIGN KEY (product_id)REFERENCES products(id)
);

INSERT INTO reviews(content, picture_url, published_at, rating)
SELECT LEFT(p.description, 15),
REVERSE(p.name) , 
DATE('2010/10/10'),
p.price/8
FROM products as p
WHERE p.id>=5;

UPDATE products AS p 
SET p.quantity_in_stock =p.quantity_in_stock - 5
WHERE quantity_in_stock BETWEEN 60 AND 70; 

DELETE c FROM customers AS c
LEFT JOIN orders as o ON c.id=o.customer_id
WHERE o.customer_id IS NULL;

#Categories
SELECT id, name 
FROM categories
ORDER BY name DESC;

# Quantity
SELECT id AS product_id, brand_id, name, quantity_in_stock AS quantity
FROM products
WHERE price> 1000 AND quantity_in_stock< 30
ORDER BY quantity_in_stock, id;

#Review
SELECT id, content, rating, picture_url, published_at
FROM reviews
WHERE LENGTH(content)>61 AND content LIKE 'My%'
ORDER BY rating DESC;

#First customers
SELECT concat_ws(' ', c.first_name, c.last_name) as full_name, 
c.address, o.order_datetime
FROM orders AS o 
JOIN customers c ON o.customer_id=c.id
WHERE YEAR(o.order_datetime) <=2018
ORDER BY full_name DESC;

#Best categories
SELECT COUNT(c.id) as items_count,
c.name,
SUM(p.quantity_in_stock) as total_quantity
FROM products AS p
JOIN categories AS c ON c.id=p.category_id
GROUP BY c.id
ORDER BY items_count DESC, total_quantity ASC
LIMIT 5;

#Extract client cards count
CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INT
RETURN(
SELECT COUNT(*)
FROM customers as c
JOIN orders AS o ON c.id=o.customer_id
JOIN orders_products AS op ON o.id=op.order_id
WHERE c.first_name=name
GROUP BY c.id);

CREATE FUNCTION udf_customer_products_count2(name VARCHAR(30))
RETURNS INT
BEGIN
DECLARE count_of_products INT;
SET count_of_products := (SELECT COUNT(c.id)
FROM customers as c
JOIN orders AS o ON c.id=o.customer_id
JOIN orders_products AS op ON o.id=op.order_id
WHERE c.first_name=name
GROUP BY c.id);
RETURN count_of_products;
END;

# Reduce price
CREATE  PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
UPDATE products AS p
JOIN reviews r on p.review_id=r.id
JOIN categories c on c.id=p.category_id
SET p.price=p.price*0.7
WHERE c.name=category_name
AND r.rating< 4;
END;