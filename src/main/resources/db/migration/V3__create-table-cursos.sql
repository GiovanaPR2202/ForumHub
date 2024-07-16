CREATE TABLE cursos (
    id bigint not null auto_increment,
    name VARCHAR(100) NOT NULL UNIQUE,
    category VARCHAR(50) NOT NULL

    PRIMARY KEY(id)
);