
package paquetesiete;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquetedos.Propietario;
/**
 *
 * @author USUARIO
 */
public class propietario {
    
   private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Propietario registro;
    private ArrayList<Propietario> lista;

    public propietario(String nombreArc) {
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
            System.err.println("No se puede abrir el archivo.");
        } 
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    public void establecerRegistro(Propietario p) {
        registro = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); 
        } catch (IOException ex) {
            System.err.println("No se uede escribir en el archivo.");
        }
    }
    public void establecerLista() {
        LeerPropietario p = new LeerPropietario(obtenerNombreArchivo());
        p.establecerListaPropietario();
        lista = p.obtenerListaPropietario();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Propietario> obtenerLista() {
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
