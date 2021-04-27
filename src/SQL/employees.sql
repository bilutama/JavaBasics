-- department
-- employee

DROP DATABASE employees;

CREATE DATABASE employees;

USE employees;

CREATE TABLE department
(
	id INT AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE employee
(
	id INT AUTO_INCREMENT,
	department_id INT,
	chief_id INT,
	name VARCHAR(255) NOT NULL,
	salary INT NOT NULL,
	PRIMARY KEY (id)
	FOREIGN KEY (chief_id) REFERENCES employee(id)
	    ON UPDATE CASCADE
);

INSERT INTO department (name)
VALUES ('Отдел 1'),
('Отдел 2'),
('Отдел 3'),
('Отдел 4'),
('Отдел 5');

INSERT INTO employee (department_id, chief_id, name, salary)
VALUES (5, 6, 'Иванов Емельян', 60),
(4, 4, 'Кузнецов Семен', 50),
(5, 6, 'Егоров Иннокентий', 70),
(5, 3, 'Кулаков Игорь', 80),
(5, 5, 'Фомичёв Гаянэ', 90),
(5, 1, 'Елисеев Гурий', 50),
(5, 3, 'Казаков Аввакуум', 50),
(3, 0, 'Никифоров Валентин', 100),
(3, 3, 'Титов Оскар', 80),
(4, 0, 'Попов Остап', 100),
(3, 2, 'Ермаков Моисей', 60),
(1, 5, 'Колесников Оскар', 70),
(5, 7, 'Симонов Лавр', 90),
(3, 6, 'Бирюков Остап', 100),
(5, 5, 'Королёв Артем', 60),
(1, 7, 'Уваров Мартын', 70),
(4, 7, 'Харитонов Рубен', 120),
(1, 1, 'Осипов Ефим', 120),
(1, 8, 'Бирюков Дональд', 60),
(3, 8, 'Субботин Леонард', 90),
(5, 7, 'Куликов Вадим', 130),
(3, 10, 'Давыдов Илья', 90),
(3, 4, 'Галкин Соломон', 70),
(2, 5, 'Веселов Корнелий', 30),
(3, 9, 'Мамонтов Севастьян', 110),
(1, 7, 'Жданов Ермак', 70),
(1, 10, 'Павлов Даниил', 70),
(5, 10, 'Калашников Юлий', 110),
(2, 7, 'Кондратьев Михаил', 110),
(2, 2, 'Овчинников Юстиниан', 100);



USE employees;

-- #1 список сотрудников в формате: Сотрудник, Отдел сотрудника, Руководитель, Отдел руководителя
SELECT e.name AS employee, employee_department.name AS employee_department,
	c.name AS chief_name, chief_department.name AS chief_department
FROM employee AS e
LEFT JOIN department AS employee_department
    ON e.department_id = employee_department.id
LEFT JOIN employee AS c
	ON e.chief_id = c.id
LEFT JOIN department AS chief_department
	ON c.department_id = chief_department.id;

-- #2 список сотрудников, получающих заработную плату, большую чем у непосредственного руководителя
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

-- #4
SELECT department_id, COUNT(name) AS employeesCount
FROM employee
GROUP BY department_id
HAVING COUNT(name) <= 3
ORDER BY department_id;

-- #5 список сотрудников, не имеющих назначенного руководителя, работающего в том же отделе
-- другими словами, department_id сотрудника не равен department_id его руководителя
SELECT name AS employee, department_id
FROM employee AS e
WHERE department_id <> (SELECT department_id
						FROM employee
                        WHERE id = e.chief_id);

-- #6 список наименований отделов с максимальной суммарной зарплатой сотрудников
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