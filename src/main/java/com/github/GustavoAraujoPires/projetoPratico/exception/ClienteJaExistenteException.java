package com.github.GustavoAraujoPires.projetoPratico.exception;

public class ClienteJaExistenteException extends RuntimeException{

    public ClienteJaExistenteException() {
        super("Já existe um cliente cadastrado com este CPF e EMAIL !!!");
    }

}
