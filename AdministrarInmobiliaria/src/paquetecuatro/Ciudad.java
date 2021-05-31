
package paquetecuatro;

/**
 *
 * @author USUARIO
 */
public class Ciudad {

    private String nombreCiudad;
    private String nombreProvincia;

    public Ciudad(String ciudad, String provincia) {
        nombreCiudad = ciudad;
        nombreProvincia = provincia;
    }

    public void establecerNombreCiudad(String c) {
        nombreCiudad = c;
    }

    public void establecerNOmbreProvincia(String p) {
        nombreProvincia = p;
    }

    public String obtenerNombreCiudad() {
        return nombreCiudad;
    }

    public String obtenerNombreProvincia() {
        return nombreProvincia;
    }
    
    @Override
    public String toString() {
        String cadena = String.format(">>>>>Ciudad<<<<<<\n"
                + "Nombre de la ciudad: %s\n"
                + "Nombre de la provincia: %s\n",
                obtenerNombreCiudad(),
                obtenerNombreProvincia());
        return cadena;
    }

}