
package paquetesiete;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paqueteseis.Departamento;

/**
 *
 * @author USUARIO
 */
public class LeerDepartamento {

    private ObjectInputStream entrada;
    private ArrayList<Departamento> listaDepartamento;
    private String nombreArchivo;

    public LeerDepartamento(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            }
            catch (IOException ioException) {
                System.err.println("No se pudo abrir el archivo.");

            } 
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaDepartamento() {
        // 
        listaDepartamento = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    listaDepartamento.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("No se pudo leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se puede crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public ArrayList<Departamento> obtenerListaDepartamento() {
        return listaDepartamento;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = ">>>>>>>>>>> Lista de los departamentos <<<<<<<<\n\n";
        for (int i = 0; i < obtenerListaDepartamento().size(); i++) {
            Departamento d = obtenerListaDepartamento().get(i);
            cadena = String.format("%sDepartamento %d:\n"
                    + ">>Propietario: %s %s\n"
                    + ">>Identificación: %s\n"
                    + ">>Precio por metro2: %.2f\n"
                    + ">>Número de metros2: %d\n"
                    + ">>Valor de la alicuóta mensual: %.2f\n"
                    + ">>Costo final: %.2f\n"
                    + ">>Ubicacion:\n"
                    + ">>Barrio: %s\n "
                    + ">>Referencia: %s\n"
                    + ">>Numero de casa: %s\n"
                    + ">>Ciudad: %s\n"
                    + ">>Provincia: %s\n"
                    + ">>Nombre del edificio: %s\n"
                    + ">>Ubicación del edificio: %s\n"
                    + ">>Información de la constructora\n"
                    + ">>Nombre: %s\n "
                    + ">>ID de la empresa: %s\n",
                    cadena, i + 1,
                    d.obtenerPersonaPropietaria().obtenerNombre(),
                    d.obtenerPersonaPropietaria().obtenerApellido(),
                    d.obtenerPersonaPropietaria().obtenerIdentificacion(),
                    d.obtenerPrecioMetro2(), d.obtenerNumeroMetro2(),
                    d.obtenerAlicuotaMensual(), d.obtenerCostoFinal(),
                    d.obtenerUbicacionDepartamento().obtenerNombreBarrio(),
                    d.obtenerUbicacionDepartamento().obtenerReferencia(),
                    d.obtenerUbicacionDepartamento().obtenerNumeroCasa(),
                    d.obtenerCiudadDepartamento().obtenerNombreCiudad(),
                    d.obtenerCiudadDepartamento().obtenerNombreProvincia(),
                    d.obtenerNombreEdificio(),
                    d.obtenerUbicacionDepartamentoEdificio());
        }
        return cadena;
    }
    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        }
        catch (IOException ioException) {
            System.err.println("No se puede cerrar el archivo.");
            System.exit(1);
        }
    }
    
}
