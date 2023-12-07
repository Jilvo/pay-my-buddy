create database prod if not exists;
use prod;
CREATE TABLE User (
    userId BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    balance DECIMAL(10, 2),
    enabled BOOLEAN,
    role VARCHAR(255)
);

CREATE TABLE BankAccount (
    bankAccountId BIGINT AUTO_INCREMENT PRIMARY KEY,
    accountNumber VARCHAR(255),
    iban VARCHAR(255) UNIQUE,
    userId BIGINT,
    FOREIGN KEY (userId) REFERENCES User(userId)
);

CREATE TABLE Transaction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    amount DECIMAL(10, 2),
    date DATETIME,
    senderUserId BIGINT,
    receiverUserId BIGINT,
    FOREIGN KEY (senderUserId) REFERENCES User(userId),
    FOREIGN KEY (receiverUserId) REFERENCES User(userId)
);

CREATE TABLE Friendship (
    userId BIGINT,
    friendId BIGINT,
    PRIMARY KEY (userId, friendId),
    FOREIGN KEY (userId) REFERENCES User(userId),
    FOREIGN KEY (friendId) REFERENCES User(userId)
);


-- Insert into User
INSERT INTO User (firstName, lastName, password, email, balance, enabled, role)
VALUES ('John', 'Doe', 'password1', 'john.doe@example.com', 1000.00, true, 'USER'),
       ('Jane', 'Doe', 'password2', 'jane.doe@example.com', 2000.00, true, 'USER');

-- Insert into BankAccount
INSERT INTO BankAccount (accountNumber, iban, userId)
VALUES ('123456789', 'FR7630004000031234567890143', 1),
       ('987654321', 'FR7630004000039876543210143', 2);

-- Insert into Transaction
INSERT INTO Transaction (description, amount, date, senderUserId, receiverUserId)
VALUES ('Payment for services', 100.00, '2022-01-01 10:00:00', 1, 2),
       ('Refund for overpayment', 50.00, '2022-01-02 11:00:00', 2, 1);

-- Insert into Friendship
INSERT INTO Friendship (userId, friendId)
VALUES (1, 2),
       (2, 1);