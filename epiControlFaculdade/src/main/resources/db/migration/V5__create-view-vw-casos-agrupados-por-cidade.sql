CREATE OR REPLACE VIEW vw_casos_agrupados_por_cidade AS
SELECT
    c.id AS cidade_id,
    c.nome AS cidade_nome,
    c.estado AS cidade_estado,
    c.`população(milhões)` AS populacao_milhoes,
    c.quantidade_hospitais,
    c.quantidade_postos_de_saude,
    COUNT(DISTINCT ce.doenca_id) AS quantidade_doencas_registradas,
    SUM(ce.numero_de_casos) AS total_casos,
    SUM(ce.numero_de_recuperados) AS total_recuperados
FROM
    cidades c
JOIN
    casos_epidemiologicos ce ON ce.cidade_id = c.id
GROUP BY
    c.id, c.nome, c.estado, c.`população(milhões)`, c.quantidade_hospitais, c.quantidade_postos_de_saude;
