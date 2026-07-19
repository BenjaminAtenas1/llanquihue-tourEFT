package model;

/**
 *
 * Esta subclase representa al guia turistico. Hereda de @link {Persona}
 * Esta subclase es compuesta de @link {ServicioTuristico}
 * @See {Persona}
 * @author Benjamin Atenas
 * @version 1.0
 * @since 1.0
 */

import javax.swing.*;

public class GuiaTuristico extends Persona implements Registrable{
    /**
     * @param idCliente Dato de tipo entero que representa un ID único para cada guia turistico.
     * @param servicioAdquirido Dato de tipo ServicioTuristico que representa el servicio que tiene a cargo el guia.
     *
     */
    private int idTrabajador;
    private ServicioTuristico servicioTuristicoAcargo;

    public GuiaTuristico(){
    }
    //Clase Guia posee la caracteristica de composición de clase al contener un objeto de la calse ServicioTuristico
    public GuiaTuristico(String nombreCompleto, String rut, int idTrabajador, ServicioTuristico servicioTuristicoAcargo) {
        super(nombreCompleto, rut);
        this.idTrabajador = idTrabajador;
        this.servicioTuristicoAcargo = servicioTuristicoAcargo;
    }
    public int getIdTrabajador() {
        return idTrabajador;
    }
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
    public ServicioTuristico getServicioTuristicoAcargo() {
        return servicioTuristicoAcargo;
    }
    public void setServicioTuristicoAcargo(ServicioTuristico servicioTuristicoAcargo) {
        this.servicioTuristicoAcargo = servicioTuristicoAcargo;
    }
    /**
     * @return Método que permite llamar la información del guia en el Main
     */
    @Override
    public String mostrarInformacion(){
        return "El trabajador " + nombreCompleto + " ID " + idTrabajador + " está a cargo del tour " +
                servicioTuristicoAcargo.getNombreTour() + ".";
    }
    /**
     * @return Método que permite llamar la información del guia en el Main
     */
    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + " | Rut: " + rut + " | ID trabajador: " + idTrabajador + " | Tour a cargo: "
                + servicioTuristicoAcargo.getNombreTour();
    }
}
