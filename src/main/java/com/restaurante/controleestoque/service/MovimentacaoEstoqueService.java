
package com.restaurante.controleestoque.service;

import com.restaurante.controleestoque.entity.MovimentacaoEstoque;
import com.restaurante.controleestoque.entity.Produto;
import com.restaurante.controleestoque.repository.MovimentacaoEstoqueRepository;
import com.restaurante.controleestoque.repository.ProdutoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class MovimentacaoEstoqueService {

    private final MovimentacaoEstoqueRepository movimentacaoRepository;
    private final ProdutoRepository produtoRepository;

    public MovimentacaoEstoqueService(
            MovimentacaoEstoqueRepository movimentacaoRepository,
            ProdutoRepository produtoRepository) {

        this.movimentacaoRepository = movimentacaoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public MovimentacaoEstoque registrarMovimentacao(
            Long produtoId,
            String tipo,
            BigDecimal quantidade,
            String motivo,
            String responsavel) {

        if (produtoId == null) {
            throw new IllegalArgumentException("Informe o produto.");
        }

        if (tipo == null) {
            throw new IllegalArgumentException("Informe o tipo de movimentação.");
        }

        tipo = tipo.trim().toLowerCase(Locale.ROOT);

        if (!tipo.equals("entrada") && !tipo.equals("saida")) {
            throw new IllegalArgumentException(
                    "O tipo deve ser entrada ou saida.");
        }

        if (quantidade == null ||
                quantidade.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException(
                    "A quantidade deve ser maior que zero.");
        }

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Produto não encontrado."));

        BigDecimal estoqueAtual = produto.getQuantidade();
        BigDecimal novoEstoque;

        if (tipo.equals("entrada")) {

            novoEstoque = estoqueAtual.add(quantidade);

        } else {

            if (estoqueAtual.compareTo(quantidade) < 0) {
                throw new IllegalArgumentException(
                        "Estoque insuficiente para realizar a saída.");
            }

            novoEstoque = estoqueAtual.subtract(quantidade);
        }

        produto.setQuantidade(novoEstoque);
        produtoRepository.save(produto);

        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();

        movimentacao.setProduto(produto);
        movimentacao.setTipo(tipo);
        movimentacao.setQuantidade(quantidade);
        movimentacao.setDataMovimentacao(LocalDateTime.now());
        movimentacao.setMotivo(motivo);
        movimentacao.setResponsavel(responsavel);

        return movimentacaoRepository.save(movimentacao);
    }
}
