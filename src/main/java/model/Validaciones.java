package model;
/**
 *
 * Esta clase permite gestionar validaciones de formato de rut y largo de numero de tarjeta bancaria del cliente con
 * @link{RutInvalidoException} y @link{NroTarjetaInvalidoException}
 *
 * @author Benjamin Atenas
 * @version 1.0
 * @since 1.0
 */
public class Validaciones { //Validaciones de tarjeta y rut
    /**
     * @return Método validarRut arroja excepcion personalizada por formato de rut invalido
     */
    public static boolean validarRut(String rut) throws RutInvalidoException {
        if (!rut.matches("[0-9]+-[0-9kK]")){
            throw new RutInvalidoException("Formato de rut no válido");
        }
        return true;
    }
    /**
     * @return Método validarNroTarjeta arroja excepcion personalizada por formato de tarjeta bancaria del cliente
     */
    public static boolean validarNroTarjeta(String numeroTarjetaCliente){
        if(!numeroTarjetaCliente.matches("\\d{12}")){
            throw new NroTarjetaInvalidoException("EL número de tarjeta debe ser de 12 números.");
        }
        return true;
    }
}
