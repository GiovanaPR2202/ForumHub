create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem varchar(100) not null,
    dataCriacao datetime not null,
    status varchar(100) not null,
    cursos_id varchar(100) not null,


    primary key(id)

     constraint fk_topicos_curso_id  foreign key(cursos_id) references cursos_id(id)
)
