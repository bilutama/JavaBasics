-- #1

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
    best_before DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
        ON UPDATE CASCADE
);

INSERT INTO categories(name)
VALUES ('Diary'), ('Bakery'), ('Beverages');

INSERT INTO products(name, price, best_before, category_id)
VALUES ('Milk', 95, '2020-12-20', 1), ('Yogurt', 105, '2020-12-28', 1),
    ('Bun', 80, '2021-01-05', 2), ('Bread', 105, '2021-01-08', 2),
    ('Lemonade', 110, '2021-04-18', 3), ('Water', 60, '2021-03-15', 3);