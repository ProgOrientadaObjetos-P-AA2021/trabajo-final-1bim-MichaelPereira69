package paquetedos;

/**
 *
 * @author USUARIO
 */
public class Propietario {

    private String nombre;
    private String apellido;
    private String identificacion;

    public Propietario(String name, String lastName, String id) {
        nombre = name;
        apellido = lastName;
        identificacion = id;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public void establecerApellido(String a) {
        apellido = a;
    }

    public void establecerIdentificacion(String id) {
        identificacion = id;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }

    @Override
    public String toString() {
        String cadena = String.format(">>>>>Propietario<<<<<<\n"
                + "Nombre: %s\n"
                + "Apellido: %s\n"
                + "Identificación: %s\n",
                obtenerNombre(),
                obtenerApellido(),
                obtenerIdentificacion());
        return cadena;
    }

}