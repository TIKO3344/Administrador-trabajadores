package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Administrativo;
import modelo.Obrero;
import modelo.Persona;
import modelo.Repositorio;
import modelo.Tecnico;
import vista.VentanaPrincipal;


public class ControladorEmpleados {

    private VentanaPrincipal vista;

    private Repositorio<Administrativo> repoAdmin = new Repositorio<>();
    private Repositorio<Obrero> repoObrero = new Repositorio<>();
    private Repositorio<Tecnico> repoTecnico = new Repositorio<>();

    public ControladorEmpleados(VentanaPrincipal vista) {
        this.vista = vista;
        iniciarEventos();
    }

    private Long validarYConvertirCedula(String cedulaTexto) {
        if (cedulaTexto.length() != 10) {
            JOptionPane.showMessageDialog(vista, "Error (RF-06): La cedula debe tener exactamente 10 digitos.");
            return null;
        }
        try {
            long numPrimitivo = Long.parseLong(cedulaTexto);
            if (numPrimitivo <= 0) {
                JOptionPane.showMessageDialog(vista, "Error (RF-06): La cedula solo debe contener numeros positivos.");
                return null;
            }
            
            Long cedulaObjeto = Long.valueOf(numPrimitivo);
            return cedulaObjeto;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error (RF-06): La cedula debe ser completamente numerica (sin letras).");
            return null;
        }
    }

   
    private boolean existeCedula(Long cedula) {
        if (Repositorio.buscarPorCedula(repoAdmin.getLista(), cedula) != null) {
            return true;
        }
        if (Repositorio.buscarPorCedula(repoObrero.getLista(), cedula) != null) {
            return true;
        }
        if (Repositorio.buscarPorCedula(repoTecnico.getLista(), cedula) != null) {
            return true;
        }
        return false;
    }

    private void iniciarEventos() {

      
        vista.menuIrAdmin.addActionListener(e -> vista.pestanas.setSelectedIndex(0));
        vista.menuIrObrero.addActionListener(e -> vista.pestanas.setSelectedIndex(1));
        vista.menuIrTecnico.addActionListener(e -> vista.pestanas.setSelectedIndex(2));
        vista.menuIrConsulta.addActionListener(e -> vista.pestanas.setSelectedIndex(3));

      
        vista.btnGuardarAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = vista.txtNomAdmin.getText().trim();
                String cedTxt = vista.txtCedAdmin.getText().trim();
                String cargo = vista.txtCargoAdmin.getText().trim();

                if (nom.isEmpty() || cedTxt.isEmpty() || cargo.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "Error (RF-06): Todos los campos del administrativo son obligatorios.");
                    return;
                }

                Long cedulaBoxed = validarYConvertirCedula(cedTxt);
                if (cedulaBoxed == null) {
                    return;
                }

                if (existeCedula(cedulaBoxed)) {
                    JOptionPane.showMessageDialog(vista, "Error (RF-06): Ya existe un empleado registrado con esa cedula.");
                    return;
                }

              
                Administrativo nuevo = new Administrativo(nom, cedulaBoxed, cargo);
                repoAdmin.registrar(nuevo);

                JOptionPane.showMessageDialog(vista, "Administrativo registrado con exito.");
                vista.txtNomAdmin.setText("");
                vista.txtCedAdmin.setText("");
                vista.txtCargoAdmin.setText("");
            }
        });

        vista.btnLimpiarAdmin.addActionListener(e -> {
            vista.txtNomAdmin.setText("");
            vista.txtCedAdmin.setText("");
            vista.txtCargoAdmin.setText("");
        });

       
        vista.btnGuardarObrero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = vista.txtNomObrero.getText().trim();
                String cedTxt = vista.txtCedObrero.getText().trim();
                String cod = vista.txtCodObrero.getText().trim();

                if (nom.isEmpty() || cedTxt.isEmpty() || cod.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "Error (RF-06): Todos los campos del obrero son obligatorios.");
                    return;
                }

                Long cedulaBoxed = validarYConvertirCedula(cedTxt);
                if (cedulaBoxed == null) {
                    return;
                }

                if (existeCedula(cedulaBoxed)) {
                    JOptionPane.showMessageDialog(vista, "Error (RF-06): Ya existe un empleado registrado con esa cedula.");
                    return;
                }

                Obrero nuevo = new Obrero(nom, cedulaBoxed, cod);
                repoObrero.registrar(nuevo);

                JOptionPane.showMessageDialog(vista, "Obrero registrado con exito.");
                vista.txtNomObrero.setText("");
                vista.txtCedObrero.setText("");
                vista.txtCodObrero.setText("");
            }
        });

        vista.btnLimpiarObrero.addActionListener(e -> {
            vista.txtNomObrero.setText("");
            vista.txtCedObrero.setText("");
            vista.txtCodObrero.setText("");
        });

        
        vista.btnGuardarTecnico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = vista.txtNomTecnico.getText().trim();
                String cedTxt = vista.txtCedTecnico.getText().trim();
                String cod = vista.txtCodTecnico.getText().trim();
                String clave = vista.txtClaveTecnico.getText().trim();

                if (nom.isEmpty() || cedTxt.isEmpty() || cod.isEmpty() || clave.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "Error (RF-06): Todos los campos del tecnico son obligatorios.");
                    return;
                }

                Long cedulaBoxed = validarYConvertirCedula(cedTxt);
                if (cedulaBoxed == null) {
                    return;
                }

                if (existeCedula(cedulaBoxed)) {
                    JOptionPane.showMessageDialog(vista, "Error (RF-06): Ya existe un empleado registrado con esa cedula.");
                    return;
                }

                Tecnico nuevo = new Tecnico(nom, cedulaBoxed, cod, clave);
                repoTecnico.registrar(nuevo);

                JOptionPane.showMessageDialog(vista, "Tecnico registrado con exito.");
                vista.txtNomTecnico.setText("");
                vista.txtCedTecnico.setText("");
                vista.txtCodTecnico.setText("");
                vista.txtClaveTecnico.setText("");
            }
        });

        vista.btnLimpiarTecnico.addActionListener(e -> {
            vista.txtNomTecnico.setText("");
            vista.txtCedTecnico.setText("");
            vista.txtCodTecnico.setText("");
            vista.txtClaveTecnico.setText("");
        });

     
        vista.btnBuscarCedula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedTxt = vista.txtCedulaBuscar.getText().trim();
                if (cedTxt.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "Ingrese un numero de cedula para consultar.");
                    return;
                }

                Long cedulaBoxed = validarYConvertirCedula(cedTxt);
                if (cedulaBoxed == null) {
                    return;
                }

                
                Persona encontrado = Repositorio.buscarPorCedula(repoAdmin.getLista(), cedulaBoxed);
                if (encontrado == null) {
                    encontrado = Repositorio.buscarPorCedula(repoObrero.getLista(), cedulaBoxed);
                }
                if (encontrado == null) {
                    encontrado = Repositorio.buscarPorCedula(repoTecnico.getLista(), cedulaBoxed);
                }

                if (encontrado != null) {
                    vista.areaResultados.setText("=== RESULTADO DE LA CONSULTA (RF-04) ===\n\n" + encontrado.informacion());
                } else {
                    vista.areaResultados.setText("No se encontro ningun empleado con la cedula: " + cedTxt);
                    JOptionPane.showMessageDialog(vista, "Empleado no encontrado.");
                }
            }
        });

        
        vista.btnListarAdmin.addActionListener(e -> {
            vista.areaResultados.setText("=== LISTA DE ADMINISTRATIVOS (" + repoAdmin.getTotalRegistros() + ") ===\n"
                    + Repositorio.listarElementos(repoAdmin.getLista()));
        });

        vista.btnListarObreros.addActionListener(e -> {
            vista.areaResultados.setText("=== LISTA DE OBREROS (" + repoObrero.getTotalRegistros() + ") ===\n"
                    + Repositorio.listarElementos(repoObrero.getLista()));
        });

        vista.btnListarTecnicos.addActionListener(e -> {
            vista.areaResultados.setText("=== LISTA DE TECNICOS (" + repoTecnico.getTotalRegistros() + ") ===\n"
                    + Repositorio.listarElementos(repoTecnico.getLista()));
        });

        vista.btnListarTodos.addActionListener(e -> {
            String todo = "=== LISTADO GENERAL DE EMPLEADOS ===\n\n"
                    + "--- ADMINISTRATIVOS (" + repoAdmin.getTotalRegistros() + ") ---\n"
                    + Repositorio.listarElementos(repoAdmin.getLista()) + "\n"
                    + "--- OBREROS (" + repoObrero.getTotalRegistros() + ") ---\n"
                    + Repositorio.listarElementos(repoObrero.getLista()) + "\n"
                    + "--- TECNICOS (" + repoTecnico.getTotalRegistros() + ") ---\n"
                    + Repositorio.listarElementos(repoTecnico.getLista());
            vista.areaResultados.setText(todo);
        });
    }
}