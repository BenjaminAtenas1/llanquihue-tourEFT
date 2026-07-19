package app;

import model.*;
import data.GestorDatos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {
    GestorDatos datos = new GestorDatos();

    public Main() {
        setTitle("Menú principal");
        setSize(170, 210);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        //Este bloque hasta la línea 34 tiene la tarea de que cuando se ejecute el programa, se cargue la información
        //contenida en el archivo de texto con el metodo cargarDatos
        int opcion;
        do {
            opcion = JOptionPane.showConfirmDialog(null, "Bienvenido\nPresione OK para comenzar",
                    "Bienvenido", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Debe presionar OK para cargar datos.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion != JOptionPane.OK_OPTION);
        datos.cargarDatos();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 80, 15, 80));

        JButton botonRegistrar = new JButton("Registrar");
        JButton botonInformacion = new JButton("Ver Información");
        JButton botonModificarDatos = new JButton("Modificar datos");
        JButton botonSalir = new JButton("Salir");

        panel.add(botonRegistrar);
        panel.add(botonInformacion);
        panel.add(botonModificarDatos);
        panel.add(botonSalir);
        add(panel, BorderLayout.CENTER);

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarAlgo();
            }
        });
        botonInformacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verInformacion();
            }
        });
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Al seleccionar salir, se guarda toda la información del arraylist en el archivo de texto
                JOptionPane.showMessageDialog(null, "Has salido.");
                datos.guardarInformacionAlCerrar();
                System.exit(0);
            }
        });
        botonModificarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarDatos();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Si el usuario sale con la X del programa, se guarda toda la información del arraylist en el archivo de texto
                datos.guardarInformacionAlCerrar();
                dispose();
                System.exit(0);
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void registrarAlgo() {
        JOptionPane.showMessageDialog(null, "A continuación, ingrese su opción", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        JFrame frame = new JFrame("Registro");
        frame.setDefaultCloseOperation((JFrame.DISPOSE_ON_CLOSE));
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        JRadioButton opcionCliente = new JRadioButton("Cliente");
        JRadioButton opcionGuia = new JRadioButton("Guía turistico");
        panel.setLayout(null);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(opcionCliente);
        grupo.add(opcionGuia);

        JButton botonAceptar = new JButton("Confirmar");

        opcionCliente.setBounds(80,25,140,25);
        opcionGuia.setBounds(80,60,140,25);
        botonAceptar.setBounds(85,110,115,30);

        panel.add(opcionCliente);
        panel.add(opcionGuia);
        panel.add(botonAceptar);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opcionCliente.isSelected()) {
                    JOptionPane.showMessageDialog(null, "A continuación ingrese la información del" +
                            " cliente", "Registro de cliente", JOptionPane.INFORMATION_MESSAGE);

                    JFrame ventanaCliente = new JFrame("Registro de cliente.");
                    ventanaCliente.setSize(400, 350);
                    ventanaCliente.setLayout(null);
                    ventanaCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JLabel labelNombre = new JLabel("Nombre: ");
                    JLabel labelRut = new JLabel("Rut: ");
                    JLabel labelTarjeta = new JLabel("Nro Tarjeta: ");
                    JLabel labelID = new JLabel("ID Cliente: ");
                    JLabel labelOrdenCompra = new JLabel("Orden de compra: ");

                    JTextField campoNombre = new JTextField();
                    JTextField campoRut = new JTextField();
                    JTextField campoTarjeta = new JTextField();
                    JTextField campoID = new JTextField();
                    JTextField campoOrdenCompra = new JTextField();

                    JRadioButton opcionExcursionCultural = new JRadioButton("Excursión cultural");
                    JRadioButton opcionPaseoLacustre = new JRadioButton("Paseo Lacustre");

                    JButton botonAgregar = new JButton("Agregar Cliente");

                    labelNombre.setBounds(30, 20, 120, 25);
                    campoNombre.setBounds(160, 20, 180, 25);

                    labelRut.setBounds(30, 55, 120, 25);
                    campoRut.setBounds(160, 55, 180, 25);

                    labelTarjeta.setBounds(30, 90, 120, 25);
                    campoTarjeta.setBounds(160, 90, 180, 25);

                    labelID.setBounds(30, 125, 120, 25);
                    campoID.setBounds(160, 125, 180, 25);

                    labelOrdenCompra.setBounds(30, 160, 120, 25);
                    campoOrdenCompra.setBounds(160, 160, 180, 25);

                    opcionExcursionCultural.setBounds(40, 200, 150, 25);
                    opcionPaseoLacustre.setBounds(200, 200, 150, 25);

                    botonAgregar.setBounds(120, 250, 160, 30);

                    ventanaCliente.add(labelNombre);
                    ventanaCliente.add(campoNombre);
                    ventanaCliente.add(labelRut);
                    ventanaCliente.add(campoRut);
                    ventanaCliente.add(labelTarjeta);
                    ventanaCliente.add(campoTarjeta);
                    ventanaCliente.add(labelID);
                    ventanaCliente.add(campoID);
                    ventanaCliente.add(labelOrdenCompra);
                    ventanaCliente.add(campoOrdenCompra);
                    ventanaCliente.add(opcionExcursionCultural);
                    ventanaCliente.add(opcionPaseoLacustre);
                    ventanaCliente.add(botonAgregar);

                    ventanaCliente.setLocationRelativeTo(null);
                    ventanaCliente.setVisible(true);

                    botonAgregar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //Validaciones para que nada quede vacío
                            if (campoNombre.getText().trim().isEmpty() || campoRut.getText().trim().isEmpty() ||
                                    campoTarjeta.getText().trim().isEmpty() || campoID.getText().trim().isEmpty() ||
                                    campoOrdenCompra.getText().trim().isEmpty() || !opcionExcursionCultural.isSelected()
                                    && !opcionPaseoLacustre.isSelected()) {
                                JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos solicitados antes de registrar", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            try { //Según la selección del tipo de servicio, se crea al cliente y se le agregar el servicio seleccionado
                                if (opcionExcursionCultural.isSelected()) {
                                    String nombreCompleto = campoNombre.getText();
                                    String rut = campoRut.getText();
                                    //A continuación validación de formato RUT chileno y largo de la tarjeta (12 números)
                                    Validaciones validaciones;
                                    Boolean validacion = Validaciones.validarRut(rut);
                                    String numeroTarjetaCliente = campoTarjeta.getText();
                                    Boolean validacion2 = Validaciones.validarNroTarjeta(numeroTarjetaCliente);
                                    int idCliente = Integer.parseInt(campoID.getText());
                                    int ordenDeCompra = Integer.parseInt(campoOrdenCompra.getText());

                                    Cliente cliente1 = new Cliente(nombreCompleto, rut, numeroTarjetaCliente, idCliente, ordenDeCompra, (new ExcursionCultural()));
                                    datos.getListaRegistrables().add(cliente1);

                                    JOptionPane.showMessageDialog(null, "Cliente creado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                                    ventanaCliente.dispose();
                                    frame.dispose();

                                } else if (opcionPaseoLacustre.isSelected()) {
                                    String nombreCompleto = campoNombre.getText();
                                    String rut = campoRut.getText();
                                    //validación de formato RUT chileno y largo de la tarjeta (12 números)
                                    Validaciones validaciones;
                                    Boolean validacion = Validaciones.validarRut(rut);
                                    String numeroTarjetaCliente = campoTarjeta.getText();
                                    Boolean validacion2 = Validaciones.validarNroTarjeta(numeroTarjetaCliente);
                                    int idCliente = Integer.parseInt(campoID.getText());
                                    int ordenDeCompra = Integer.parseInt(campoOrdenCompra.getText());

                                    Cliente cliente1 = new Cliente(nombreCompleto, rut, numeroTarjetaCliente, idCliente, ordenDeCompra, (new PaseoLacustre()));
                                    datos.getListaRegistrables().add(cliente1);

                                    JOptionPane.showMessageDialog(null, "Cliente creado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                                    ventanaCliente.dispose();
                                    frame.dispose();
                                }

                            } catch (RutInvalidoException ea) {
                                JOptionPane.showMessageDialog(null, ea.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (NroTarjetaInvalidoException ai) {
                                JOptionPane.showMessageDialog(null, ai.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (NumberFormatException ae) {
                                JOptionPane.showMessageDialog(null, "Ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (Exception a) {
                                JOptionPane.showMessageDialog(null, "Error al guardar la información (Revise el rut).", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                } else if (opcionGuia.isSelected()) {
                    JOptionPane.showMessageDialog(null, "A continuación ingrese la información del" +
                            " guía turistico", "Registro de guía turistico", JOptionPane.INFORMATION_MESSAGE);

                    JFrame ventanaGuia = new JFrame("Registro de guía turistico.");
                    ventanaGuia.setSize(400, 320);
                    ventanaGuia.setLayout(null);
                    ventanaGuia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JLabel labelNombreGuia = new JLabel("Nombre: ");
                    JLabel labelRutGuia = new JLabel("Rut: ");
                    JLabel labelIDGuia = new JLabel("ID Guía: ");

                    JTextField campoNombreGuia = new JTextField();
                    JTextField campoRutGuia = new JTextField();
                    JTextField campoIDGuia = new JTextField();

                    JRadioButton opcionExcursionCulturalGuia = new JRadioButton("Excursión cultural");
                    JRadioButton opcionPaseoLacustreGuia = new JRadioButton("Paseo Lacustre");

                    JButton botonAgregarGuia = new JButton("Agregar Guía");

                    labelNombreGuia.setBounds(30, 20, 120, 25);
                    campoNombreGuia.setBounds(160, 20, 180, 25);

                    labelRutGuia.setBounds(30, 60, 120, 25);
                    campoRutGuia.setBounds(160, 60, 180, 25);

                    labelIDGuia.setBounds(30, 100, 120, 25);
                    campoIDGuia.setBounds(160, 100, 180, 25);

                    opcionExcursionCulturalGuia.setBounds(40, 150, 150, 25);
                    opcionPaseoLacustreGuia.setBounds(200, 150, 150, 25);

                    botonAgregarGuia.setBounds(120, 210, 160, 30);

                    ventanaGuia.add(labelNombreGuia);
                    ventanaGuia.add(campoNombreGuia);
                    ventanaGuia.add(labelRutGuia);
                    ventanaGuia.add(campoRutGuia);
                    ventanaGuia.add(labelIDGuia);
                    ventanaGuia.add(campoIDGuia);
                    ventanaGuia.add(opcionExcursionCulturalGuia);
                    ventanaGuia.add(opcionPaseoLacustreGuia);
                    ventanaGuia.add(botonAgregarGuia);

                    ventanaGuia.setLocationRelativeTo(null);
                    ventanaGuia.setVisible(true);

                    botonAgregarGuia.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { //Se asegura que ningún dato quede vacío
                            if (campoNombreGuia.getText().trim().isEmpty() || campoRutGuia.getText().trim().isEmpty() || campoIDGuia.getText().trim().isEmpty()
                                    || !opcionExcursionCulturalGuia.isSelected()
                                    && !opcionPaseoLacustreGuia.isSelected()) {
                                JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos solicitados antes de registrar", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            try {
                                if (opcionExcursionCulturalGuia.isSelected()) {
                                    String nombreCompleto = campoNombreGuia.getText();
                                    String rut = campoRutGuia.getText();
                                    Validaciones validaciones2; //Validación del formato del rut
                                    Boolean validacion2 = Validaciones.validarRut(rut);
                                    int idGuia = Integer.parseInt(campoIDGuia.getText());
                                    GuiaTuristico guia1 = new GuiaTuristico(nombreCompleto,rut,idGuia,(new ExcursionCultural()));
                                    datos.getListaRegistrables().add(guia1);

                                    JOptionPane.showMessageDialog(null, "Guía creado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                                    ventanaGuia.dispose();
                                    frame.dispose();

                                }else if(opcionPaseoLacustreGuia.isSelected()){
                                    String nombreCompleto = campoNombreGuia.getText();
                                    String rut = campoRutGuia.getText();
                                    Validaciones validaciones2; //Validación del rut
                                    Boolean validacion2 = Validaciones.validarRut(rut);
                                    int idGuia = Integer.parseInt(campoIDGuia.getText());
                                    GuiaTuristico guia1 = new GuiaTuristico(nombreCompleto,rut,idGuia,(new PaseoLacustre()));
                                    datos.getListaRegistrables().add(guia1);

                                    JOptionPane.showMessageDialog(null, "Guía creado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                                    ventanaGuia.dispose();
                                    frame.dispose();
                                }
                            } catch (RutInvalidoException aa) {
                                JOptionPane.showMessageDialog(null, aa.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (NumberFormatException ae) {
                                JOptionPane.showMessageDialog(null, "Ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (Exception a) {
                                JOptionPane.showMessageDialog(null, "Error al guardar la información (Revise el rut).", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });

                }
            }
        });
    }
    public void verInformacion(){ //Mostrará clientes, guías turisticos y servicios
        String[] opciones = {"Clientes","Guías turisticos","Servicios"};

        String opcion = (String) JOptionPane.showInputDialog(null,"¿Qué información desea visualizar?","Información",JOptionPane.PLAIN_MESSAGE,
                null, opciones,opciones[0]);
        if (opcion == null) {
            return;
        }
        boolean hayClientes = false;
        boolean hayGuias = false;

        if (opcion.equals("Clientes")){ //Se meustra clientes
            JFrame ventanaInformacion = new JFrame("Información de clientes.");
            ventanaInformacion.setSize(400, 370);
            ventanaInformacion.setLayout(null);
            ventanaInformacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JTextArea area = new JTextArea();
            JScrollPane scroll = new JScrollPane(area);
            scroll.setBounds(10,50,360,260);
            ventanaInformacion.add(scroll);

            ventanaInformacion.setLocationRelativeTo(null);
            ventanaInformacion.setVisible(true);
            area.setEditable(false);
            area.setFocusable(false);

            for (Registrable registrados : datos.getListaRegistrables()) {
                if (registrados instanceof Cliente) {
                    area.append(registrados.mostrarInformacion());
                    area.append("\n");
                    hayClientes = true;
                }
            }
                if(!hayClientes){
                    JOptionPane.showMessageDialog(null,"No hay clientes registrados", "Error", JOptionPane.WARNING_MESSAGE);
                    ventanaInformacion.dispose();
                    return;
                }

        }
        if (opcion.equals("Guías turisticos")){ //Se muestran los guías
            JFrame ventanaInformacion = new JFrame("Información guías turisticos");
            ventanaInformacion.setSize(400, 370);
            ventanaInformacion.setLayout(null);
            ventanaInformacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JTextArea areaGuia = new JTextArea();
            JScrollPane scroll = new JScrollPane(areaGuia);
            scroll.setBounds(10,50,360,260);
            ventanaInformacion.add(scroll);

            ventanaInformacion.setLocationRelativeTo(null);
            ventanaInformacion.setVisible(true);
            areaGuia.setEditable(false);
            areaGuia.setFocusable(false);

            for (Registrable registrados : datos.getListaRegistrables()) {
                if (registrados instanceof GuiaTuristico) {
                    areaGuia.append(registrados.mostrarInformacion());
                    areaGuia.append("\n");
                    hayGuias = true;
                }
            }
                if(!hayGuias){
                    JOptionPane.showMessageDialog(null,"No hay guías turísticos registrados", "Error", JOptionPane.WARNING_MESSAGE);
                    ventanaInformacion.dispose();
                    return;
                }

        }
        if(opcion.equals("Servicios")){ //Se puede mostrar sólo el paseo, sólo excursiones o ambos a la vez
            JFrame frameServicios = new JFrame("Servicios");
            frameServicios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameServicios.setSize(300,250);

            JPanel panelServicios = new JPanel();
            JRadioButton opcionExcursion = new JRadioButton("Excursión cultural");
            JRadioButton opcionPaseo = new JRadioButton("Paseo Lacustre");
            JRadioButton opcionTodos = new JRadioButton("Todos los servicios");

            ButtonGroup grupo = new ButtonGroup();

            grupo.add(opcionExcursion);
            grupo.add(opcionPaseo);
            grupo.add(opcionTodos);

            panelServicios.setLayout(null);

            JButton botonVerServicios = new JButton("Seleccionar");

            opcionExcursion.setBounds(80,25,140,25);
            opcionPaseo.setBounds(80,60,140,25);
            opcionTodos.setBounds(80,95,140,25);
            botonVerServicios.setBounds(85,145,115,30);

            panelServicios.add(opcionExcursion);
            panelServicios.add(opcionPaseo);
            panelServicios.add(opcionTodos);
            panelServicios.add(botonVerServicios);

            frameServicios.add(panelServicios);
            frameServicios.setLocationRelativeTo(null);
            frameServicios.setVisible(true);

            botonVerServicios.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    JFrame ventanaInformacion = new JFrame("Información de los servicios");
                    ventanaInformacion.setSize(400, 370);
                    ventanaInformacion.setLayout(null);
                    ventanaInformacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JTextArea area = new JTextArea();
                    JScrollPane scroll = new JScrollPane(area);
                    scroll.setBounds(10,50,360,260);
                    ventanaInformacion.add(scroll);
                    for (Registrable registrados : datos.getListaRegistrables()){
                        if(opcionExcursion.isSelected() && registrados instanceof ExcursionCultural){
                            registrados.mostrarInformacion();
                        }else if (opcionPaseo.isSelected() && registrados instanceof PaseoLacustre){
                            registrados.mostrarInformacion();
                        }else if (opcionTodos.isSelected() && (registrados instanceof ExcursionCultural || registrados instanceof PaseoLacustre)){
                            area.append(registrados.toString());
                            area.append("\n");

                            ventanaInformacion.setLocationRelativeTo(null);
                            ventanaInformacion.setVisible(true);
                            area.setEditable(false);
                            area.setFocusable(false);
                        }
                    }
                }
            });
        }
    }
    public void modificarDatos(){
        int claveJefe = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su clave: ",
                "Validación de seguridad",JOptionPane.QUESTION_MESSAGE));
        //Validacion hipotética de que sólo puede ingresar un jefe a modificar la informacion
        if (claveJefe != 4152){
            JOptionPane.showMessageDialog(null,"ACCESO DENEGADO","Alerta",JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null,"Seleccione qué desea modificar.", "Modificar datos", JOptionPane.INFORMATION_MESSAGE);

        JFrame frame = new JFrame("Registro");
        frame.setDefaultCloseOperation((JFrame.DISPOSE_ON_CLOSE));
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        JRadioButton opcionCliente = new JRadioButton("Cliente");
        JRadioButton opcionGuia = new JRadioButton("Guía turistico");
        panel.setLayout(null);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(opcionCliente);
        grupo.add(opcionGuia);

        JButton botonAceptar = new JButton("Confirmar");

        opcionCliente.setBounds(80,25,140,25);
        opcionGuia.setBounds(80,60,140,25);
        botonAceptar.setBounds(85,110,115,30);

        panel.add(opcionCliente);
        panel.add(opcionGuia);
        panel.add(botonAceptar);

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(opcionCliente.isSelected()){ //Si se selecciona cliente, se puede modificar los datos menos ID y orden de compra, ya que aquellos no deberían cambiar
                    int clienteAmodificar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del cliente.","ID CLiente", JOptionPane.INFORMATION_MESSAGE));
                    for (Registrable registrados : datos.getListaRegistrables()){
                        if (registrados instanceof Cliente) {
                            Cliente cliente = (Cliente) registrados;
                            if (cliente.getIdCliente() == clienteAmodificar) {
                                JOptionPane.showMessageDialog(null,"Puede editar nombre, RUT y Nro tarjeta.");

                                JFrame ventanaCliente = new JFrame("Edición de cliente.");
                                ventanaCliente.setSize(400, 350);
                                ventanaCliente.setLayout(null);
                                ventanaCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JLabel labelNombre = new JLabel("Nombre: ");
                                JLabel labelRut = new JLabel("Rut: ");
                                JLabel labelTarjeta = new JLabel("Nro Tarjeta: ");
                                JLabel labelID = new JLabel("ID Cliente: ");
                                JLabel labelOrdenCompra = new JLabel("Orden de compra: ");

                                JTextField campoNombre = new JTextField(((Cliente) registrados).getNombreCompleto());
                                JTextField campoRut = new JTextField(((Cliente) registrados).getRut());
                                JTextField campoTarjeta = new JTextField(((Cliente) registrados).getNumeroTarjetaCLiente());
                                JTextField campoID = new JTextField(String.valueOf(((Cliente) registrados).getIdCliente()));
                                JTextField campoOrdenCompra = new JTextField(String.valueOf(((Cliente) registrados).getOrdenDeCompra()));

                                JRadioButton opcionExcursionCultural = new JRadioButton("Excursión cultural");
                                JRadioButton opcionPaseoLacustre = new JRadioButton("Paseo Lacustre");

                                JButton botonAgregar = new JButton("Guardar");

                                labelNombre.setBounds(30, 20, 120, 25);
                                campoNombre.setBounds(160, 20, 180, 25);

                                labelRut.setBounds(30, 55, 120, 25);
                                campoRut.setBounds(160, 55, 180, 25);

                                labelTarjeta.setBounds(30, 90, 120, 25);
                                campoTarjeta.setBounds(160, 90, 180, 25);

                                labelID.setBounds(30, 125, 120, 25);
                                campoID.setBounds(160, 125, 180, 25);

                                labelOrdenCompra.setBounds(30, 160, 120, 25);
                                campoOrdenCompra.setBounds(160, 160, 180, 25);

                                opcionExcursionCultural.setBounds(40, 200, 150, 25);
                                opcionPaseoLacustre.setBounds(200, 200, 150, 25);

                                botonAgregar.setBounds(120, 250, 160, 30);

                                campoID.setEditable(false);
                                campoOrdenCompra.setEditable(false);

                                ventanaCliente.add(labelNombre);
                                ventanaCliente.add(campoNombre);
                                ventanaCliente.add(labelRut);
                                ventanaCliente.add(campoRut);
                                ventanaCliente.add(labelTarjeta);
                                ventanaCliente.add(campoTarjeta);
                                ventanaCliente.add(labelID);
                                ventanaCliente.add(campoID);
                                ventanaCliente.add(labelOrdenCompra);
                                ventanaCliente.add(campoOrdenCompra);
                                ventanaCliente.add(opcionExcursionCultural);
                                ventanaCliente.add(opcionPaseoLacustre);

                                ventanaCliente.add(botonAgregar);

                                ventanaCliente.setLocationRelativeTo(null);
                                ventanaCliente.setVisible(true);

                                botonAgregar.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (campoNombre.getText().trim().isEmpty() || campoRut.getText().trim().isEmpty() || campoID.getText().trim().isEmpty()
                                                || !opcionExcursionCultural.isSelected()
                                                && !opcionPaseoLacustre.isSelected()) {
                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos solicitados antes de registrar", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        try {
                                            if (opcionExcursionCultural.isSelected()) {
                                                cliente.setNombreCompleto(campoNombre.getText());
                                                cliente.setRut(campoRut.getText());
                                                Validaciones validaciones;
                                                Boolean validacion = Validaciones.validarRut(campoRut.getText());
                                                cliente.setNumeroTarjetaCLiente(campoTarjeta.getText());
                                                Boolean validacion2 = Validaciones.validarNroTarjeta(campoTarjeta.getText());
                                                cliente.setIdCliente(Integer.parseInt(campoID.getText()));
                                                cliente.setOrdenDeCompra(Integer.parseInt(campoOrdenCompra.getText()));
                                                cliente.setServicioAdquirido(new ExcursionCultural());

                                                JOptionPane.showMessageDialog(null, "Cliente modificado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                                                ventanaCliente.dispose();
                                            } else if (opcionPaseoLacustre.isSelected()) {
                                                cliente.setNombreCompleto(campoNombre.getText());
                                                cliente.setRut(campoRut.getText());
                                                Validaciones validaciones;
                                                Boolean validacion = Validaciones.validarRut(campoRut.getText());
                                                cliente.setNumeroTarjetaCLiente(campoTarjeta.getText());
                                                Boolean validacion2 = Validaciones.validarNroTarjeta(campoTarjeta.getText());
                                                cliente.setIdCliente(Integer.parseInt(campoID.getText()));
                                                cliente.setOrdenDeCompra(Integer.parseInt(campoOrdenCompra.getText()));
                                                cliente.setServicioAdquirido(new PaseoLacustre());

                                                JOptionPane.showMessageDialog(null, "Cliente modificado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                                                ventanaCliente.dispose();
                                            }
                                        } catch (RutInvalidoException ea) {
                                            JOptionPane.showMessageDialog(null, ea.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                        } catch (NroTarjetaInvalidoException ai) {
                                            JOptionPane.showMessageDialog(null, ai.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                        } catch (NumberFormatException ae) {
                                            JOptionPane.showMessageDialog(null, "Ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
                                        } catch (Exception a) {
                                            JOptionPane.showMessageDialog(null, "Error al guardar la información (Revise el rut).", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                });
                            }else if (cliente.getIdCliente() != clienteAmodificar){
                                JOptionPane.showMessageDialog(null,"Cliente no encontrado.","Error",JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        }
                    }
                }else if(opcionGuia.isSelected()){ //Al guía se le puede modifcar todo salvo ID
                    int guiaAmodificar = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el ID del guía a modificar.","ID guía",JOptionPane.INFORMATION_MESSAGE));
                    boolean encontrado = false;
                    for (Registrable registrados : datos.getListaRegistrables()){
                        if (registrados instanceof GuiaTuristico){
                            GuiaTuristico guia = (GuiaTuristico) registrados;
                            if (guia.getIdTrabajador() == guiaAmodificar){
                                encontrado = true;

                                JOptionPane.showMessageDialog(null,"Puede editar nombre, RUT y servicio a cargo.");
                                JFrame ventanaGuia = new JFrame("Edición de guía.");
                                ventanaGuia.setSize(400, 320);
                                ventanaGuia.setLayout(null);
                                ventanaGuia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JLabel labelNombreGuia = new JLabel("Nombre: ");
                                JLabel labelRutGuia = new JLabel("Rut: ");
                                JLabel labelIDGuia = new JLabel("ID Guía: ");

                                JTextField campoNombreGuia = new JTextField(((GuiaTuristico) registrados).getNombreCompleto());
                                JTextField campoRutGuia = new JTextField(((GuiaTuristico) registrados).getRut());
                                JTextField campoIDGuia = new JTextField(String.valueOf(guia.getIdTrabajador()));

                                JRadioButton opcionExcursionCulturalGuia = new JRadioButton("Excursión cultural");
                                JRadioButton opcionPaseoLacustreGuia = new JRadioButton("Paseo Lacustre");

                                JButton botonAgregarGuia = new JButton("Guardar");

                                labelNombreGuia.setBounds(30, 20, 120, 25);
                                campoNombreGuia.setBounds(160, 20, 180, 25);

                                labelRutGuia.setBounds(30, 60, 120, 25);
                                campoRutGuia.setBounds(160, 60, 180, 25);

                                labelIDGuia.setBounds(30, 100, 120, 25);
                                campoIDGuia.setBounds(160, 100, 180, 25);

                                opcionExcursionCulturalGuia.setBounds(40, 150, 150, 25);
                                opcionPaseoLacustreGuia.setBounds(200, 150, 150, 25);

                                botonAgregarGuia.setBounds(120, 210, 160, 30);

                                campoIDGuia.setEditable(false);

                                ventanaGuia.add(labelNombreGuia);
                                ventanaGuia.add(campoNombreGuia);
                                ventanaGuia.add(labelRutGuia);
                                ventanaGuia.add(campoRutGuia);
                                ventanaGuia.add(labelIDGuia);
                                ventanaGuia.add(campoIDGuia);
                                ventanaGuia.add(opcionExcursionCulturalGuia);
                                ventanaGuia.add(opcionPaseoLacustreGuia);
                                ventanaGuia.add(botonAgregarGuia);

                                ventanaGuia.setLocationRelativeTo(null);
                                ventanaGuia.setVisible(true);

                                botonAgregarGuia.addActionListener(new ActionListener(){
                                    @Override
                                    public void actionPerformed(ActionEvent e){
                                        if (campoNombreGuia.getText().trim().isEmpty() || campoRutGuia.getText().trim().isEmpty() || campoIDGuia.getText().trim().isEmpty()
                                                || !opcionExcursionCulturalGuia.isSelected()
                                                && !opcionPaseoLacustreGuia.isSelected()) {
                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos solicitados antes de editar", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        try{
                                            if (opcionExcursionCulturalGuia.isSelected()){
                                                guia.setNombreCompleto(campoNombreGuia.getText());
                                                guia.setRut(campoRutGuia.getText());
                                                Validaciones validaciones2;
                                                Boolean validacion2 = Validaciones.validarRut(campoRutGuia.getText());
                                                guia.setIdTrabajador(Integer.parseInt(campoIDGuia.getText()));
                                                guia.setServicioTuristicoAcargo(new ExcursionCultural());

                                                JOptionPane.showMessageDialog(null, "Guía modificado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                                                ventanaGuia.dispose();
                                            }else if (opcionPaseoLacustreGuia.isSelected()){
                                                guia.setNombreCompleto(campoNombreGuia.getText());
                                                guia.setRut(campoRutGuia.getText());
                                                Validaciones validaciones2;
                                                Boolean validacion2 = Validaciones.validarRut(campoRutGuia.getText());
                                                guia.setIdTrabajador(Integer.parseInt(campoIDGuia.getText()));
                                                guia.setServicioTuristicoAcargo(new PaseoLacustre());

                                                JOptionPane.showMessageDialog(null, "Guía modificado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                                                ventanaGuia.dispose();
                                            }
                                        }catch (RutInvalidoException aa) {
                                            JOptionPane.showMessageDialog(null, aa.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                        } catch (NumberFormatException ae) {
                                            JOptionPane.showMessageDialog(null, "Ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
                                        } catch (Exception a) {
                                            JOptionPane.showMessageDialog(null, "Error al guardar la información (Revise el rut).", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                });
                            }
                        }
                    }
                    if (!encontrado){
                        JOptionPane.showMessageDialog(null, "Guía no encontrado.", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}