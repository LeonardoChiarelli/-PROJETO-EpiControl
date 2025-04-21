create table casos_epidemiologicos(

    id bigint not null auto_increment,
    cidade_id bigint not null,
    doenca_id bigint not null,
    data_de_registro date not null,
    ultima_atualizacao date not null,
    numero_de_casos int not null,
    numero_de_recuperados int not null,
    status tinyint(1) default 0,

    primary key(id),

    constraint fk_casos_epidemiologicos_cidade_id foreign key(cidade_id) references cidades(id),
    constraint fk_casos_epidemiologicos_doenca_id foreign key(doenca_id) references doencas(id)
);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, numero_de_casos, numero_de_recuperados, status)
values (1, 1, '2025-03-15', '2025-04-20', 12500, 11300, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, numero_de_casos, numero_de_recuperados, status)
values (1, 4, '2025-02-12', '2025-03-29', 320, 290, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, numero_de_casos, numero_de_recuperados, status)
values (3, 2, '2025-01-10', '2025-04-15', 215, 172, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, numero_de_casos, numero_de_recuperados, status)
values (3, 1, '2025-03-10', '2025-04-18', 4700, 4150, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, numero_de_casos, numero_de_recuperados, status)
values (4, 4, '2025-01-25', '2025-04-14', 180, 160, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, numero_de_casos, numero_de_recuperados, status)
values (4, 3, '2025-03-05', '2025-04-10', 25, 22, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, numero_de_casos, numero_de_recuperados, status)
values (2, 1, '2025-02-22', '2025-04-19', 3900, 3450, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, numero_de_casos, numero_de_recuperados, status)
values (2, 2, '2025-01-18', '2025-04-15', 130, 95, 1);
