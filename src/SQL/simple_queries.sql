-- #1
USE world;

SELECT Name, District
FROM City;

-- #2
USE world;

SELECT Name
FROM City
WHERE CountryCode = 'RUS'
ORDER BY Name ASC;

-- #3 CountryCodes are taken from 'country' table
USE world;

SELECT Name
FROM City
WHERE CountryCode IN ('ESP','PRT','GRC')
ORDER BY Name DESC;

-- #4 Population in range
USE world;

SELECT Name, Population
FROM City
WHERE Population BETWEEN 300000 AND 500000
ORDER BY Population ASC;

-- #5 City names begin with 'a'
USE world;

SELECT Name
FROM City
WHERE Name LIKE 'a%';

-- #6 city names contain 'a'
USE world;

SELECT Name
FROM City
WHERE Name LIKE '%a%';

-- #7 Megalopolises in Russia, sorted by Population in ascending order
USE world;

SELECT Name, Population
FROM City
WHERE CountryCode = 'RUS' AND Population >= 1000000
ORDER BY Population ASC;

-- #8 Spain cities with name begins with 'a' and Greece with population less than 100000
USE world;

SELECT Name, CountryCode, Population
FROM City
WHERE (CountryCode = 'ESP' AND Name LIKE 'a%')
    OR (CountryCode = 'GRC' AND Population < 200000)
ORDER BY CountryCode ASC, Name ASC;