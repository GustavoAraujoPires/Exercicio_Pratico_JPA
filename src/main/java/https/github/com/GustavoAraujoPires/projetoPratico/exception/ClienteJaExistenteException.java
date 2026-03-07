package https.github.com.GustavoAraujoPires.projetoPratico.exception;

public class ClienteJaExistenteException extends RuntimeException{

    public ClienteJaExistenteException() {
        super("Já existe um cliente cadastrado com este email");
    }
}
