package model;

public class Validaciones { //Validaciones de tarjeta y rut
    public static boolean validarRut(String rut) throws RutInvalidoException {
        if (!rut.matches("[0-9]+-[0-9kK]")){
            throw new RutInvalidoException("Formato de rut no válido");
        }
        return true;
    }
    public static boolean validarNroTarjeta(String numeroTarjetaCliente){
        if(!numeroTarjetaCliente.matches("\\d{12}")){
            throw new NroTarjetaInvalidoException("EL número de tarjeta debe ser de 12 números.");
        }
        return true;
    }
}
