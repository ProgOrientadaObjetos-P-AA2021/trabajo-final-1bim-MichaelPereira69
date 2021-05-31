
package paquetesiete;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paqueteseis.Casa;

/**
 *
 * @author USUARIO
 */
public class Leercasa {

    private ObjectInputStream entrada;
    private ArrayList<Casa> listaCasa;
    private String nombreArchivo;

    public Leercasa(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try 
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } 
            catch (IOException ioException) {
                System.err.println("No se puede abrir el archivo.");

            } 
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaCasa() {
        // 
        listaCasa = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    listaCasa.add(registro);
                } catch (EOFException endOfFileException) {
                    return;
                    //Aky seria el fin del arrchivo 

                } catch (IOException ex) {
                    System.err.println("No se puede leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public ArrayList<Casa> obtenerListaCasa() {
        return listaCasa;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "LISTA DE CASAS\n\n";
        for (int i = 0; i < obtenerListaCasa().size(); i++) {
            Casa c = obtenerListaCasa().get(i);
            cadena = String.format("%sCasa %d:\n"
                    + ">>>Propietario: %s %s\n"
                    + ">>>Identificación: %s\n"
                    + ">>>Precio por metro cuadrado: %.2f\n"
                    + ">>>Número de metros Cuadrado: %d\n"
                    + ">>>Costo final: %.2f\n"
                    + ">>>Ubicacion:\n"
                    + ">>>Barrio: %s\n"
                    + ">>>Referencia: %s\n"
                    + ">>>Numero de casa: %s\n"
                    + ">>>Ciudad: %s\nProvincia: %s\n"
                    + ">>>Número de cuartos: %d\n"
                    + ">>>Información de la constructora:\n"
                    + ">>>Nombre: %s\n "
                    + ">>>ID de la empresa: %s\n",
                    cadena, i + 1,
                    c.obtenerPersonaPropietaria().obtenerNombre(),
                    c.obtenerPersonaPropietaria().obtenerApellido(),
                    c.obtenerPersonaPropietaria().obtenerIdentificacion(),
                    c.obtenerPrecioMetro2(), c.obtenerNumeroMetro2(),
                    c.obtenerCostoFinal(),
                    c.obtenerUbicacionCasa().obtenerNombreBarrio(),
                    c.obtenerUbicacionCasa().obtenerReferencia(),
                    c.obtenerUbicacionCasa().obtenerNumeroCasa(),
                    c.obtenerCiudadCasa().obtenerNombreCiudad(),
                    c.obtenerCiudadCasa().obtenerNombreProvincia(),
                    c.obtenerNumeroCuartos());
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
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } 
    }
    

}
