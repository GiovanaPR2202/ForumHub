create table resposta(
       id bigint not null auto_increment,
       mensagem varchar(100) not null,
       topico_id bigint not null,
       dataCriacao datetime not null,

       primary key(id)

       constraint fk_reposta_topico_id  foreign key(topico_id) references topicos(id),
)