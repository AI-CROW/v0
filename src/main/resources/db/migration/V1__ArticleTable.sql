CREATE TABLE article (
    id UUID NOT NULL PRIMARY KEY,
    title VARCHAR(128) NOT NULL,
    author VARCHAR(128) NOT NULL,
    publisher VARCHAR(128),
    postDate VARCHAR(128) NOT NULL,
    content VARCHAR NOT NULL,
    url VARCHAR NOT NULL
);