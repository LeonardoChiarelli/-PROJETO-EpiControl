create table cidades(

    id bigint not null auto_increment,
    nome varchar(100) not null unique,
    estado varchar(2) not null,
    `população(milhões)` decimal(4,2) not null,
    quantidade_hospitais int not null,
    quantidade_postos_de_saude int not null,

    primary key(id)
);

insert into cidades values(1, "São Paulo", "SP", 11.45, 139, 470);
insert into cidades values(2, "São Bernardo do Campo", "SP", 0.84, 10, 35);
insert into cidades values(3, "Guarulhos", "SP", 1.29, 12, 69);
insert into cidades values(4, "Santo André", "SP", 0.72, 9, 32);