package com.restaurante.controleestoque.controller;

import com.restaurante.controleestoque.entity.Categoria;
import com.restaurante.controleestoque.service.CategoriaService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/categorias")
    public Categoria cadastrarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.cadastrarCategoria(categoria);
    }

    @GetMapping("/categorias")
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/categorias/{id}")
    public Categoria buscarCategoriaPorId(@PathVariable Long id) {
        return categoriaService.buscarCategoriaPorId(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

}