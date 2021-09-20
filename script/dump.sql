CREATE KEYSPACE todo_management WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
CREATE TABLE todo_management.todo (
    id uuid PRIMARY KEY,
    completed boolean,
    todo text
);

CREATE TABLE todo_management.user (
    id uuid PRIMARY KEY,
    password text,
    username text
);

CREATE INDEX user_index ON todo_management.user (username);

INSERT INTO todo_management.user (id , username , password ) VALUES ( 7dc752b0-1947-11ec-9e0c-13d601ddf2c6,'demo'
,'{bcrypt}$2a$10$sB/ZcRPqM/zLJmfXqJPQ.uUalGXpdoCJMEUxu.KvZwP3oert6fuJK');