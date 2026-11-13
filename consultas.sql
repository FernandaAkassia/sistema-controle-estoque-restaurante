-- 1. Listar produtos e quantidades em estoque

SELECT
    id,
    nome,
    quantidade,
    unidade
FROM produto
ORDER BY nome;


-- 2. Histórico de entradas e saídas de produtos

SELECT
    m.id,
    p.nome AS produto,
    m.tipo,
    m.quantidade,
    m.data_movimentacao
FROM movimentacao_estoque m
INNER JOIN produto p
    ON m.produto_id = p.id
ORDER BY m.data_movimentacao DESC;


-- 3. Listar produtos e suas respectivas categorias

SELECT
    p.id,
    p.nome,
    c.nome AS categoria,
    p.quantidade
FROM produto p
INNER JOIN categoria c
    ON p.categoria_id = c.id
ORDER BY p.nome;


-- 4. Identificar produtos com estoque baixo

SELECT
    nome AS produto,
    quantidade AS estoque_atual,
    estoque_minimo,
    CASE
        WHEN quantidade <= estoque_minimo
        THEN 'ESTOQUE BAIXO'
        ELSE 'ESTOQUE NORMAL'
    END AS situacao
FROM produto
ORDER BY nome;


-- 5. Total de entradas e saídas por produto

SELECT
    p.nome AS produto,
    m.tipo,
    SUM(m.quantidade) AS total_movimentado
FROM movimentacao_estoque m
INNER JOIN produto p
    ON m.produto_id = p.id
GROUP BY p.nome, m.tipo
ORDER BY p.nome, m.tipo;
