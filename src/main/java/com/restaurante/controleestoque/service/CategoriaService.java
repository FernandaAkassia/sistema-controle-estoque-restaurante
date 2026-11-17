package com.restaurante.controleestoque.service;

import com.restaurante.controleestoque.entity.Categoria;
import com.restaurante.controleestoque.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria cadastrarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria atualizarCategoria(Long id, Categoria dadosAtualizados) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoria.setNome(dadosAtualizados.getNome());

        return categoriaRepository.save(categoria);
    }

    public void excluirCategoria(Long id) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoriaRepository.delete(categoria);
    }
}