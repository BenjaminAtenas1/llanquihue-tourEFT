package model;

public class NroTarjetaInvalidoException extends RuntimeException { //Validación para verificar el largo de la tarjeta (12 números)
    public NroTarjetaInvalidoException(String mensaje) {
        super(mensaje);
    }
}
