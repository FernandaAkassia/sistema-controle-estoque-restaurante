package com.restaurante.controleestoque.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/")
    public String inicio() {
        return "Sistema de Gestão de Estoque e Apoio a Compras funcionando!";
    }
}
