USE world;

-- #1 код страны, название страны и название города столицы
SELECT country.code, country.name, city.name
FROM country
INNER JOIN city
	ON country.capital = city.id;

-- #2 имя города, его численность, код и название его страны
SELECT city.name, city.population, city.countrycode, country.name
FROM city
INNER JOIN country
	ON city.countrycode = country.code;

-- #3 количество городов по континентам
SELECT country.Continent, COUNT(city.name)
FROM country
LEFT JOIN city
	ON country.code = city.countryCode
GROUP BY country.continent;

-- #4 количество официальных языков по странам, в порядке убывания
SELECT country.name, COUNT(countryLanguage.language) as languageCount
FROM country
INNER JOIN countrylanguage
	ON country.code = countryLanguage.countryCode
GROUP BY countryLanguage.countryCode
ORDER BY languageCount DESC;