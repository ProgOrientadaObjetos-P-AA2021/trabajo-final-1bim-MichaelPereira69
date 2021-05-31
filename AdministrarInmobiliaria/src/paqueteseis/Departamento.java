
package paqueteseis;

import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

/**
 *
 * @author USUARIO
 */
public class Departamento {

    private Propietario personaPropietaria;
    private double precioMetro2;
    private int numeroMetro2;
    private double alicuotaMensual;
    private double costoFinal;
    private Ubicacion ubicacionDepartamento;
    private Ciudad ciudadDepartamento;
    private String nombreEdificio;
    private String ubicacionDepartamentoEdificio;
    private Constructora empresaConstructora;

    public Departamento(Propietario persona, double precioM2, int numM2,
            double alicuota, Ubicacion ubiDep, Ciudad ciuDep, String nombreEd,
            String ubiDepEdi, Constructora empresa) {
        personaPropietaria = persona;
        precioMetro2 = precioM2;
        numeroMetro2 = numM2;
        alicuotaMensual = alicuota;
        ubicacionDepartamento = ubiDep;
        ciudadDepartamento = ciuDep;
        nombreEdificio = nombreEd;
        ubicacionDepartamentoEdificio = ubiDepEdi;
        empresaConstructora = empresa;
    }

    public void establecerPersonaPropietaria(Propietario prop) {
        personaPropietaria = prop;
    }

    public void establecerPrecioMetro2(double precio) {
        precioMetro2 = precio;
    }

    public void establecerNumeroMetro2(int numero) {
        numeroMetro2 = numero;
    }

    public void establecerAlicuotaMensual(double alicuota) {
        alicuotaMensual = alicuota;
    }

    public void establecerCostoFinal() {
        costoFinal = (numeroMetro2 * precioMetro2) + (alicuotaMensual * 12);
    }

    public void establecerUbicacionDepartamento(Ubicacion ubiDep) {
        ubicacionDepartamento = ubiDep;
    }

    public void establecerCiudadDepartamento(Ciudad ciuDep) {
        ciudadDepartamento = ciuDep;
    }

    public void establecerNombreEdificio(String nombreEd) {
        nombreEdificio = nombreEd;
    }

    public void establecerUbicacionDepartamentoEdificio(String ubiEdi) {
        ubicacionDepartamentoEdificio = ubiEdi;
    }

    public void establecerEmpresaConstructora(Constructora emp) {
        empresaConstructora = emp;
    }

    public Propietario obtenerPersonaPropietaria() {
        return personaPropietaria;
    }

    public double obtenerPrecioMetro2() {
        return precioMetro2;
    }

    public int obtenerNumeroMetro2() {
        return numeroMetro2;
    }

    public double obtenerAlicuotaMensual() {
        return alicuotaMensual;
    }

    public double obtenerCostoFinal() {
        return costoFinal;
    }

    public Ubicacion obtenerUbicacionDepartamento() {
        return ubicacionDepartamento;
    }

    public Ciudad obtenerCiudadDepartamento() {
        return ciudadDepartamento;
    }

    public String obtenerNombreEdificio() {
        return nombreEdificio;
    }

    public String obtenerUbicacionDepartamentoEdificio() {
        return ubicacionDepartamentoEdificio;
    }

    public Constructora obtenerEmpresaConstructora() {
        return empresaConstructora;
    }

    @Override
    public String toString() {
        String cadena = String.format(">>>>Departamento<<<<<\n"
                + "Propietario: %s %s\n"
                + "Identificación: %s\n"
                + "Precio por metro2: %.2f\n"
                + "Número de metros2: %d\n"
                + "Valor de la alicuóta mensual: %.2f\n"
                + "Costo final: %.2f\n"
                + "Ubicacion: \n "
                + "Barrio: %s\n "
                + "Referencia: %s\n"
                + "Numero de casa: %s\n"
                + "Ciudad: %s\n"
                + "Provincia: %s\n"
                + "Nombre de edificio: %s\n"
                + "Ubicación del edificio: %s\n"
                + "Información de constructora:"
                + "Nombre: %s\n"
                + "Id de  empresa: %s\n\n",
                obtenerPersonaPropietaria().obtenerNombre(),
                obtenerPersonaPropietaria().obtenerApellido(),
                obtenerPersonaPropietaria().obtenerIdentificacion(),
                obtenerPrecioMetro2(), obtenerNumeroMetro2(),
                obtenerAlicuotaMensual(), obtenerCostoFinal(),
                obtenerUbicacionDepartamento().obtenerNombreBarrio(),
                obtenerUbicacionDepartamento().obtenerReferencia(),
                obtenerUbicacionDepartamento().obtenerNumeroCasa(),
                obtenerCiudadDepartamento().obtenerNombreCiudad(),
                obtenerCiudadDepartamento().obtenerNombreProvincia(),
                obtenerNombreEdificio(),
                obtenerUbicacionDepartamentoEdificio());
        return cadena;
    }

}