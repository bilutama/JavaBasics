USE university;

-- #1 Количество студентов для указанной формы обучения --
-- 1.2 Количество студентов по всем формам обучения
SELECT educationForm, COUNT(studentId)
FROM student
GROUP BY educationForm;

-- 1.2 Количество студентов для выбранной формы обучения
SET @educationForm = 'дневная';

SELECT educationForm, COUNT(studentId)
FROM student
GROUP BY educationForm
HAVING educationForm = @educationForm;

-- #2 Часы и форма отчетности по дисциплине --
-- 2.1 Запрос по названию дисциплины
SET @disciplineName = 'Философия';

SELECT name AS disciplineName, hours, reportingForm
FROM discipline
WHERE name = @disciplineName;

-- 2.2 Запрос по id дисциплины
SELECT name AS disciplineName, hours, reportingForm
FROM discipline
WHERE id = 4;

-- #3 N студентов с лучшим баллом в порядке убывания --
-- Чтобы выбрать N студентов, можно использовать LIMIT,
-- но при этом нижняя часть списка может быть отброшена несправедливо,
-- т.е. могут частично исключиться студенты с тем же средним баллом, что и оставшиеся.
-- Логичнее фильтровать по самому среднему баллу,
-- при этом заранее не будет известно количество студентов (могут остаться все, например),
-- но правило выбора будет справедливым.

-- 3.1 Вариант с LIMIT --
SELECT gradebook.studentId, student.firstName,
	student.surname, AVG(gradebook.grade) AS averageGrade
FROM gradebook
INNER JOIN student
	ON gradebook.studentId = student.id
GROUP BY gradebook.studentId
ORDER BY averageGrade DESC
LIMIT 10;

-- 3.2 Вариант с минимальным средним баллом --
SELECT gradebook.studentId, student.firstName,
	student.surname, AVG(gradebook.grade) AS averageGrade
FROM gradebook
INNER JOIN student
	ON gradebook.studentId = student.id
GROUP BY gradebook.studentId
HAVING averageGrade >= 4.25
ORDER BY averageGrade DESC

-- #4 Студенты со стипендией после сессии --
-- Год, семестр и минимальная допустимая оценка в зачетке задаются через переменные.
-- Сейчас установлена 4, то есть для получения стипендии нужно закончить без троек.
SET @minimumGradeForScholarship = 4;
SET @sessionYear = 2018;
SET @sessionTerm = 1;

SELECT gradebook.studentId, student.firstName, student.surname
FROM gradebook
INNER JOIN student
	ON gradebook.studentId = student.id
WHERE gradebook.year = @sessionYear AND gradebook.term = @sessionTerm
GROUP BY gradebook.studentId
HAVING MIN(gradebook.grade) >= @minimumGradeForScholarship
ORDER BY gradebook.studentId;

-- #5 Дисциплина, по которой студенты лучше всего учатся --
-- 5.1 Выводим список дисциплин со средним баллом студентов по ним, сортируем по убыванию.
SELECT name AS disciplineName, AVG(gradebook.grade) AS averageGrade
FROM discipline
LEFT JOIN gradebook
	ON discipline.name = gradebook.discipline
GROUP BY name
ORDER BY averageGrade DESC;

-- 5.2 Выбираем первую дисциплину из списка
SELECT name AS disciplineName, AVG(gradebook.grade) AS averageGrade
FROM discipline
LEFT JOIN gradebook
	ON discipline.name = gradebook.discipline
GROUP BY name
ORDER BY averageGrade DESC
LIMIT 1;

-- #6 Студенты, учащиеся лучше среднего --
-- Расчитываем средний балл по всем студентам
-- и оставляем только тех, у кого средний балл выше среднего по университету
SELECT gradebook.studentId, student.firstName,
	student.surname, AVG(gradebook.grade) AS averageGrade
FROM gradebook
INNER JOIN student
	ON gradebook.studentId = student.id
GROUP BY gradebook.studentId
HAVING averageGrade > (SELECT AVG(gradebook.grade) FROM gradebook)
ORDER BY averageGrade DESC;