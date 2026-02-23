CREATE TABLE abonements (
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    typeAbonement VARCHAR(20),
    date_End DATE
);