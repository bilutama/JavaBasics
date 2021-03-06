USE employees;

-- #1 Список сотрудников в формате: Сотрудник, Отдел сотрудника, Руководитель, Отдел руководителя
SELECT e.name AS employee, employee_department.name AS employee_department,
	c.name AS chief_name, chief_department.name AS chief_department
FROM employee AS e
INNER JOIN department AS employee_department
    ON e.department_id = employee_department.id
LEFT JOIN employee AS c
	ON e.chief_id = c.id
LEFT JOIN department AS chief_department
	ON c.department_id = chief_department.id;

-- #2 Список сотрудников, получающих заработную плату, большую чем у непосредственного руководителя
-- для проверки также выводится имя и зарплата руководителя
SELECT e.name AS employee, e.salary AS employee_salary, c.name AS chief, c.salary AS chief_salary
FROM employee AS e
INNER JOIN employee AS c
    ON e.chief_id = c.id
WHERE e.salary > c.salary;

-- #3 список сотрудников, получающих максимальную заработную плату в своем отделе
SELECT department_id, name AS employee, salary
FROM employee AS e
WHERE salary = (SELECT MAX(salary)
				FROM employee
                WHERE department_id = e.department_id)
ORDER BY department_id;

-- #4 Список ID отделов, количество сотрудников в которых не превышает 3 человек
SELECT department.id AS departmentId, COUNT(employee.name) AS employeesCount
FROM department
LEFT JOIN employee
	ON department.id = employee.department_id
GROUP BY department.id
HAVING COUNT(employee.name) <= 3
ORDER BY department.id;

-- #5 Список сотрудников, не имеющих назначенного руководителя, работающего в том же отделе.
-- Другими словами, department_id сотрудника не равен department_id его руководителя,
-- в том числе учитываются сотрудники без руководителя.
SELECT e.department_id, e.name AS employee
FROM employee AS e
LEFT JOIN employee AS c
	ON e.chief_id = c.id
WHERE e.department_id <> c.department_id OR c.department_id IS NULL;

-- #6 Список наименований отделов с максимальной суммарной зарплатой сотрудников
SELECT ds.departmentId, ds.departmentName, ds.departmentSalary
FROM
(
	SELECT d.id AS departmentId, d.name AS departmentName,
	    (CASE WHEN SUM(e.salary) IS NULL THEN 0 ELSE SUM(e.salary) END) AS departmentSalary
	FROM department AS d
	LEFT JOIN employee AS e
		ON d.id = e.department_id
	GROUP BY d.id, d.name
) AS ds
WHERE ds.departmentSalary = (SELECT MAX(dsMaximum.departmentSalary)
								FROM
								(
									SELECT (CASE WHEN SUM(salary) IS NULL THEN 0 ELSE SUM(salary) END) AS departmentSalary
									FROM employee
									GROUP BY department_id
								) AS dsMaximum
							);

-- #7 ФИО сотрудника(ов), получающего третью по величине зарплату в организации
-- Переменная с порядковым номером максимальной зарплаты
SET @maximumSalaryIndex = 3;

-- Для проверки выводим зарплаты персонала по убыванию
-- В данном случае третья - 110
SELECT DISTINCT salary
FROM employee
ORDER BY salary DESC;

-- Вывод сотрудников с максимальной зарплатой указанного в переменной @maximumSalaryIndex порядке
SELECT ee.name AS employee, ee.salary
FROM employee AS ee
WHERE @maximumSalaryIndex = (SELECT COUNT(DISTINCT salary)
                            FROM employee AS es
                            WHERE ee.salary <= es.salary);