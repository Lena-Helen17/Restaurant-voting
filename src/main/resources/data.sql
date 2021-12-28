INSERT INTO USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES ('user@gmail.com', 'User_First', 'User_Last', '{noop}password'),
       ('admin@mail.ru', 'Admin_First', 'Admin_Last', '{noop}admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO RESTAURANTS (NAME)
VALUES ('Restaurant_First'),
       ('Restaurant_Second'),
       ('Restaurant_Third'),
       ('Restaurant_Fourth'),
       ('Restaurant_Fifth');

INSERT INTO MENU (FOOD_NAME, PRICE, DATE_FOOD, RESTAURANTS_ID)
VALUES ('Food_First', '250.50', '2020-01-30', 1),
       ('Food_Second', '350.50', '2020-01-30', 1),
       ('Food_Third', '150.00', '2020-01-30', 1),
       ('Food_First', '250.50', '2020-02-03', 4),
       ('Food_Second', '350.50', '2020-02-03', 4),
       ('Food_Third', '150.00', '2020-02-03', 4),
       ('Food_First', '250.50', '2020-01-03', 2),
       ('Food_Second', '350.50', '2020-01-30', 2),
       ('Food_Third', '150.00', '2020-01-30', 2),
       ('Food_First', '250.50', '2020-01-30', 3),
       ('Food_Second', '350.50', '2020-01-30', 3),
       ('Food_First', '250.50', '2020-01-30', 4),
       ('Food_Second', '350.50', '2020-01-30', 4),
       ('Food_Third', '150.00', '2020-01-30', 4),
       ('Food_First', '50.50', '2020-01-30', 5),
       ('Food_Second', '450.50', '2020-01-30', 5),
       ('Food_Third', '150.00', '2020-01-30', 5);

INSERT INTO VOTING (USER_ID, RESTAURANTS_ID)
VALUES (1, 1),
       (2, 5);