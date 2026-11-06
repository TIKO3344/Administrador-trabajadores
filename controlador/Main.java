package controlador;
import vista.VentanaPrincipal;
public class Main {
    public static void main(String[] args) {
        VentanaPrincipal vista = new VentanaPrincipal();
        new ControladorEmpleados(vista);
        vista.setVisible(true);
    }
}