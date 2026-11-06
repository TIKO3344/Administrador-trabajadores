package modelo;
public class Administrativo extends Persona {
    private String cargo;
    public Administrativo(String nombre, long cedula, String cargo) {
        super(nombre, cedula);
        this.cargo = cargo;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String informacion() {
        String texto = "[ADMINISTRATIVO] NOMBRE: " + getNombre() + " \t CEDULA: " + getCedula() + " \t CARGO: " + cargo;
        print(texto);
        return texto;
    }
}