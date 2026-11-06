package modelo;

public class Persona {
    private String nombre;
    private long cedula;

    public Persona() {
    }

    public Persona(String nombre, long cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public void print(String texto) {
        System.out.println(texto);
    }

    // RF-04, RF-05: Metodo que sera sobrescrito por las clases hijas
    public String informacion() {
        return "Empleado: " + nombre + " | Cedula: " + cedula;
    }
}