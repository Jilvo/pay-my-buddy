create database prod;
use prod;
create TABLE User (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    balance DECIMAL(10, 2),
    enabled BOOLEAN,
    role VARCHAR(255)
);

create TABLE Bank_account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(255),
    iban VARCHAR(255) UNIQUE,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES User(id)
);

create TABLE Transaction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    amount DECIMAL(10, 2),
    date DATETIME,
    sender_user BIGINT,
    receiver_user BIGINT,
    FOREIGN KEY (sender_user) REFERENCES User(id),
    FOREIGN KEY (receiver_user) REFERENCES User(id)
);

create TABLE Friendship (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    friend_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (friend_id) REFERENCES User(id)
);


-- Insert into User
insert into User (first_name, last_name, password, email, balance, enabled, role)
VALUES ('John', 'Doe', 'password1', 'john.doe@example.com', 1000.00, true, 'USER'),
       ('Jane', 'Doe', 'password2', 'jane.doe@example.com', 2000.00, true, 'USER'),
       ('Jean', 'Valjean', 'password3', 'jean.valjean@example.com', 3000.00, true, 'USER'),
       ('Peter', 'Parker', 'password4', 'peter.parker@example.com', 4000.00, true, 'USER');

-- Insert into BankAccount
insert into Bank_account (account_number, iban, user_id)
values ('123456789', 'FR7630004000031234567890143', 1),
       ('987654321', 'FR7630004000039876543210143', 2),
       ('987654322', 'FR7630004000039876543210144', 3),
       ('987654323', 'FR7630004000039876543210145', 4);

-- Insert into Transaction
insert into Transaction (description, amount, date, sender_user, receiver_user)
values ('Payment for services', 100.00, '2022-01-01 10:00:00', 1, 2),
       ('Refund for overpayment', 50.00, '2022-01-02 11:00:00', 2, 1),
        ('Refund for overpayment', 50.00, '2022-01-03 11:00:00', 3, 1),
         ('Refund for overpayment', 500.00, '2022-01-04 11:00:00', 3, 4);

-- Insert into Friendship
insert into Friendship (user_id, friend_id)
values (1, 2),
       (2, 1),
       (3, 1),
       (3, 2),
       (3, 3);