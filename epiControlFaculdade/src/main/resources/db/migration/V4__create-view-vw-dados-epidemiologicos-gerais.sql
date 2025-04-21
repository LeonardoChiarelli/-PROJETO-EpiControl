CREATE OR REPLACE VIEW vw_dados_epidemiologicos_gerais AS
SELECT
    c.id AS cidade_id,
    c.nome AS cidade_nome,
    c.estado AS cidade_estado,
    c.`população(milhões)` AS populacao_milhoes,
    c.quantidade_hospitais,
    c.quantidade_postos_de_saude,

    d.id AS doenca_id,
    d.nome AS doenca_nome,
    d.agente_causador,
    d.`taxa_de_mortalidade(%)` AS taxa_mortalidade,
    d.`taxa_de_transmissao(%)` AS taxa_transmissao,

    ce.id AS caso_id,
    ce.data_de_registro,
    ce.ultima_atualizacao,
    ce.numero_de_casos,
    ce.numero_de_recuperados,
    ce.status

FROM
    cidades c
JOIN
    casos_epidemiologicos ce ON ce.cidade_id = c.id
JOIN
    doencas d ON ce.doenca_id = d.id;
