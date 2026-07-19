package model;

/**
 *
 * Esta subclase que hereda de @link {ServicioTuristico} que representa un tipo de servicio que puede adquirir un cliente
 * o que tiene a cargo un guia
 *
 * @author Benjamin Atenas
 * @version 1.0
 * @since 1.0
 */

import javax.swing.*;

public class PaseoLacustre extends ServicioTuristico implements Registrable{
    /**
     * @param tipoEmbarcacion Dato de tipo String que representa el tipo de embarcacion usada en este paseo.
     * @param cantidadMaxPersona Dato de tipo entero que representa el número máximo de personas por compra
     *
     */
    private String tipoEmbarcacion;
    private int cantidadMaxPersonas;

    public PaseoLacustre(){ //Constructor vacio con variables ya asignadas ya que estas nunca cambiarán
        super("Paseo en Lancha", 1);
        this.tipoEmbarcacion = "Lancha acuática";
        this.cantidadMaxPersonas = 4;
    }
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }
    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }
    public int getCantidadMaxPersonas() {
        return cantidadMaxPersonas;
    }
    public void setCantidadMaxPersonas(int cantidadMaxPersonas) {
        this.cantidadMaxPersonas = cantidadMaxPersonas;
    }
    /**
     * @return Método que permite llamar la información de este tour en el Main
     */
    @Override
    public String mostrarInformacion() {
        JOptionPane.showMessageDialog(null, "El tour \"" + nombreTour + "\" dura " + cantidadHoras +
                " horas. Será en una " + tipoEmbarcacion + " y la cantidad máxima por tour es de " + cantidadMaxPersonas
                + " personas", "Paseo Lacustre", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }
    /**
     * @return Método que permite llamar la información de este tour en el Main
     */
    @Override
    public String toString() {
        return "El tour \"" + nombreTour + "\" dura " + cantidadHoras +
                " horas. Será en una " + tipoEmbarcacion + " y la cantidad máxima por tour es de " + cantidadMaxPersonas
                + " personas";
    }
}
