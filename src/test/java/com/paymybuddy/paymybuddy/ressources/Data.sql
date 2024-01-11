create database test;
use test;
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
