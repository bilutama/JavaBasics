-- #1
USE world;

SELECT CountryCode, AVG(population) AS average_population
FROM City
GROUP BY CountryCode
ORDER BY average_population DESC;

-- #2, 3
SELECT CountryCode, COUNT(Name) AS cityCount
FROM City
GROUP BY CountryCode
HAVING COUNT(Name) >= 2;
ORDER BY cityCount;

-- #4
SELECT CountryCode, COUNT(Name) AS cityCount
FROM City
GROUP BY CountryCode
HAVING COUNT(Name) >= 2 AND population > 1000000;
ORDER BY cityCount;



USE shop;
SELECT clientName, COUNT(*) AS ordersCount
FROM orders;
GROUP BY clientName
HAVING COUNT(*) >= 2;
ORDER BY ordersCount DESC;