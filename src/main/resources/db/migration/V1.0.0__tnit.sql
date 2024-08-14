CREATE TABLE Payments
(
    id                 SERIAL PRIMARY KEY NOT NULL,
    uuid               VARCHAR(255) NOT NULL,
    register           TIMESTAMP NOT NULL,
    dueDate            DATE NOT NULL,
    amount             DECIMAL(15,4) NOT NULL,
    paid_out           BOOLEAN NOT NULL,
    identifier_payment VARCHAR(255) NOT NULL,
    type_payment       VARCHAR(255) NOT NULL,
    recipent           VARCHAR(255) NOT NULL,
    issuer             VARCHAR(255) NOT NULL
);

CREATE SEQUENCE payments_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;