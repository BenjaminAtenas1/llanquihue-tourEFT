package model;
/**
 *
 * Esta clase principal representa represetna a un servicio turistico que entrega la empresa, de las que heredan @link{ExcursionCultural} y @link{PaseoLacustre}
 *
 * @author Benjamin Atenas
 * @version 1.0
 * @since 1.0
 */
public class ServicioTuristico { //Clase padre de las que heredan Excursión y Paseo
    protected String nombreTour;
    protected int cantidadHoras;

    public ServicioTuristico() {
    }
    public ServicioTuristico(String nombreTour, int cantidadHoras) {
        this.nombreTour = nombreTour;
        this.cantidadHoras = cantidadHoras;
    }
    public String getNombreTour() {
        return nombreTour;
    }
    public void setNombreTour(String nombreTour) {
        this.nombreTour = nombreTour;
    }
    public int getCantidadHoras() {
        return cantidadHoras;
    }
    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }
    /**
     * @return Método toString ue permite llamar la información de ServicioTuristico en el main. No se usa, está por buena práctica
     */
    @Override
    public String toString() {
        return "Nombre del tour: " + nombreTour + " - Duración del tour: " + cantidadHoras;
    }
}
