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
LEFT JOIN posmSet
	ON posmSet.id = posmSetItem.posmSetId
LEFT JOIN formPosmSetTask
	ON formPosmSetTask.posmSetId = posmSet.id
LEFT JOIN placePosmTask
	ON placePosmTask.formPosmSetTaskId = formPosmSetTask.id
GROUP BY posmItem.name;

-- #6 Количество единиц каждого вида POSm, отправленные каждому агенту.
-- Я не очень понял нужно ли показать полное количество POSm, предназначенных для каждого агента
-- т.е. без учета статуса задач. Поэтому сделал оба варианта:
-- #6.1 Количество единиц каждого вида POSm, отправленные каждому агенту и полученные, т.е. статус задачи 2 - "выполнена".
SET @status = 2;

SELECT placePosmTask.agentCode,
	SUM(CASE WHEN placePosmTask.status = @status AND posmItem.id = 1 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS 'Блокнот',
    SUM(CASE WHEN placePosmTask.status = @status AND posmItem.id = 2 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS 'Календарь',
    SUM(CASE WHEN placePosmTask.status = @status AND posmItem.id = 3 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS 'Кубарик',
    SUM(CASE WHEN placePosmTask.status = @status AND posmItem.id = 4 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS 'Пакет',
    SUM(CASE WHEN placePosmTask.status = @status AND posmItem.id = 5 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS 'Ручка'
FROM placePosmTask
LEFT JOIN formPosmSetTask
	ON placePosmTask.formPosmSetTaskId = formPosmSetTask.id
LEFT JOIN posmSet
	ON formPosmSetTask.posmSetId = posmSet.id
LEFT JOIN posmSetItem
	ON posmSet.id = posmSetItem.posmSetId
LEFT JOIN posmItem
	ON posmSetItem.posmItemId = posmItem.id
GROUP BY placePosmTask.agentCode;

-- #6.2 Количество единиц каждого вида POSm, предназначенные для каждого агента (доставленные и недоставленные), т.е. без учета статуса задачи.
SELECT placePosmTask.agentCode,
	SUM(CASE WHEN posmItem.id = 1 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS 'Блокнот',
    SUM(CASE WHEN posmItem.id = 2 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS 'Календарь',
    SUM(CASE WHEN posmItem.id = 3 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS 'Кубарик',
    SUM(CASE WHEN posmItem.id = 4 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS 'Пакет',
    SUM(CASE WHEN posmItem.id = 5 THEN posmSetItem.posmItemsCount * placePosmTask.posmSetsCount ELSE 0 END) AS 'Ручка'
FROM placePosmTask
LEFT JOIN formPosmSetTask
	ON placePosmTask.formPosmSetTaskId = formPosmSetTask.id
LEFT JOIN posmSet
	ON formPosmSetTask.posmSetId = posmSet.id
LEFT JOIN posmSetItem
	ON posmSet.id = posmSetItem.posmSetId
LEFT JOIN posmItem
	ON posmSetItem.posmItemId = posmItem.id
GROUP BY placePosmTask.agentCode;

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