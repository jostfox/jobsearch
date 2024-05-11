--liquibase formatted sql

--changeset Oleg Rulyov:1
CREATE TABLE IF NOT EXISTS company
(
    id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(45),
    location VARCHAR(100),
    required_position VARCHAR(45),
    vacancy_status VARCHAR(20),
    invocation VARCHAR(45),
    email VARCHAR(45),
    contact_name VARCHAR(60),
    working_place VARCHAR(45),
    web_page VARCHAR(100),
    phone VARCHAR(45)
);

--changeset Oleg Rulyov:2
CREATE TABLE IF NOT EXISTS invocation
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_id BIGINT REFERENCES company (id),
    creation_date TIMESTAMP,
    status VARCHAR(45),
    inv_result VARCHAR(45),
    result_description VARCHAR(100)
);

--changeset Oleg Rulyov:3
CREATE TABLE IF NOT EXISTS company_location
(
    company_id BIGINT REFERENCES company (id),
    location VARCHAR(45)
);



