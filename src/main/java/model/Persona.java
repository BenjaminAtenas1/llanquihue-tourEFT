package model;

public class Persona {
    protected String nombreCompleto;
    protected String rut;

    public Persona() {
    }
    public Persona(String nombreCompleto, String rut) {
        this.nombreCompleto = nombreCompleto;
        this.rut = rut;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + " - Rut: " + rut;
    }
}
