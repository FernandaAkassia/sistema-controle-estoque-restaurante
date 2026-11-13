
DELIMITER $$

CREATE TRIGGER verificar_estoque
BEFORE INSERT ON movimentacao_estoque
FOR EACH ROW
BEGIN
    DECLARE estoque_disponivel DECIMAL(10,2);

    SELECT quantidade
    INTO estoque_disponivel
    FROM produto
    WHERE id = NEW.produto_id;

    IF NEW.tipo = 'Saida'
       AND NEW.quantidade > estoque_disponivel THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Estoque insuficiente';

    END IF;

END$$

CREATE TRIGGER atualizar_estoque
AFTER INSERT ON movimentacao_estoque
FOR EACH ROW
BEGIN

    IF NEW.tipo = 'Entrada' THEN

        UPDATE produto
        SET quantidade = quantidade + NEW.quantidade
        WHERE id = NEW.produto_id;

    ELSEIF NEW.tipo = 'Saida' THEN

        UPDATE produto
        SET quantidade = quantidade - NEW.quantidade
        WHERE id = NEW.produto_id;

    END IF;

END$$

DELIMITER ;
