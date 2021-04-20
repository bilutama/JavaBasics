USE university;

-- #1 Количество студентов для указанной формы обучения --
SELECT educationForm, COUNT(studentId)
FROM student
GROUP BY educationForm;

-- #2 Часы и форма отчетности по дисциплине --
SET @disciplineName = 'Философия';

SELECT name AS discipline, hours, reportFormat
FROM discipline
WHERE name = @disciplineName;

-- #3 N студентов с лучшим баллом в порядке убывания --
-- Чтобы выбрать N студентов, можно использовать LIMIT,
-- но нужно помнить, что нижняя часть списка может быть отброшена несправедливо,
-- т.е. могут частично исключиться студенты с тем же средним баллом, что и оставшиеся.
-- Логичнее фильтровать по самому среднему баллу,
-- при этом заранее не будет известно количество студентов (могут остаться все, например),
-- но правило выбора будет справедливым.
SELECT gradebook.studentId, student.firstName,
	student.surname, AVG(gradebook.grade) AS averageGrade
FROM gradebook
INNER JOIN student
	ON gradebook.studentId = student.id
GROUP BY gradebook.studentId
HAVING averageGrade >= 4.25
ORDER BY averageGrade DESC
-- LIMIT 10;

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


-- #6 Студенты, учащиеся лучше среднего --
