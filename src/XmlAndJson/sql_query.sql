CREATE DATABASE shop;

USE shop;

CREATE TABLE categories
(
id INT AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE products
(
    id INT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

INSERT INTO categories(name)
VALUES ('Diary'), ('Bakery'), ('Beverages');

INSERT INTO products(name, price, category_id)
VALUES ('Milk', 120, 1), ('Bun', 80, 2), ('Lemonade', 110, 3);