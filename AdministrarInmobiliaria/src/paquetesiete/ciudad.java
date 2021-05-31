
package paquetesiete;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.io.FileOutputStream;
import paquetecuatro.Ciudad;
/**
 *
 * @author USUARIO
 */
public class ciudad {
    
  private String nombreArchivo;
  //Se envia los datos al archivo o barriables
    private ObjectOutputStream salida; 
    private Ciudad registro;
    private ArrayList<Ciudad> lista;

    public ciudad(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerLista(); 
// Se obtiene los valores de >objetos< que se encuantran en el archivo
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            //Aky se hace el  proceso para enviar nuevamente los valores del archivo
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

    // Aky le agremas mas registros al archivo creado
    public void establecerRegistro(Ciudad c) {
        registro = c;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    // Aky Obtenemos los registros del archivo en el atributo denominada listaProfesores 
    public void establecerLista() {
        LeerCiudad c = new LeerCiudad(obtenerNombreArchivo());
        c.establecerListaCiudad();
        lista = c.obtenerListaCiudad();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Ciudad> obtenerLista() {
        return lista;
    }

    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try{
            if (salida != null) {
                salida.close();
            }
        }
        catch (IOException ioException) {
            System.err.println("El archivo no se puede serrar.");

        }
    }

}
