INSERT INTO USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES ('user@gmail.com', 'User_First', 'User_Last', '{noop}password'),
       ('admin@mail.ru', 'Admin_First', 'Admin_Last', '{noop}admin'),
       ('user2@mail.ru', 'User_Two', 'User2_Last', '{noop}password2'),
       ('user3@mail.ru', 'User_3', 'User3_Last', '{noop}password3'),
       ('user4@mail.ru', 'User_4', 'User4_Last', '{noop}password4'),
       ('user5@mail.ru', 'User_5', 'User5_Last', '{noop}password5');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2);

INSERT INTO RESTAURANT (NAME, ADDRESS)
VALUES ('Restaurant_First', 'Food_First'),
       ('Restaurant_Second', 'Food_First'),
       ('Restaurant_Third', 'Food_First'),
       ('Restaurant_Fourth', 'Food_First'),
       ('Restaurant_Fifth','Food_First'),
       ('Restaurant_Second', 'Food_First'),
       ('Restaurant_Third', 'Food_First'),
       ('Restaurant_Fourth', 'Food_First'),
       ('Restaurant_Fifth','Food_First');

INSERT INTO MEAL ( DATE_TIME, NAME, PRICE, RESTAURANT_ID)
VALUES ('2020-01-30 10:00:00', 'Первое', 500.20, 1),
       ('2020-01-30 13:00:00', 'Второе', 1000.0, 1),
       ('2020-01-30 20:00:00', 'Чай', 50, 1),
       ('2020-01-31 0:00:00', 'Еда на граничное значение', 100, 3),
       ('2020-01-31 10:00:00', 'Завтрак', 500, 3),
       ('2020-01-31 13:00:00', 'Обед', 1000, 3),
       ('2020-01-31 20:00:00', 'Ужин', 510, 1),
       ('2020-01-31 14:00:00', 'Админ ланч', 510, 2),
       ('2020-01-31 21:00:00', 'Админ ужин', 1500, 2);

INSERT INTO VOTING (USER_ID, RESTAURANT_ID, DATE_VOTING)
VALUES (1, 1, '2022-01-09'),
       (3, 5, '2022-01-09'),
       (4, 5, '2022-01-09'),
       (6, 2, '2022-01-09'),
       (2, 5, '2022-01-09');
