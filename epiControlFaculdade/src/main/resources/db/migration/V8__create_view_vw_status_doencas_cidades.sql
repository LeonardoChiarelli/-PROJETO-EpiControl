CREATE OR REPLACE VIEW vw_status_doencas_cidades AS
SELECT
    c.id AS cidade_id,
    c.nome AS cidade_nome,
    d.id AS doenca_id,
    d.nome AS doenca_nome,
    ce.status,
    CASE ce.status
        WHEN 1 THEN 'Ativo'
        WHEN 0 THEN 'Encerrado'
        ELSE 'Desconhecido'
    END AS status_descricao,
    SUM(ce.numero_de_casos) AS total_casos,
    SUM(ce.numero_de_recuperados) AS total_recuperados,
    MAX(ce.ultima_atualizacao) AS ultima_atualizacao
FROM
    casos_epidemiologicos ce
JOIN
    cidades c ON ce.cidade_id = c.id
JOIN
    doencas d ON ce.doenca_id = d.id
GROUP BY
    c.id, c.nome, d.id, d.nome, ce.status;
