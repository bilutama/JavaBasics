USE shop;

-- #2
SELECT name as product, YEAR(best_before) AS best_before_year,
	MONTH(best_before) AS best_before_month,
    DAY(best_before) AS best_before_day
FROM products;

-- #3
SELECT YEAR(best_before) AS best_before_year, COUNT(name) AS product_count
FROM products
GROUP BY YEAR(best_before)
ORDER BY best_before_year;