create table doencas(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    agente_causador varchar(75) not null,
    sintomas varchar(255) not null,
    formas_de_transmissao varchar(255) not null,
    medidas_de_prevencao varchar(255) not null,
    `taxa_de_mortalidade(%)` decimal(5,2),
    `taxa_de_transmissao(%)` decimal(5,2) not null,

    primary key(id)
);

insert into doencas values(1, "Dengue", "VIRUS", "Febre alta, dores musculares, dor de cabeça, dor atrás dos olhos, manchas vermelhas na pele, náuseas, vômitos", "Picada do mosquito Aedes aegypti infectado", "Eliminar criadouros do mosquito, uso de repelentes, telas de proteção, campanhas de conscientização", 1.80, 0.03);

insert into doencas values(2, "Leptospirose", "BACTERIA", "Febre prolongada, mal-estar, dor abdominal, diarreia ou prisão de ventre, manchas rosadas no tronco", "Ingestão de água ou alimentos contaminados com fezes ou urina de pessoas infectadas", "Higiene pessoal, saneamento básico, vacinação, cuidados com a água e alimentos", 1.20, 10.00);

insert into doencas values(3, "Febre Tifoide", "BACTERIA", "Febre alta, dores musculares, dor de cabeça, dor atrás dos olhos, manchas vermelhas na pele, náuseas, vômitos", "Picada do mosquito Aedes aegypti infectado", "Eliminar criadouros do mosquito, uso de repelentes, telas de proteção, campanhas de conscientização", 1.50, 0.65);

insert into doencas values(4, "Hepatite A", "VIRUS", "Cansaço, febre, enjoo, vômitos, urina escura, pele e olhos amarelados (icterícia)", " via fecal-oral (alimentos ou água contaminados)", "Vacinação, higiene alimentar", 1.10, 0.50);