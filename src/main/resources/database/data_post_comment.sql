--liquibase formatted sql
--changeset agakoz:1

INSERT INTO POST(title, content) VALUES('Hello World1', 'This is my 1st post!');
INSERT INTO POST(title, content) VALUES('Hello World2', 'This is my 2nd post!');
INSERT INTO POST(title, content) VALUES('Hello World3', 'This is my 3rd post!');
INSERT INTO POST(title, content) VALUES('Hello World4', 'This is my 4th post!');
INSERT INTO POST(title, content) VALUES('Hello World5', 'This is my 5th post!');
INSERT INTO POST(title, content) VALUES('Hello World6', 'This is my 6th post!');
INSERT INTO POST(title, content) VALUES('Hello World7', 'This is my 7th post!');
INSERT INTO POST(title, content) VALUES('Hello World8', 'This is my 8th post!');
INSERT INTO POST(title, content) VALUES('Hello World9', 'This is my 9th post!');
INSERT INTO POST(title, content) VALUES('Hello World10', 'This is my 10th post!');
INSERT INTO POST(title, content) VALUES('Hello World11', 'This is my 11th post!');
INSERT INTO POST(title, content) VALUES('Hello World12', 'This is my 12th post!');
INSERT INTO POST(title, content) VALUES('Hello World13', 'This is my 13th post!');
INSERT INTO POST(title, content) VALUES('Hello World14', 'This is my 14th post!');
INSERT INTO POST(title, content) VALUES('Hello World15', 'This is my 15th post!');

INSERT INTO comment (content, post_id, created) VALUES('Good post!', 1, '2020-01-01T13:00:00.000000000');
INSERT INTO comment (content, post_id, created) VALUES('Amazing post!', 1, '2020-02-01T13:00:00.000000000');
INSERT INTO comment (content, post_id, created) VALUES('Good post!', 2, '2020-01-02T13:00:00.000000000');