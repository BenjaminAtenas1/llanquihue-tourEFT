package model;

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
    @Override
    public String toString() {
        return "Nombre del tour: " + nombreTour + " - Duración del tour: " + cantidadHoras;
    }
}
