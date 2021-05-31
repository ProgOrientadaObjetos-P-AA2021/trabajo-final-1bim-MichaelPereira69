
package paquetesiete;

import java.io.FileOutputStream;
import java.io.IOException;

import paquetetres.Ubicacion;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ubicacion {
    
  
    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Ubicacion registro;
    private ArrayList<Ubicacion> lista;

    public ubicacion(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerLista(); 
        try 
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (obtenerLista().size() > 0) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        } 
        catch (IOException ioException) {
            System.err.println("No se puede aabrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistro(Ubicacion u) {
        registro = u;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); 
        } catch (IOException ex) {
            System.err.println("No se puede escribir en el archivo.");
        }
    }
    public void establecerLista() {
        LeerUbicacion u = new LeerUbicacion(obtenerNombreArchivo());
        u.establecerListaUbicacion();
        lista = u.obtenerListaUbicacion();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Ubicacion> obtenerLista() {
        return lista;
    }

    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try 
        {
            if (salida != null) {
                salida.close();
            }
        }
        catch (IOException ioException) {
            System.err.println("No se puede cerrar el archivo.");

        }
    }

}
