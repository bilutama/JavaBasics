USE shop;
SELECT * FROM products;
SELECT name, price FROM products;

SELECT name, lastName, CONCAT(lastName, ' ', name) AS fullName
FROM people;
-- AS задает алиас полученному столбцу

SELECT * FROM products
WHERE price > 100 AND name <> 'Intel';
ORDER BY price;
-- AND / OR / NOT

SELECT * FROM products
ORDER BY name ASC, price DESC;

SELECT * FROM people
ORDER BY CONCAT(name,' ', lastName) DESC;

SELECT * FROM products
WHERE NOT (price >= 30 AND price <=100);

SELECT * FROM products
WHERE name IS NOT NULL;

-- LIKE - совпадение по шаблону
-- % - любое число символов (в т.ч. 0)
-- _ - один символ
-- экранирование через \
SELECT * FROM products
WHERE name LIKE 'Intel%';

SELECT * FROM products
WHERE price BETWEEN 30 AND 100; -- включая граничные значения

SELECT * FROM requests
WHERE status = 1 OR status = 2;

SELECT * FROM requests
WHERE status IN (1,2);