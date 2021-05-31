
package paquetesiete;

import java.io.FileOutputStream;

import paqueteseis.Casa;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public class casa {
    // envía los datos a un archivo
   private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Casa registro;
    private ArrayList<Casa> lista;

    public casa(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerLista(); 
        // Obtenemos los valores de >objetos< que tiene el archivo.
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // Aky permite ingresar nuevamente los datos del archivo
            if (obtenerLista().size() > 0) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        } 
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } 
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    //Le agrego los registros al archivo
    public void establecerRegistro(Casa c) {
        registro = c;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    //Obtenemos los registros del archio del atributo de listaProfesores 
    public void establecerLista() {
        Leercasa c = new Leercasa(obtenerNombreArchivo());
        c.establecerListaCasa();
        lista = c.obtenerListaCasa();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Casa> obtenerLista() {
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
            System.err.println("Error al cerrar el archivo.");

        } 
    }

}
