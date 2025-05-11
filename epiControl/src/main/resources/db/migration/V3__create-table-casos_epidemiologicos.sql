create table casos_epidemiologicos(

    id bigint not null auto_increment,
    cidade_id bigint not null,
    doenca_id bigint not null,
    data_de_registro date not null,
    ultima_atualizacao date not null,
    `numero_de_casos (mil)` decimal(5,2) not null,
    numero_de_obitos int not null default 0,
    `numero_de_recuperados (mil)` decimal(5,2) not null,
    status tinyint(1) default 0,

    primary key(id),

    constraint fk_casos_epidemiologicos_cidade_id foreign key(cidade_id) references cidades(id),
    constraint fk_casos_epidemiologicos_doenca_id foreign key(doenca_id) references doencas(id)
);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (1, 1, '2000-01-01', '2025-05-11', 350, 220, 347.50, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (1, 2, '1996-02-01', '2025-05-11', 8, 420, 7.40, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (1, 3, '1990-04-04', '2025-05-11', 0.95, 40, 0.90, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (1, 4, '1990-01-01', '2025-03-29', 32, 1800, 29.50, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (2, 1, '2001-05-10', '2025-05-11', 290.50, 11, 290.30, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (2, 2, '2002-06-21', '2025-05-11', 0.75, 38, 0.70, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (2, 3, '2001-12-22', '2025-05-11', 0.07, 2, 0.07, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (2, 4, '1997-12-12', '2025-05-11', 2.90, 150, 2.70, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (3, 1, '2003-03-20', '2025-05-11', 48, 20, 47.50, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (3, 2, '2000-10-01', '2025-05-11', 1.10, 65, 1.00, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (3, 3, '1990-04-04', '2025-05-11', 0.13, 8, 0.12, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (3, 4, '1998-08-15', '2025-05-11', 0.45, 220, 0.42, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (4, 1, '2002-07-15', '2025-05-11', 320, 14, 318, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (4, 2, '2001-01-05', '2025-05-11', 0.90, 50, 0.82, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (4, 3, '2003-11-02', '2025-05-11', 0.08, 4, 0.08, 1);

insert into casos_epidemiologicos (cidade_id, doenca_id, data_de_registro, ultima_atualizacao, `numero_de_casos (mil)`, numero_de_obitos, `numero_de_recuperados (mil)`, status)
values (4, 4, '1997-12-12', '2025-05-11', 0.29, 150, 0.27, 1);

