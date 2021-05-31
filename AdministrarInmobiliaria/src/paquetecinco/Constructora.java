
package paquetecinco;

/**
 *
 * @author USUARIO
 */
public class Constructora{

    private String identificacion;
    private String nombre;

    public Constructora(String id, String nombre) {
        this.identificacion = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return identificacion;
    }

    public void setId(String id) {
        this.identificacion = id;
    }

    @Override
    public String toString() {
        return identificacion + "\n" + nombre;
    }

}