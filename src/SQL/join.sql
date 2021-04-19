USE world;

-- #1.1 CROSS JOIN таблиц стран и городов - тестовый запрос для одного города.
-- Таблица не имеет смысла, так как все страны сопоставляются со всеми городами без критериев.
-- Использован DISTINCT, поскольку одноименные города встречаются в разных странах.
-- Для примера выбран город Cambridge (есть в Великобритании, США и Канаде) - видим, что сейчас не повторяется.
SELECT DISTINCT country.name AS countryName, city.name AS cityName
FROM country
CROSS JOIN city
WHERE city.name = 'Cambridge'
ORDER BY countryName;

-- #1.2 CROSS JOIN для всех уникальных городов
-- Для проверки выведем первые 10000 записей (по умолчанию было 1000).
SELECT DISTINCT country.name AS countryName, city.name AS cityName
FROM country
CROSS JOIN city
ORDER BY countryName, cityName
LIMIT 10000;

-- #2 код страны, название страны и название города столицы
SELECT country.code, country.name AS countryName, city.name AS cityName
FROM country
INNER JOIN city
	ON country.capital = city.id;

-- #3 имя города, его численность, код и название его страны
SELECT city.name AS cityName, city.population, city.countryCode, country.name AS countryName
FROM city
INNER JOIN country
	ON city.countryCode = country.code;

-- #4 количество городов по континентам
SELECT country.continent, COUNT(city.name) as cityCount
FROM country
LEFT JOIN city
	ON country.code = city.countryCode
GROUP BY country.continent;

-- #5 количество официальных языков по странам, в порядке убывания
-- Если выбирать только из тех стран, где есть хотя бы 1 язык, используем INNER JOIN.
-- Если считать языки по всем странам из таблицы country, используем LEFT JOIN,
-- тогда в список добавятся такие территории как Антарктика и Французские Южные Территории -
-- сейчас выбраны все территории (LEFT JOIN).
SELECT country.name AS countryName,
	SUM(CASE WHEN isOfficial = 'T' THEN 1 ELSE 0 END) AS languageCount
FROM country
LEFT JOIN countryLanguage
	ON countryLanguage.countryCode = country.code
GROUP BY country.name
ORDER BY languageCount DESC;