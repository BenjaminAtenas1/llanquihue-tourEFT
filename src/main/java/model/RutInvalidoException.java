package model;
/**
 *
 * Esta clase que es para tener una excepción personalizada para error por formato del rut chileno de la persona
 *
 * @author Benjamin Atenas
 * @version 1.0
 * @since 1.0
 */
public class RutInvalidoException extends Exception {
    /**
     * @return Retorna excepción personalizada
     */
    //Validación para formato de rut chileno
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }

}
