package model;
/**
 *
 * Esta clase que es para tener una excepción personalizada para error por largo dela tarjeta bancaria del cliente
 *
 * @author Benjamin Atenas
 * @version 1.0
 * @since 1.0
 */
public class NroTarjetaInvalidoException extends RuntimeException {
    /**
     * @return Retorna excepción personalizada
     */
    //Validación para verificar el largo de la tarjeta (12 números)
    public NroTarjetaInvalidoException(String mensaje) {
        super(mensaje);
    }
}
