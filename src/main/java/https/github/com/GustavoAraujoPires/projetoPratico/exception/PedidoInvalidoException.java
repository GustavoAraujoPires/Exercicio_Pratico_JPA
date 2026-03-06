package https.github.com.GustavoAraujoPires.projetoPratico.exception;

public class ClienteNaoEncontradoException extends RuntimeException{

    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado para ID informado !!!");
    }
}
