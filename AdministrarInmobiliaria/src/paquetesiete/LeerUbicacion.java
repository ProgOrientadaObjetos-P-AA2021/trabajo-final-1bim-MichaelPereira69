
package paquetesiete;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquetetres.Ubicacion;

/**
 *
 * @author USUARIO
 */
public class LeerUbicacion {

    private ObjectInputStream entrada;
    private ArrayList<Ubicacion> listaUbicacion;
    private String nombreArchivo;

    public LeerUbicacion(String n) {
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

    public void establecerListaUbicacion() {
        
        listaUbicacion = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ubicacion registro = (Ubicacion) entrada.readObject();
                    listaUbicacion.add(registro);
                } catch (EOFException endOfFileException) {
                    return; 

                } catch (IOException ex) {
                    System.err.println("No se puede leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se puede crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No existen datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }

    public ArrayList<Ubicacion> obtenerListaUbicacion() {
        return listaUbicacion;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = ">>>>>>>> Lista de las Urbanizaciones \n\n";
        for (int i = 0; i < obtenerListaUbicacion().size(); i++) {
            Ubicacion u = obtenerListaUbicacion().get(i);
            cadena = String.format("%sUbicación %d:\n"
                    + "Barrio: %s\n"
                    + "Referencias: %s\n "
                    + "Número de Casa: %s\n",
                    cadena, i + 1,
                    u.obtenerNombreBarrio(),
                    u.obtenerReferencia(),
                    u.obtenerNumeroCasa());
        }
        return cadena;
    }
    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("No se pudo cerrar el archivo.");
            System.exit(1);
        }
    }
    
}