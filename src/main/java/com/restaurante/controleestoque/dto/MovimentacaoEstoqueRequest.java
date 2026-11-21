
package com.restaurante.controleestoque.dto;

import java.math.BigDecimal;

public record MovimentacaoEstoqueRequest(
        Long produtoId,
        String tipo,
        BigDecimal quantidade,
        String motivo,
        String responsavel
) {
}

