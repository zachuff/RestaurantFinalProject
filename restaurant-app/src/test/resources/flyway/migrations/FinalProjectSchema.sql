DROP TABLE IF EXISTS restaurant_location;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS restaurant;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
customer_id INT NOT NULL AUTO_INCREMENT,
phone_number VARCHAR(20),
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
PRIMARY KEY(customer_id)
);

CREATE TABLE menu(
menu_id INT NOT NULL AUTO_INCREMENT,
food_name VARCHAR(45),
food_type VARCHAR(45),
price DECIMAL(4),
PRIMARY KEY(menu_id)
);

CREATE TABLE restaurant(
restaurant_id INT NOT NULL AUTO_INCREMENT,
restaurant_name VARCHAR(45) NOT NULL,
menu_id INT NOT NULL,
customer_id INT NOT NULL,
PRIMARY KEY(restaurant_id),
FOREIGN KEY(menu_id) REFERENCES menu(menu_id),
FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE location(
location_id INT NOT NULL AUTO_INCREMENT,
street_address VARCHAR(40),
city VARCHAR(20),
state VARCHAR(20),
PRIMARY KEY (location_id)
);

CREATE TABLE restaurant_location(
restaurant_id INT NOT NULL,
location_id INT NOT NULL,
PRIMARY KEY (restaurant_id, location_id),
FOREIGN KEY(restaurant_id) references restaurant(restaurant_id),
FOREIGN KEY(location_id) REFERENCES location(location_id)
);

insert into customer (customer_id, phone_number, first_name, last_name) values (1, 1234567890, "George", "Smith");
insert into customer (customer_id, phone_number, first_name, last_name) values (2, 2345678901, "James", "Anderson");
insert into customer (customer_id, phone_number, first_name, last_name) values (3, 3456789012, "Jeremy", "White");
insert into customer (customer_id, phone_number, first_name, last_name) values (4, 4567890123, "Frank", "Adamson");
insert into customer (customer_id, phone_number, first_name, last_name) values (5, 5678901234, "Paul", "Silva");

insert into menu (menu_id, food_name, food_type, price) values (1, "spaghetti", "italian", 10.75);
insert into menu (menu_id, food_name, food_type, price) values (2,"chimichanga", "mexican", 9.50);
insert into menu (menu_id, food_name, food_type, price) values (3,"egg roll", "chinese", 4.25);
insert into menu (menu_id, food_name, food_type, price) values (4, "curry", "indian", 7.99);
insert into menu (menu_id, food_name, food_type, price) values (5, "pho", "thai", 8.59);

insert into restaurant (restaurant_id, restaurant_name, menu_id, customer_id) values (1, "Mcdonalds", 1, 1);
insert into restaurant (restaurant_id, restaurant_name, menu_id, customer_id) values (2, "KFC", 2, 2);
insert into restaurant (restaurant_id, restaurant_name, menu_id, customer_id) values (3, "Burger King", 3, 3);
insert into restaurant (restaurant_id, restaurant_name, menu_id, customer_id) values (4, "Wendys", 4, 4);
insert into restaurant (restaurant_id, restaurant_name, menu_id, customer_id) values (5, "In N Out", 5, 5);

insert into location (location_id, street_address, city, state) values (1, "123 Lincoln Road", "Los Angeles", "California");
insert into location (location_id, street_address, city, state) values (2, "456 Washington Street", "New York City", "New York");
insert into location (location_id, street_address, city, state) values (3, "789 Lindsay Boulevard", "Kansas City", "Missouri");
insert into location (location_id, street_address, city, state) values (4, "234 Jefferson Avenue", "Belton", "Texas");
insert into location (location_id, street_address, city, state) values (5, "567 Ricahrdson Lane", "Idaho Falls", "Idaho");

insert into restaurant_location (restaurant_id, location_id) values (1, 1);
insert into restaurant_location (restaurant_id, location_id) values (2, 2);
insert into restaurant_location (restaurant_id, location_id) values (3, 3);
insert into restaurant_location (restaurant_id, location_id) values (4, 4);
insert into restaurant_location (restaurant_id, location_id) values (5, 5);


select * from customer;
select * from menu;
select * from restaurant;
select * from location;
select * from restaurant_location;
