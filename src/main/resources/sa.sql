CREATE DATABASE SA;
CREATE TABLE CLIENT (
       ID SERIAL PRIMARY KEY,
       EMAIL varchar(50)
);

CREATE TABLE SENTIMENT (
       ID SERIAL PRIMARY KEY,
       MESSAGE varchar(50),
       TYPE varchar(10),
    CLIENT_ID int,
    CONSTRAINT client_fk FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(ID)


);