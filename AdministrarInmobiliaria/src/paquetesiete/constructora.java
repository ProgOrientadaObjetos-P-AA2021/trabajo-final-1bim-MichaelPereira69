
package paquetesiete;

import java.io.FileOutputStream;
import paquetecinco.Constructora;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public class constructora {
    // envía los datos a un archivo
    private String nombreArchivo;
    private ObjectOutputStream salida; private Constructora registro;
    private ArrayList<Constructora> lista;

    public constructora(String nombreArc) {
  
        nombreArchivo = nombreArc;
        // obtiene   los valores que tiene el archivo.
        establecerLista();      
        try 
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // Aky puedo ingresar nuevamente los valores al archivo
            if (obtenerLista().size() > 0) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        } 
        catch (IOException ioException) {
            System.err.println("No se puede abrir el archivo.");
        } }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistro(Constructora c) {
        registro = c;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.err.println("Error al escribir archivo.");
        }
    }
    public void establecerLista() {
        LeerConstructora c = new LeerConstructora(obtenerNombreArchivo());
        c.establecerListaConstructora();
        lista = c.obtenerListaConstructora();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Constructora> obtenerLista() {
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

