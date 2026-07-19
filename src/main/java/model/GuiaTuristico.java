package model;

import javax.swing.*;

public class GuiaTuristico extends Persona implements Registrable{
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
    @Override
    public String mostrarInformacion(){
        return "El trabajador " + nombreCompleto + " ID " + idTrabajador + " está a cargo del tour " +
                servicioTuristicoAcargo.getNombreTour() + ".";
    }
    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + " | Rut: " + rut + " | ID trabajador: " + idTrabajador + " | Tour a cargo: "
                + servicioTuristicoAcargo.getNombreTour();
    }
}
