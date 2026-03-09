package https.github.com.GustavoAraujoPires.projetoPratico.exception;

public class PedidoNaoEncontradoPorIdException extends RuntimeException{

    public PedidoNaoEncontradoPorIdException() {
        super("Pedido não encontrado com esse {Id} !!");
    }
}
