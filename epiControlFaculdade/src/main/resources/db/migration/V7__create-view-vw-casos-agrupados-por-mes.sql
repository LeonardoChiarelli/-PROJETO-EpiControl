CREATE OR REPLACE VIEW vw_casos_por_mes AS
SELECT
    DATE_FORMAT(ce.data_de_registro, '%Y-%m') AS mes,
    d.nome AS doenca_nome,
    c.nome AS cidade_nome,
    SUM(ce.numero_de_casos) AS total_casos,
    SUM(ce.numero_de_recuperados) AS total_recuperados
FROM
    casos_epidemiologicos ce
JOIN
    doencas d ON ce.doenca_id = d.id
JOIN
    cidades c ON ce.cidade_id = c.id
GROUP BY
    DATE_FORMAT(ce.data_de_registro, '%Y-%m'), d.nome, c.nome
ORDER BY
    mes, doenca_nome, cidade_nome;
