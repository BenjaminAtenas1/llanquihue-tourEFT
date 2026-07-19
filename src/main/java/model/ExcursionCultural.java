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

public class ExcursionCultural extends ServicioTuristico implements Registrable{
    /**
     * @param lugarHistorico Dato de tipo String que representa el nombre del lugar que se va a visitar.
     * @param cantidadMaxPersona Dato de tipo entero que representa el número máximo de personas por compra
     *
     */
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
    /**
     * @return Método que permite llamar la información de este tour en el Main
     */
    @Override
    public String mostrarInformacion(){
        JOptionPane.showMessageDialog(null,"El tour \"" + nombreTour + "\" dura " + cantidadHoras
                + " horas. Se visitará el " + lugarHistorico + " y la cantidad máxima por tour es de " + cantidadMaxPersonas
                + " personas.", "Excursión Cultural",JOptionPane.INFORMATION_MESSAGE);
        return null;
    }
    /**
     * @return Método que permite llamar la información de este tour en el Main
     */
    @Override
    public String toString() {
        return "El tour \"" + nombreTour + "\" dura " + cantidadHoras
                + " horas. Se visitará el " + lugarHistorico + " y la cantidad máxima por tour es de " + cantidadMaxPersonas
                + " personas.";
    }
}
