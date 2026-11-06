package modelo;
public class Tecnico extends Obrero {
    private String claveAcceso;
    public Tecnico(String nombre, long cedula, String codigo, String claveAcceso) {
        super(nombre, cedula, codigo);
        this.claveAcceso = claveAcceso;
    }
    public String getClaveAcceso() {
        return claveAcceso;
    }
    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }
    public String informacion() {
        String texto = "[TECNICO] NOMBRE: " + getNombre() + " \t CEDULA: " + getCedula() + " \t CODIGO: " + codigo + " \t CLAVE: " + claveAcceso;
        print(texto);
        return texto;
    }
}