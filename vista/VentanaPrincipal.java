package vista;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public JMenuItem menuIrAdmin, menuIrObrero, menuIrTecnico, menuIrConsulta;
    public JTabbedPane pestanas;

    public JTextField txtNomAdmin, txtCedAdmin, txtCargoAdmin;
    public JButton btnGuardarAdmin, btnLimpiarAdmin;

    
    public JTextField txtNomObrero, txtCedObrero, txtCodObrero;
    public JButton btnGuardarObrero, btnLimpiarObrero;

    public JTextField txtNomTecnico, txtCedTecnico, txtCodTecnico, txtClaveTecnico;
    public JButton btnGuardarTecnico, btnLimpiarTecnico;

    public JTextField txtCedulaBuscar;
    public JButton btnBuscarCedula, btnListarAdmin, btnListarObreros, btnListarTecnicos, btnListarTodos;
    public JTextArea areaResultados;

    public VentanaPrincipal() {
        setTitle("Sistema de Gestion de Empleados - Practica 03 Genericos");
        setSize(680, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

       
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuModulos = new JMenu("Menu Principal de Formularios");
        menuIrAdmin = new JMenuItem("1. Registrar Administrativo");
        menuIrObrero = new JMenuItem("2. Registrar Obrero");
        menuIrTecnico = new JMenuItem("3. Registrar Tecnico");
        menuIrConsulta = new JMenuItem("4. Consultar y Listar Empleados");

        menuModulos.add(menuIrAdmin);
        menuModulos.add(menuIrObrero);
        menuModulos.add(menuIrTecnico);
        menuModulos.addSeparator();
        menuModulos.add(menuIrConsulta);
        barraMenu.add(menuModulos);
        setJMenuBar(barraMenu);

        pestanas = new JTabbedPane();
        pestanas.setBounds(15, 15, 635, 415);
        add(pestanas);

       
        JPanel panelAdmin = new JPanel();
        panelAdmin.setLayout(null);

        JLabel la1 = new JLabel("REGISTRO DE EMPLEADO ADMINISTRATIVO");
        la1.setBounds(30, 20, 300, 20);
        panelAdmin.add(la1);

        JLabel la2 = new JLabel("Nombre completo:");
        la2.setBounds(30, 65, 130, 20);
        panelAdmin.add(la2);
        txtNomAdmin = new JTextField();
        txtNomAdmin.setBounds(160, 65, 220, 24);
        panelAdmin.add(txtNomAdmin);

        JLabel la3 = new JLabel("Cedula (10 digitos):");
        la3.setBounds(30, 105, 130, 20);
        panelAdmin.add(la3);
        txtCedAdmin = new JTextField();
        txtCedAdmin.setBounds(160, 105, 220, 24);
        panelAdmin.add(txtCedAdmin);

        JLabel la4 = new JLabel("Cargo:");
        la4.setBounds(30, 145, 130, 20);
        panelAdmin.add(la4);
        txtCargoAdmin = new JTextField();
        txtCargoAdmin.setBounds(160, 145, 220, 24);
        panelAdmin.add(txtCargoAdmin);

        btnGuardarAdmin = new JButton("Registrar Administrativo");
        btnGuardarAdmin.setBounds(160, 200, 190, 32);
        panelAdmin.add(btnGuardarAdmin);

        btnLimpiarAdmin = new JButton("Limpiar");
        btnLimpiarAdmin.setBounds(365, 200, 100, 32);
        panelAdmin.add(btnLimpiarAdmin);

        pestanas.addTab("1. Administrativos", panelAdmin);

     
        JPanel panelObrero = new JPanel();
        panelObrero.setLayout(null);

        JLabel lo1 = new JLabel("REGISTRO DE EMPLEADO OBRERO");
        lo1.setBounds(30, 20, 300, 20);
        panelObrero.add(lo1);

        JLabel lo2 = new JLabel("Nombre completo:");
        lo2.setBounds(30, 65, 130, 20);
        panelObrero.add(lo2);
        txtNomObrero = new JTextField();
        txtNomObrero.setBounds(160, 65, 220, 24);
        panelObrero.add(txtNomObrero);

        JLabel lo3 = new JLabel("Cedula (10 digitos):");
        lo3.setBounds(30, 105, 130, 20);
        panelObrero.add(lo3);
        txtCedObrero = new JTextField();
        txtCedObrero.setBounds(160, 105, 220, 24);
        panelObrero.add(txtCedObrero);

        JLabel lo4 = new JLabel("Codigo Obrero:");
        lo4.setBounds(30, 145, 130, 20);
        panelObrero.add(lo4);
        txtCodObrero = new JTextField();
        txtCodObrero.setBounds(160, 145, 220, 24);
        panelObrero.add(txtCodObrero);

        btnGuardarObrero = new JButton("Registrar Obrero");
        btnGuardarObrero.setBounds(160, 200, 190, 32);
        panelObrero.add(btnGuardarObrero);

        btnLimpiarObrero = new JButton("Limpiar");
        btnLimpiarObrero.setBounds(365, 200, 100, 32);
        panelObrero.add(btnLimpiarObrero);

        pestanas.addTab("2. Obreros", panelObrero);

       
        JPanel panelTec = new JPanel();
        panelTec.setLayout(null);

        JLabel lt1 = new JLabel("REGISTRO DE EMPLEADO TECNICO");
        lt1.setBounds(30, 20, 300, 20);
        panelTec.add(lt1);

        JLabel lt2 = new JLabel("Nombre completo:");
        lt2.setBounds(30, 60, 130, 20);
        panelTec.add(lt2);
        txtNomTecnico = new JTextField();
        txtNomTecnico.setBounds(160, 60, 220, 24);
        panelTec.add(txtNomTecnico);

        JLabel lt3 = new JLabel("Cedula (10 digitos):");
        lt3.setBounds(30, 100, 130, 20);
        panelTec.add(lt3);
        txtCedTecnico = new JTextField();
        txtCedTecnico.setBounds(160, 100, 220, 24);
        panelTec.add(txtCedTecnico);

        JLabel lt4 = new JLabel("Codigo Tecnico:");
        lt4.setBounds(30, 140, 130, 20);
        panelTec.add(lt4);
        txtCodTecnico = new JTextField();
        txtCodTecnico.setBounds(160, 140, 220, 24);
        panelTec.add(txtCodTecnico);

        JLabel lt5 = new JLabel("Clave de Acceso:");
        lt5.setBounds(30, 180, 130, 20);
        panelTec.add(lt5);
        txtClaveTecnico = new JTextField();
        txtClaveTecnico.setBounds(160, 180, 220, 24);
        panelTec.add(txtClaveTecnico);

        btnGuardarTecnico = new JButton("Registrar Tecnico");
        btnGuardarTecnico.setBounds(160, 230, 190, 32);
        panelTec.add(btnGuardarTecnico);

        btnLimpiarTecnico = new JButton("Limpiar");
        btnLimpiarTecnico.setBounds(365, 230, 100, 32);
        panelTec.add(btnLimpiarTecnico);

        pestanas.addTab("3. Tecnicos", panelTec);

      
        JPanel panelCons = new JPanel();
        panelCons.setLayout(null);

        JLabel lc1 = new JLabel("Buscar por Cedula:");
        lc1.setBounds(20, 20, 120, 20);
        panelCons.add(lc1);

        txtCedulaBuscar = new JTextField();
        txtCedulaBuscar.setBounds(140, 20, 160, 25);
        panelCons.add(txtCedulaBuscar);

        btnBuscarCedula = new JButton("Consultar Empleado");
        btnBuscarCedula.setBounds(310, 19, 160, 26);
        panelCons.add(btnBuscarCedula);

        btnListarAdmin = new JButton("Listar Admin");
        btnListarAdmin.setBounds(20, 60, 130, 28);
        panelCons.add(btnListarAdmin);

        btnListarObreros = new JButton("Listar Obreros");
        btnListarObreros.setBounds(160, 60, 130, 28);
        panelCons.add(btnListarObreros);

        btnListarTecnicos = new JButton("Listar Tecnicos");
        btnListarTecnicos.setBounds(300, 60, 130, 28);
        panelCons.add(btnListarTecnicos);

        btnListarTodos = new JButton("Listar Todos");
        btnListarTodos.setBounds(440, 60, 160, 28);
        panelCons.add(btnListarTodos);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultados);
        scroll.setBounds(20, 105, 580, 260);
        panelCons.add(scroll);

        pestanas.addTab("4. Consultar y Listar", panelCons);
    }
}