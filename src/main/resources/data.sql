INSERT INTO USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES ('user@gmail.com', 'User_First', 'User_Last', '{noop}password'),
       ('admin@mail.ru', 'Admin_First', 'Admin_Last', '{noop}admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO RESTAURANTS (NAME_RESTAURANT, FOOD_NAME_ONE, PRICE_ONE, FOOD_NAME_TWO, PRICE_TWO, FOOD_NAME_THREE, PRICE_THREE,DATE_MENU)
VALUES ('Restaurant_First', 'Food_First', '250.50', 'Food_Second', '350.50', 'Food_Third', '150.00', '2022-01-05'),
       ('Restaurant_Second', 'Food_First', '200.50', 'Food_Second', '300.50', 'Food_Third', '100.00', '2022-01-05' ),
       ('Restaurant_Third', 'Food_First', '200.50', 'Food_Second', '300.50', 'Food_Third', '100.00', '2022-01-06'),
       ('Restaurant_Fourth', 'Food_First', '200.50', 'Food_Second', '300.50', 'Food_Third', '100.00', '2022-01-05'),
       ('Restaurant_Fifth','Food_First', '400.50', 'Food_Second', '100.50', 'Food_Third', '200.00', '2022-01-06'),
       ('Restaurant_Second', 'Food_First', '500.50', 'Food_Second', '300.50', 'Food_Third', '100.00', '2022-01-04'),
       ('Restaurant_Third', 'Food_First', '200.50', 'Food_Second', '600.50', 'Food_Third', '100.00', '2022-01-04'),
       ('Restaurant_Fourth', 'Food_First', '200.50', 'Food_Second', '200.50', 'Food_Third', '100.00', '2022-01-04'),
       ('Restaurant_Fifth','Food_First', '100.50', 'Food_Second', '100.50', 'Food_Third', '200.00', '2022-01-05');

INSERT INTO VOTING (USER_ID, RESTAURANTS_ID)
VALUES (1, 1),
       (2, 5);
