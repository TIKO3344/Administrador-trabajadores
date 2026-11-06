package modelo;

import java.util.ArrayList;

public class Repositorio<T extends Persona> {
    
    private ArrayList<T> listaEmpleados = new ArrayList<>();
    private Integer contadorRegistros = 0; 
    public void registrar(T empleado) {
        listaEmpleados.add(empleado);
        int totalActual = contadorRegistros; 
        totalActual = totalActual + 1;
        contadorRegistros = Integer.valueOf(totalActual); 
    }
    public ArrayList<T> getLista() {
        return listaEmpleados;
    }
    public int getTotalRegistros() {
        
        return contadorRegistros;
    }
    public static <E extends Persona> E buscarPorCedula(ArrayList<E> lista, Long cedulaObjeto) {
        long cedulaPrimitiva = cedulaObjeto.longValue();

        for (int i = 0; i < lista.size(); i++) {
            E emp = lista.get(i);
            if (emp.getCedula() == cedulaPrimitiva) {
                return emp;
            }
        }
        return null;
    }
    public static <E extends Persona> String listarElementos(ArrayList<E> lista) {
        if (lista.isEmpty()) {
            return "No hay empleados registrados en esta categoria.\n";
        }
        String texto = "";
        for (int i = 0; i < lista.size(); i++) {
            E emp = lista.get(i);
            texto = texto + (i + 1) + ". " + emp.informacion() + "\n";
        }
        return texto;
    }
}