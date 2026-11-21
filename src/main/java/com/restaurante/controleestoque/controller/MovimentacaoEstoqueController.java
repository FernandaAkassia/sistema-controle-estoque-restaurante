
package com.restaurante.controleestoque.controller;

import com.restaurante.controleestoque.dto.MovimentacaoEstoqueRequest;
import com.restaurante.controleestoque.entity.MovimentacaoEstoque;
import com.restaurante.controleestoque.service.MovimentacaoEstoqueService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MovimentacaoEstoqueController {

    private final MovimentacaoEstoqueService movimentacaoEstoqueService;

    public MovimentacaoEstoqueController(
            MovimentacaoEstoqueService movimentacaoEstoqueService) {

        this.movimentacaoEstoqueService = movimentacaoEstoqueService;
    }

    @PostMapping("/movimentacoes")
    public MovimentacaoEstoque registrarMovimentacao(
            @RequestBody MovimentacaoEstoqueRequest request) {

        return movimentacaoEstoqueService.registrarMovimentacao(
                request.produtoId(),
                request.tipo(),
                request.quantidade(),
                request.motivo(),
                request.responsavel()
        );
    }
}

