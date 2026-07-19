package model;
/**
 *
 * Esta clase principal representa represetna a una persona, de las que heredan @link{Cliente} y @link{GuiaTuristico}
 *
 * @author Benjamin Atenas
 * @version 1.0
 * @since 1.0
 */
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
    /**
     * @return Método toString que permite llamar la información de Persona en el main. No se usa, está por buena práctica
     */
    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + " - Rut: " + rut;
    }
}
