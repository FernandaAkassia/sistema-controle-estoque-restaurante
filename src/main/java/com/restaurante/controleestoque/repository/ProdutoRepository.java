
package com.restaurante.controleestoque.repository;

import com.restaurante.controleestoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
