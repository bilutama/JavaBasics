USE merchandising;

-- #1 ФИО всех мерчендайзеров из сибирского региона (код региона 3).
SELECT merchandiser.firstName, merchandiser.lastName, merchandiser.middleName,
	city.name AS cityName
FROM merchandiser
INNER JOIN city
	ON merchandiser.cityId = city.id
WHERE city.regionId = 3;

-- #2 Информация о POSm, у которых не задан комментарий (NULL).
SELECT name, format, price
FROM posmItem
WHERE comment IS NULL;

-- #3 Город и число мерчендайзеров из этого города.
SELECT city.name, COUNT(merchandiser.cityId) AS merchandisersCount
FROM city
LEFT JOIN merchandiser
	ON city.id = merchandiser.cityId
GROUP BY city.name;

-- #4 Регион и число мерчендайзеров из этого региона.
SELECT region.name, COUNT(merchandiser.id) AS merchandisersCount
FROM region
LEFT JOIN city
	ON region.id = city.regionId
LEFT JOIN merchandiser
	ON city.id = merchandiser.cityId
GROUP BY region.name;

-- #5 Количество размещенных и неразмещенных единиц каждого вида POSm.
-- Результаты группируются по id POSm (по данным из задачи доступен один вид)
-- и статусу (1 - «в работе» и 2 - «выполнено»)
SELECT posmItem.name,
	SUM(CASE WHEN placePosmTask.status = 1 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS posmYetToPlace,
    SUM(CASE WHEN placePosmTask.status = 2 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS posmPlaced
FROM posmItem
LEFT JOIN posmSetItem
	ON posmItem.id = posmSetItem.posmItemId
LEFT JOIN formPosmSetTask
	ON formPosmSetTask.posmSetId = posmSetItem.posmSetId
LEFT JOIN placePosmTask
	ON placePosmTask.formPosmSetTaskId = formPosmSetTask.id
GROUP BY posmItem.name;

-- #6 Количество единиц каждого вида POSm, отправленные каждому агенту.
SELECT placePosmTask.agentCode, posmItem.name AS posmName,
	SUM(CASE WHEN posmSetItem.posmItemsId IS NOT NULL THEN placePosmTask.posmSetsCount * posmSetItem.posmItemsCount ELSE 0 END) AS posmCount
FROM posmItem
LEFT JOIN posmSetItem
	ON posmSetItem.posmItemId = posmItem.id
LEFT JOIN formPosmSetTask
	ON formPosmSetTask.posmSetId = posmSetItem.posmSetId
RIGHT JOIN placePosmTask
	ON formPosmSetTask.id = placePosmTask.formPosmSetTaskId
GROUP BY placePosmTask.agentCode, posmItem.name
ORDER BY placePosmTask.agentCode;

-- #7 Количество задач «в работе» и «выполнено» у каждого мерчендайзера. В том числе 0.
SELECT merchandiser.id, merchandiser.firstName, merchandiser.lastName,
	SUM(CASE WHEN placePosmTask.status = 2 THEN 1 ELSE 0 END) AS doneTasks,
    SUM(CASE WHEN placePosmTask.status = 1 THEN 1 ELSE 0 END) AS tasksInProgress
FROM merchandiser
LEFT JOIN placePosmTask
	ON merchandiser.id = placePosmTask.merchandiserId
GROUP BY merchandiser.id, merchandiser.firstName, merchandiser.lastName;

-- #8 Найдите агентов, у которых более 2 задач на размещение, выведите для каждого из них количество задач.
-- Поскольку не уточняется статус задач, то выводятся все («в работе» и «выполнено») - считаем по id задачи.
-- После фильтрации агент остается только один (с кодом 10187).
SELECT placePosmTask.agentCode, COUNT(placePosmTask.id) AS tasksCount
FROM placePosmTask
GROUP BY placePosmTask.agentCode
HAVING COUNT(placePosmTask.name) > 2
ORDER BY tasksCount DESC;
