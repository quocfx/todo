CREATE TABLE IF NOT EXISTS todo
(
    id                         bigint NOT NULL AUTO_INCREMENT,
    username                         varchar(100),
    detail                         varchar(500),
    CONSTRAINT pk_todos PRIMARY KEY (id)
);

INSERT INTO todo (username, detail) VALUES ('quoc', 'todo example item 1');
INSERT INTO todo (username, detail) VALUES ('nguyen', 'todo example item 2');
INSERT INTO todo (username, detail) VALUES ('hung', 'todo example item 3');
INSERT INTO todo (username, detail) VALUES ('quoc', 'todo example item 4');
INSERT INTO todo (username, detail) VALUES ('quoc', 'todo example item 5');