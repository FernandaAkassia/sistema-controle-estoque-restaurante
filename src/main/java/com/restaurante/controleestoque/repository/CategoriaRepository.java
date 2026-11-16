package com.restaurante.controleestoque.repository;

import com.restaurante.controleestoque.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
