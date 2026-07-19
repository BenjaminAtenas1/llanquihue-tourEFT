package model;

public class RutInvalidoException extends Exception { //Validación para formato de rut chileno
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }

}
