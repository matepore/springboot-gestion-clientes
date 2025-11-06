package matepore.springboot.gestion.clientes.exception;

public class ClienteNoEncontradoException extends RuntimeException{

    public ClienteNoEncontradoException(Long id){
        super("El cliente con el id: " + id + " no ha sido encontrado.");
    }
}
