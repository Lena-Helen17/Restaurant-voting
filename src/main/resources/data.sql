INSERT INTO USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES ('user@gmail.com', 'User_First', 'User_Last', '{noop}password'),
       ('admin@mail.ru', 'Admin_First', 'Admin_Last', '{noop}admin'),
       ('user2@mail.ru', 'User_Two', 'User2_Last', '{noop}password2'),
       ('user3@mail.ru', 'User_3', 'User3_Last', '{noop}password3'),
       ('user4@mail.ru', 'User_4', 'User4_Last', '{noop}password4'),
       ('user5@mail.ru', 'User_5', 'User5_Last', '{noop}password5');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 3),
       ('USER', 4),
       ('USER', 5),
       ('USER', 6);

INSERT INTO RESTAURANT (NAME, ADDRESS)
VALUES ('Restaurant_First', 'Adress_First'),
       ('Restaurant_Second', 'Adress_2'),
       ('Restaurant_Third', 'Адрес_3'),
       ('Restaurant_Fourth', 'Адрес_4'),
       ('Restaurant_Fifth','Адрес_5'),
       ('Restaurant_Second', 'Адрес_6'),
       ('Restaurant_Third', 'Адрес_7'),
       ('Restaurant_Fourth', 'Адрес_8'),
       ('Restaurant_Fifth','Адрес_10');

INSERT INTO MEAL ( DATE_TIME, NAME, PRICE, RESTAURANT_ID)
VALUES ('2022-01-09', 'Первое', 500.20, 1),
       ('2022-01-09', 'Второе', 1000.0, 1),
       ('2022-01-09', 'Чай', 510.2, 1),
       ('2022-01-09', 'Борщ', 100, 3),
       ('2022-01-09', 'Лазанья', 500, 3),
       ('2022-01-09', 'Жаркое', 120, 3),
       ('2022-01-09', 'Карбанара', 510, 1),
       ('2022-01-09', 'Пицца', 210, 2),
       ('2022-01-09', 'Компот', 159.99, 2);

INSERT INTO VOTING (USER_ID, RESTAURANT_ID, DATE_VOTING)
VALUES (1, 1, '2022-01-22'),
       (3, 5, '2022-01-22'),
       (4, 5, '2022-01-09'),
       (6, 2, '2022-01-22'),
       (2, 5, '2022-01-22');
