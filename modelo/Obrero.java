package modelo;
public class Obrero extends Persona {
    protected String codigo;

    public Obrero(String nombre, long cedula, String codigo) {
        super(nombre, cedula);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public String informacion() {
        String texto = "[OBRERO] NOMBRE: " + getNombre() + " \t CEDULA: " + getCedula() + " \t CODIGO: " + codigo;
        print(texto);
        return texto;
    }
}