CREATE TABLE IF NOT EXISTS servicemen (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    surname VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),
    nationality VARCHAR(255),
    birth_date DATE NOT NULL,
    position VARCHAR(255) NOT NULL,
    rank VARCHAR(255) NOT NULL
);