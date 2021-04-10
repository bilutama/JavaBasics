-- #1
USE world;

SELECT Name, District
FROM City;

-- #2
SELECT Name
FROM City
WHERE CountryCode = 'RUS'
ORDER BY Name;

-- #3 CountryCodes are taken from 'country' table
SELECT Name
FROM City
WHERE CountryCode IN ('ESP', 'PRT', 'GRC')
ORDER BY Name DESC;

-- #4 Population in range
SELECT Name, Population
FROM City
WHERE Population BETWEEN 300000 AND 500000
ORDER BY Population;

-- #5 City names begin with 'a'
SELECT Name
FROM City
WHERE Name LIKE 'a%';

-- #6 city names contain 'a'
SELECT Name
FROM City
WHERE Name LIKE '%a%';

-- #7 Megalopolises in Russia, sorted by Population in ascending order
SELECT Name, Population
FROM City
WHERE CountryCode = 'RUS' AND Population >= 1000000
ORDER BY Population;

-- #8 Spain cities with name begins with 'a' and Greece with population less than 200000
SELECT Name, CountryCode, Population
FROM City
WHERE (CountryCode = 'ESP' AND Name LIKE 'a%')
    OR (CountryCode = 'GRC' AND Population < 200000)
ORDER BY CountryCode, Name;