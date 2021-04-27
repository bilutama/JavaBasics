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
	id INT AUTO_INCREMENT PRIMARY KEY,
	department_id INT,
	chief_id INT NULL,
	name VARCHAR(255) NOT NULL,
	salary INT NOT NULL,
	FOREIGN KEY (department_id) REFERENCES department(id)
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
(3, NULL, 'Никифоров Валентин', 100),
(3, 3, 'Титов Оскар', 80),
(4, NULL, 'Попов Остап', 100),
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

ALTER TABLE employee
ADD CONSTRAINT chiefs FOREIGN KEY (chief_id) REFERENCES employee(id);