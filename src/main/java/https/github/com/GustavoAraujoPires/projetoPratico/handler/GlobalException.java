package https.github.com.GustavoAraujoPires.projetoPratico.handler;

import https.github.com.GustavoAraujoPires.projetoPratico.exception.ClienteJaExistenteException;
import https.github.com.GustavoAraujoPires.projetoPratico.exception.ClienteNaoEncontradoException;
import https.github.com.GustavoAraujoPires.projetoPratico.exception.PedidoInvalidoException;
import https.github.com.GustavoAraujoPires.projetoPratico.exception.PedidoNaoEncontradoPorIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice // ele já retorna JSON automaticamente.
public class GlobalException {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 404 Nao Encontrado
    public String clienteNaoEncontrado(ClienteNaoEncontradoException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(ClienteJaExistenteException.class)
    @ResponseStatus(HttpStatus.CONFLICT) // 409 Dados Duplicado
    public String clienteJaExiste(ClienteJaExistenteException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(PedidoInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String pedidosInvalido(PedidoInvalidoException e){
        return e.getMessage();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String naoEncontardoPorId(){
        return "ID informado possui dados invalido !!";
    }

    @ExceptionHandler(PedidoNaoEncontradoPorIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String PedidoNaoEncontradoPorId(PedidoNaoEncontradoPorIdException e ){
        return e.getMessage();
    }
}
