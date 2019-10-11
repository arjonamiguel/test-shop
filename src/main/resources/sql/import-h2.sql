-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
  (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user@mail.com', 'admin', 'Name2', 'Lastname2',
   1);
-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
  (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'name3@gmail.com', 'user', 'Name3', 'Lastname3', 1);
-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES (3, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'name4@gmail.com', 'user4', 'Name4',
        'Lastname4', 1);

INSERT INTO ROLE (role_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (role_id, role)
VALUES (2, 'ROLE_USER');

INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (2, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (3, 2);

INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('LOGAN', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 1, 35.75);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('X-MEN 2', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 5, 34.50);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('X-MEN 3', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 3, 1500.00);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('LOGAN 2', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 40, 1000.00);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Bottle CICLOP', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 80, 450.45);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('STORM', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 800, 2500.00);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('BEST', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 700, 45000.00);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Shampoo CICLOP ', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 500, 300.00);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('JET BLACK', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 1000, 500.00);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Camera laser Marvel', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 10, 85000.00);