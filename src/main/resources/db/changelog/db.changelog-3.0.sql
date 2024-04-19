--liquibase formatted sql

--changeset Oleg Rulyov:1
ALTER TABLE company
ADD CONSTRAINT FOREIGN KEY "company_inv" (invocation) REFERENCES invocation (status);