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
);

DELIMITER $$
CREATE PROCEDURE add_categories()
BEGIN
    DECLARE categoriesCount INT DEFAULT 100;
    DECLARE productsCount INT DEFAULT 5000;
    DECLARE minimumPrice INT DEFAULT 50;
    DECLARE maximumPrice INT DEFAULT 500;
    -- создание категорий
    DECLARE i INT DEFAULT 1;
    WHILE i <= categoriesCount DO
        INSERT INTO categories(name)
        VALUES (CONCAT('category_', i));
        SET i = i + 1;
    END WHILE;
    -- создание товаров
    SET i = 1;
    WHILE i <= productsCount DO
            INSERT INTO products(name, price, category_id)
            VALUES (CONCAT('product_', i), FLOOR(RAND() * (maximumPrice - minimumPrice + 1) + minimumPrice),
                FLOOR(RAND() * categoriesCount + 1));
            SET i = i + 1;
    END WHILE;
END $$
DELIMITER ;

CALL add_categories();

-- Проверка созданной БД
SELECT COUNT(name) AS productsCount,
	COUNT(DISTINCT category_id) AS categoriesCount,
    MIN(price) AS minPrice,
    MAX(price) AS maxPrice
FROM products;