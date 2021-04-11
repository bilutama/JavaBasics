USE world;

-- #1
SELECT DISTINCT Continent
FROM country
WHERE SurfaceArea >= 950000
ORDER BY Continent;

-- #2
SELECT name, SurfaceArea
FROM country
ORDER BY SurfaceArea DESC
LIMIT 5;

-- #3
SELECT name, SurfaceArea
FROM country
ORDER BY SurfaceArea DESC
LIMIT 5, 5;