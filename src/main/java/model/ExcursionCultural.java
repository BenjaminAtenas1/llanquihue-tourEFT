package model;

import javax.swing.*;

public class ExcursionCultural extends ServicioTuristico implements Registrable{
    private String lugarHistorico;
    private int cantidadMaxPersonas;

    public ExcursionCultural(){ //Constructor vacio con variables ya asignadas ya que estas nunca cambiarán
        super("Paseo al mirador", 2);
        this.lugarHistorico = "Mirador Isla Tenglo";
        this.cantidadMaxPersonas = 8;
    }
    public String getLugarHistorico() {
        return lugarHistorico;
    }
    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }
    public int getCantidadMaxPersonas() {
        return cantidadMaxPersonas;
    }
    public void setCantidadMaxPersonas(int cantidadMaxPersonas) {
        this.cantidadMaxPersonas = cantidadMaxPersonas;
    }
    @Override
    public String mostrarInformacion(){
        JOptionPane.showMessageDialog(null,"El tour \"" + nombreTour + "\" dura " + cantidadHoras
                + " horas. Se visitará el " + lugarHistorico + " y la cantidad máxima por tour es de " + cantidadMaxPersonas
                + " personas.", "Excursión Cultural",JOptionPane.INFORMATION_MESSAGE);
        return null;
    }
    public String mostrarInformacionEnTexto(){
        return "El tour \"" + nombreTour + "\" dura " + cantidadHoras
                + " horas. Se visitará el " + lugarHistorico + " y la cantidad máxima por tour es de " + cantidadMaxPersonas
                + " personas.";
    }
    @Override
    public String toString() {
        return "El tour \"" + nombreTour + "\" dura " + cantidadHoras
                + " horas. Se visitará el " + lugarHistorico + " y la cantidad máxima por tour es de " + cantidadMaxPersonas
                + " personas.";
    }
}
