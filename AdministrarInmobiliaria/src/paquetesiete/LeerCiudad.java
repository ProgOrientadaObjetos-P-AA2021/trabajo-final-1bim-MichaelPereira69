
package paquetesiete;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquetecuatro.Ciudad;

/**
 *
 * @author USUARIO
 */
public class LeerCiudad {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> listaCiudad;
    private String nombreArchivo;

    public LeerCiudad(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try 
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } 
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaCiudad() {
        // 
        listaCiudad = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    listaCiudad.add(registro);
                } catch (EOFException endOfFileException) {
                    return; 
                } catch (IOException ex) {
                    System.err.println("No se puede leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se puede crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public ArrayList<Ciudad> obtenerListaCiudad() {
        return listaCiudad;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = ">>>>>>>Lista de ciudades<<<<<<\n\n";
        for (int i = 0; i < obtenerListaCiudad().size(); i++) {
            Ciudad c = obtenerListaCiudad().get(i);
            cadena = String.format("%s>>Ciudad %d:\n"
                    + " >>Nombre de la ciudad: %s\n"
                    + " >>Nombre de la provincia: %s\n\n",
                    cadena, i + 1,
                    c.obtenerNombreCiudad(),
                    c.obtenerNombreProvincia());
        }
        return cadena;
    }
    //Aky terminaria cerrando el archivo 
      public void cerrarArchivo() {
       // con el try cerraria el archivo 
          try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } 
        catch (IOException ioException) {
            System.err.println("No se pudo cerrar el archivo.");
            System.exit(1);
        } 
      } 
}