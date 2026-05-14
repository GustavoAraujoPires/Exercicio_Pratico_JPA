package com.github.GustavoAraujoPires.projetoPratico.dto;

import org.springframework.http.HttpStatus;

public record Erros(int status, String mensagem) {

    public static Erros RespostaPadrao(String mensagem){
        return new Erros(HttpStatus.BAD_REQUEST.value(), mensagem);
    }

    public static Erros conflito(String mensagem){
        return new Erros(HttpStatus.CONFLICT.value(), mensagem);
    }
}
