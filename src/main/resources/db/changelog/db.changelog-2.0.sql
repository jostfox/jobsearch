--liquibase formatted sql

--changeset Oleg Rulyov:1
INSERT INTO company
VALUES (1,
        'AVL DiTEST',
        'CADOLZBURG',
        'support.ccc@avl.com',
        'HYBRID',
        'https://www.avlditest.com/',
        '+43 316 787 1193');

--changeset Oleg Rulyov:2
INSERT INTO invocation
VALUES (1,
        1,
        '2024-02-23',
        'NOT_REPLIED',
        NULL,
        NULL);
