
package paquetesiete;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquetecinco.Constructora;

/**
 *
 * @author USUARIO
 */
public class LeerConstructora {

    private ObjectInputStream entrada;
    private ArrayList<Constructora> listaCiudad;
    private String nombreArchivo;

    public LeerConstructora(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try 
            { 
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } 
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.\n");

            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaConstructora() {
        // 
        listaCiudad = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    listaCiudad.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("No se puede leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se puede crear este objeto: " + ex);
                } catch (Exception ex) {
                    
                    
                 System.err.println("No Existen datos en este archivo: " + ex);
                    break;
                }
            }
        }

    }

    public ArrayList<Constructora> obtenerListaConstructora() {
        return listaCiudad;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = ">>>>>>> Lista de la Constructora <<<<<\n";
        for (int i = 0; i < obtenerListaConstructora().size(); i++) {
            Constructora c = obtenerListaConstructora().get(i);
            cadena = String.format("%sLa constructora %d :\n "
                    + "Con el Nombre: %s\n"
                    + "Id de Empresa: %s\n\n",
                    cadena, i + 1,
                    c.getNombre(),
                    c.getId());
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
        } catch (IOException ioException) {
            System.err.println("No se puede cerrar el archivo.");
            System.exit(1);
        } 
    }
}