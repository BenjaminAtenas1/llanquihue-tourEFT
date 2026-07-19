package data;

import model.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private List<Registrable> listaRegistrables;
    private static final String DATA_FILE = ("informacion.txt");

    public GestorDatos() { //Al crearse un constructor de GestorDatos vacío, se crea la arraylist, y se añaden los objetos a la lista de Excursión y Paseo
        this.listaRegistrables = new ArrayList<>();
        listaRegistrables.add(new ExcursionCultural());
        listaRegistrables.add(new PaseoLacustre());
    }
    public List<Registrable> getListaRegistrables() {
        return listaRegistrables;
    }
    public void setListaRegistrables(List<Registrable> listaRegistrables) {
        this.listaRegistrables = listaRegistrables;
    }

    public void cargarDatos() { //Cargar los datos desde archivo .txt y los transforma en objetos según a qué clase corresponda
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            ServicioTuristico servicio;
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] partes = linea.split(",");

                    if (partes[0].equals("Cliente") && partes[6].equals("ExcursionCultural")) {
                        servicio = new ExcursionCultural();
                        Cliente cliente = new Cliente(partes[1], partes[2], partes[3], Integer.parseInt(partes[4]), Integer.parseInt(partes[5]), servicio);
                        listaRegistrables.add(cliente);
                    }else if (partes[0].equals("Cliente") && partes[6].equals("PaseoLacustre")){
                        servicio = new PaseoLacustre();
                        Cliente cliente = new Cliente(partes[1], partes[2], partes[3], Integer.parseInt(partes[4]), Integer.parseInt(partes[5]), servicio);
                        listaRegistrables.add(cliente);
                    }
                    if (partes[0].equals("Guia") && partes[4].equals("ExcursionCultural")){
                        servicio = new ExcursionCultural();
                        GuiaTuristico guia = new GuiaTuristico(partes[1], partes[2], Integer.parseInt(partes[3]), servicio);
                        listaRegistrables.add(guia);
                    }else if (partes[0].equals("Guia") && partes[4].equals("PaseoLacustre")){
                        servicio = new PaseoLacustre();
                        GuiaTuristico guia = new GuiaTuristico(partes[1], partes[2], Integer.parseInt(partes[3]), servicio);
                        listaRegistrables.add(guia);
                    }
                }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar información.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void guardarInformacionAlCerrar() { //Se recorren los objetos de la lista, y según el instanceof, escribe el objeto en el archivo
        //Pero antes coloca un "cliente" o "guia" para luego, al cargar datos, se sepa a que clase pertenece
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE));
            for (Registrable registrado : listaRegistrables) {
                if (registrado instanceof Cliente) {
                    Cliente cliente = (Cliente) registrado;
                    bw.write("Cliente" + "," + cliente.getNombreCompleto() + "," + cliente.getRut() + "," +
                            cliente.getNumeroTarjetaCLiente() + "," + cliente.getIdCliente() + "," + cliente.getOrdenDeCompra()
                            + "," + cliente.getServicioAdquirido().getClass().getSimpleName());
                    bw.newLine();
                } else if (registrado instanceof GuiaTuristico) {
                    GuiaTuristico guia = (GuiaTuristico) registrado;
                    bw.write("Guia" + "," + guia.getNombreCompleto() + "," + guia.getRut() + "," + guia.getIdTrabajador()
                            + "," + guia.getServicioTuristicoAcargo().getClass().getSimpleName());
                    bw.newLine();
                }
            }
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar información.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
