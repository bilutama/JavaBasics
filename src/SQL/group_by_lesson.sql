USE shop;
SELECT clientName, COUNT(*) AS ordersCount
FROM orders;
GROUP BY clientName
HAVING COUNT(*) >= 2;
ORDER BY ordersCount DESC;

-- Aggregate functions
-- MAX, MIN, COUNT, AVG, SUM

-- COUNT(* / columnName (not null) / DISTINCT columnName (for unique numbers))