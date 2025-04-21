CREATE OR REPLACE VIEW vw_casos_por_doenca AS
SELECT
    d.id AS doenca_id,
    d.nome AS doenca_nome,
    d.agente_causador,
    d.`taxa_de_mortalidade(%)` AS taxa_mortalidade,
    d.`taxa_de_transmissao(%)` AS taxa_transmissao,
    COUNT(DISTINCT ce.cidade_id) AS cidades_afetadas,
    SUM(ce.numero_de_casos) AS total_casos,
    SUM(ce.numero_de_recuperados) AS total_recuperados
FROM
    doencas d
JOIN
    casos_epidemiologicos ce ON ce.doenca_id = d.id
GROUP BY
    d.id, d.nome, d.agente_causador, d.`taxa_de_mortalidade(%)`, d.`taxa_de_transmissao(%)`;
