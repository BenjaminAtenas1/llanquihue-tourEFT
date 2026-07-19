package model;

import javax.swing.*;

public class PaseoLacustre extends ServicioTuristico implements Registrable{
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
    @Override
    public String mostrarInformacion() {
        JOptionPane.showMessageDialog(null, "El tour \"" + nombreTour + "\" dura " + cantidadHoras +
                " horas. Será en una " + tipoEmbarcacion + " y la cantidad máxima por tour es de " + cantidadMaxPersonas
                + " personas", "Paseo Lacustre", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }
    public String mostrarInformacionEnTexto(){
        return "El tour \"" + nombreTour + "\" dura " + cantidadHoras +
                " horas. Será en una " + tipoEmbarcacion + " y la cantidad máxima por tour es de " + cantidadMaxPersonas
                + " personas";
    }
    @Override
    public String toString() {
        return "El tour \"" + nombreTour + "\" dura " + cantidadHoras +
                " horas. Será en una " + tipoEmbarcacion + " y la cantidad máxima por tour es de " + cantidadMaxPersonas
                + " personas";
    }
}
