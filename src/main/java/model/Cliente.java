package model;

public class Cliente extends Persona implements Registrable{
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
    @Override
    public String mostrarInformacion(){
        return "El cliente " + nombreCompleto + " (RUT: " + rut + "), Número de tarjeta " + numeroTarjetaCliente
                + " con ID " + idCliente + " tiene la orden de compra " + ordenDeCompra + " y ha seleccionado el servicio turístico "
                + servicioAdquirido.getNombreTour();
    }
    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + " | Rut: " + rut + " | Nro. Tarjeta: " + numeroTarjetaCliente + " | ID: "
                + idCliente + " | Nro Orden de compra: " + ordenDeCompra;
    }
}
