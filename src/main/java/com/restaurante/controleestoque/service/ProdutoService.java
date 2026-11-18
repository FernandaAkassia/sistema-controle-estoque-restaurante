package com.restaurante.controleestoque.service;

import com.restaurante.controleestoque.entity.Produto;
import com.restaurante.controleestoque.entity.Categoria;
import com.restaurante.controleestoque.repository.ProdutoRepository;
import com.restaurante.controleestoque.repository.CategoriaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(
            ProdutoRepository produtoRepository,
            CategoriaRepository categoriaRepository) {

        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Produto cadastrarProduto(Produto produto) {

        Categoria categoria = categoriaRepository.findById(
                produto.getCategoria().getId()
        ).orElseThrow(() ->
                new RuntimeException("Categoria não encontrada"));

        produto.setCategoria(categoria);

        // Todo produto começa com estoque zerado.
        produto.setQuantidade(BigDecimal.ZERO);

        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto atualizarProduto(Long id, Produto dadosAtualizados) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));

        Categoria categoria = categoriaRepository.findById(
                dadosAtualizados.getCategoria().getId()
        ).orElseThrow(() ->
                new RuntimeException("Categoria não encontrada"));

        produto.setNome(dadosAtualizados.getNome());
        produto.setUnidade(dadosAtualizados.getUnidade());
        produto.setEstoqueMinimo(dadosAtualizados.getEstoqueMinimo());
        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }

    public void excluirProduto(Long id) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));

        produtoRepository.delete(produto);
    }
}

