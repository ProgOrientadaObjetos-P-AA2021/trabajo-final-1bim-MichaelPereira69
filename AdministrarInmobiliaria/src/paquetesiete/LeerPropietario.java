
package paquetesiete;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquetedos.Propietario;

/**
 *
 * @author USUARIO
 */

public class LeerPropietario {

    private ObjectInputStream entrada;
    private String nombreArchivo;
        private ArrayList<Propietario> listaPropietario;


    public LeerPropietario(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try 
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } 
            catch (IOException ioException) {
                System.err.println("No se puede habrir el archivo.");

            } 
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaPropietario() {
        // 
        listaPropietario = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    listaPropietario.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {               
                    break;
                }
            }
        }

    }

    public ArrayList<Propietario> obtenerListaPropietario() {
        return listaPropietario;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = ">>>>>>>>>>> Lista de los propietarios <<<<<<<<\n\n";
        for (int i = 0; i < obtenerListaPropietario().size(); i++) {
            Propietario p = obtenerListaPropietario().get(i);
            cadena = String.format("%sPropietario %d:\n "
                    + ">>>Nombre: %s\n"
                    + ">>>Apellido: %s\n "
                    + ">>>Identificación: %s\n\n",
                    cadena, i + 1,
                    p.obtenerNombre(),
                    p.obtenerApellido(),
                    p.obtenerIdentificacion());
        }
        return cadena;
    }
    public void cerrarArchivo() {
        try 
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        }
        catch (IOException ioException) {
            System.err.println("No se puedo cerrar el archivo.");
            System.exit(1);
        } 
    } 

}