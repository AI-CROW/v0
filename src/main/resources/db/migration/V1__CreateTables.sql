DROP TABLE IF EXISTS site;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS article;

CREATE TABLE site (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    url VARCHAR(128) NOT NULL,
    accuracy DECIMAL(5,3),
    type VARCHAR(4) NOT NULL
);

CREATE TABLE author (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    accuracy DECIMAL(5,3)
);

CREATE TABLE article (
    id UUID NOT NULL PRIMARY KEY,
    title VARCHAR(128) NOT NULL,
    author VARCHAR(64) NOT NULL,
    postDate VARCHAR(128) NOT NULL,
    content VARCHAR NOT NULL,
    url VARCHAR NOT NULL,
    predicted_accuracy DECIMAL(5,3),
    author_id UUID REFERENCES author(id),
    site_id UUID REFERENCES site(id)
);