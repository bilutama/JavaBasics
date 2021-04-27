USE employees;

-- #1 Список сотрудников в формате: Сотрудник, Отдел сотрудника, Руководитель, Отдел руководителя
SELECT e.name AS employee, employee_department.name AS employee_department,
	c.name AS chief_name, chief_department.name AS chief_department
FROM employee AS e
LEFT JOIN department AS employee_department
    ON e.department_id = employee_department.id
LEFT JOIN employee AS c
	ON e.chief_id = c.id
LEFT JOIN department AS chief_department
	ON c.department_id = chief_department.id;

-- #2 Список сотрудников, получающих заработную плату, большую чем у непосредственного руководителя
-- для проверки также выводится имя и зарплата руководителя
SELECT e.name AS employee, e.salary AS employee_salary, c.name AS chief, c.salary AS chief_salary
FROM employee AS e
LEFT JOIN employee AS c
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
SELECT department_id, COUNT(name) AS employeesCount
FROM employee
GROUP BY department_id
HAVING COUNT(name) <= 3
ORDER BY department_id;

-- #5 Список сотрудников, не имеющих назначенного руководителя, работающего в том же отделе
-- другими словами, department_id сотрудника не равен department_id его руководителя
SELECT department_id, name AS employee
FROM employee AS e
WHERE department_id <> (SELECT department_id
						FROM employee
                        WHERE id = e.chief_id);

-- #6 Список наименований отделов с максимальной суммарной зарплатой сотрудников
SELECT d.name AS departmentName, SUM(e.salary) AS departmentSalary
FROM employee AS e
LEFT JOIN department AS d
	ON e.department_id = d.id
GROUP BY e.department_id
HAVING departmentSalary = (SELECT SUM(salary)
							FROM employee
                            GROUP BY department_id
                            ORDER BY SUM(salary) DESC
                            LIMIT 1);

-- #7 ФИО сотрудника(ов), получающего третью по величине зарплату в организации
SELECT name AS employee, salary
FROM employee AS e
WHERE salary = (SELECT DISTINCT salary
				FROM employee
                ORDER BY salary DESC
                LIMIT 2, 1);