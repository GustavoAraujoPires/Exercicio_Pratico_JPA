package https.github.com.GustavoAraujoPires.projetoPratico.exception;

public class PedidoInvalidoException extends RuntimeException{

    public PedidoInvalidoException() {
        super("Pedido inválido. Verifique os dados informados.");
    }
}
