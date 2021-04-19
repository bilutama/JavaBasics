USE university;

-- #1 Количество студентов для указанной формы обучения
SELECT educationForm, COUNT(studentId)
FROM student
GROUP BY educationForm;

-- #2 Часы и форма отчетности по дисциплине
SET @disciplineName = 'Философия';

SELECT name as discipline, hours, reportFormat
FROM discipline
WHERE name = @disciplineName;

-- #3 N студентв с лучшим баллом в порядке убывания

-- #4 Студенты со стипендией после сессии

-- #5 Дисциплина, по которой студенты лучше всего учатся

-- #6 Студенты, учащиеся лучше среднего