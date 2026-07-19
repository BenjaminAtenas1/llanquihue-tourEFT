package model;

/**
 *
 * Esta subclase representa al cliente. Hereda de @link {Persona}
 * Es compuesta de @link {ServicioTuristico}
 * @See {Persona}
 * @author Benjamin Atenas
 * @version 1.0
 * @since 1.0
 */

public class Cliente extends Persona implements Registrable{
    /**
     * @param numeroTarjetaCliente Dato de tipo String que representa la tarjeta con la que paga un cliente.
     * @param idCliente Dato de tipo entero que representa un ID único para cada cliente.
     * @param ordenDeCompra Dato de tipo entero que representa el número de orden de compra.
     * @param servicioAdquirido Dato de tipo ServicioTuristico que representa el servicio que adquirió el cliente.
     *
     */
    private String numeroTarjetaCliente;
    private int idCliente;
    private int ordenDeCompra;
    private ServicioTuristico servicioAdquirido;

    public Cliente(){
    }
    //Clase Cliente posee la caracteristica de composición de clase al contener un objeto de la calse ServicioTuristico
    public Cliente(String nombreCompleto, String rut, String numeroTarjetaCliente, int idCliente, int ordenDeCompra,
                   ServicioTuristico servicioAdquirido){
        super(nombreCompleto, rut);
        this.numeroTarjetaCliente = numeroTarjetaCliente;
        this.idCliente = idCliente;
        this.ordenDeCompra = ordenDeCompra;
        this.servicioAdquirido = servicioAdquirido;
    }
    public String getNumeroTarjetaCLiente() {
        return numeroTarjetaCliente;
    }
    public void setNumeroTarjetaCLiente(String numeroTarjetaCLiente) {
        this.numeroTarjetaCliente = numeroTarjetaCLiente;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getOrdenDeCompra() {
        return ordenDeCompra;
    }
    public void setOrdenDeCompra(int ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }
    public ServicioTuristico getServicioAdquirido() {
        return servicioAdquirido;
    }
    public void setServicioAdquirido(ServicioTuristico servicioAdquirido) {
        this.servicioAdquirido = servicioAdquirido;
    }
    /**
     * @return Método que permite llamar la información del cliente en el Main
     */
    @Override
    public String mostrarInformacion(){
        return "El cliente " + nombreCompleto + " (RUT: " + rut + "), Número de tarjeta " + numeroTarjetaCliente
                + " con ID " + idCliente + " tiene la orden de compra " + ordenDeCompra + " y ha seleccionado el servicio turístico "
                + servicioAdquirido.getNombreTour();
    }
    /**
     * @return Método toString que permite llamar la información del cliente.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + " | Rut: " + rut + " | Nro. Tarjeta: " + numeroTarjetaCliente + " | ID: "
                + idCliente + " | Nro Orden de compra: " + ordenDeCompra;
    }
}
