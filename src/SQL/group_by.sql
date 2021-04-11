USE world;

-- #1 Countries and average population in their cities
SELECT countryCode, AVG(population) AS averageCityPopulation, COUNT(name) AS cityCount
FROM city
GROUP BY countryCode
ORDER BY averageCityPopulation DESC;

-- #2 Countries with city count
SELECT countryCode, COUNT(name) AS cityCount
FROM city
GROUP BY countryCode
ORDER BY cityCount DESC;

-- #3 Countries that have more that 2 cities with city count
SELECT countryCode, COUNT(name) AS cityCount
FROM city
GROUP BY countryCode
HAVING COUNT(name) >= 2
ORDER BY cityCount DESC;

-- #4 Countries with at least 2 cities that have population more than 1000000
SELECT countryCode, COUNT(name) AS cityCount
FROM city
WHERE population > 1000000
GROUP BY countryCode
HAVING COUNT(name) >= 2
ORDER BY cityCount DESC;