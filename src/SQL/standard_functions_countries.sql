USE world;

-- #1
SELECT UPPER(name) AS Name, LOWER(continent) AS Continent
FROM country
ORDER BY CHAR_LENGTH(name) DESC, name;

-- #2
SELECT name, SQRT(SurfaceArea / PI()) AS Radius
FROM country
ORDER BY Radius DESC, name;