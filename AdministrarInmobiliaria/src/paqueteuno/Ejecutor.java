package paqueteuno;

import java.util.ArrayList;
import java.util.Scanner;
import paquetedos.Propietario;
import paquetetres.Ubicacion;
import paquetecuatro.Ciudad;
import paquetecinco.Constructora;
import paqueteseis.*;
import paquetesiete.*;

/**
 *
 * @author USUARIO
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        int opcion2;
        boolean bandera;
        boolean busqueda;
        String sn;
        String idProp;
        String numeroC;
        String ciudad;
        String idEmp;
        //Muestro el listado para que el usuario pueda ver que nesesita
        do {
            System.out.println(">>>>>>>>>>>>> INGRESAR DATOS <<<<<<<\n"
                    + ">>>1  Ingrese un Propietario\n"
                    + ">>>2  Ingrese una Ubicación\n"
                    + ">>>3  Ingrese una Ciudad\n"
                    + ">>>4  Ingrese una Constructora\n"
                    + ">>>5  Ingrese una Casa\n"
                    + ">>>6  Ingrese un Departamento\n\n"
                            +  ">>>>>>>>>>>>>>> VERIFIQUE DATOS <<<<<<<< \n"
                    + ">>>7  Verifique si está registrado un Propietario\n"
                    + ">>>8  Verifique si está registrada la Ubicacion\n"
                    + ">>>9  Verifique si está registrada La Ciudad\n"
                    + ">>10  Verifique si está registrada una Constructora\n\n"
                            + ">>>>>> VISUALISE LA LISTA CON LOS DATOS<<<<<\n"
                    + ">>11  Desea ver la lista de los Propietarios\n"
                    + ">>12  Desea ver la lista de las Ubicaciones\n"
                    + ">>13  Desea ver la lista de las Ciudades\n"
                    + ">>14  Desea ver la lista de las Constructoras\n"
                    + ">>15  Desea ver la lista de las Casas\n"
                    + ">>16  Desea ver la lista de los Departamentos: ");
            opcion = entrada.nextInt();
            if ((opcion >= 1) && (opcion <= 16)) {
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la identificación del Propietario: ");
                        idProp = entrada.nextLine();
                        ingresarPropietario(idProp);
                        break;

                    case 2:
                        System.out.println("Ingrese el número de Casa: ");
                        numeroC = entrada.nextLine();
                        ingresarUbicacion(numeroC);
                        break;

                    case 3:
                        System.out.println("Ingrese el nombre de la Ciudad: ");
                        ciudad = entrada.nextLine();
                        ingresarCiudad(ciudad);
                        break;

                    case 4:
                        System.out.println("Ingrese el ID de la empresa: ");
                        idEmp = entrada.nextLine();
                        ingresarConstructora(idEmp);
                        break;

                    case 5:
                        ingresarCasa();
                        break;

                    case 6:
                        ingresarDepartamento();
                        break;

                    case 7:
                        System.out.println("Ingresar identificación del "
                                + "propietario a buscar:");
                        sn = entrada.nextLine();
                        busqueda = buscarPropietario(sn);
                        if (busqueda) {
                            System.out.println("Propietario ya reguistrado");
                        } else {
                            System.out.println("Propietario no registrado");
                        }
                        break;

                    case 8:
                        System.out.println("Numero de casa:");
                        sn = entrada.nextLine();
                        busqueda = buscarUbicacion(sn);
                        if (busqueda) {
                            System.out.println("Ubicación registrada.");
                        } else {
                            System.out.println("Ubicación no registrada.");
                        }
                        break;

                    case 9:
                        System.out.println("Nombre de la ciudad:");
                        sn = entrada.nextLine();
                        sn = sn.toLowerCase();
                        busqueda = buscarCiudad(sn);
                        if (busqueda) {
                            System.out.println("Ciudad registrada.");
                        } else {
                            System.out.println("Ciudad no registrada.");
                        }
                        break;

                    case 10:
                        System.out.println("ID de  empresa que busca:");
                        sn = entrada.nextLine();
                        busqueda = buscarConstructora(sn);
                        if (busqueda) {
                            System.out.println("Constructora registrado.");
                        } else {
                            System.out.println("Constructora no registrado.");
                        }
                        break;

                    case 11:
                        Propietarios();
                        break;

                    case 12:
                        Ubicaciones();
                        break;

                    case 13:
                        Ciudades();
                        break;

                    case 14:
                        Constructoras();
                        break;

                    case 15:
                        Casas();
                        break;

                    case 16:
                        Departamentos();
                        break;
                }
                System.out.println("Ingrese el numero 1 si desea realizar una"
                        + " nueva acción.\n"
                        + ">>>>>>Si no desea realizar otra acción<<<< \n"
                        + "Digite cualquier número excepto el 1, por ejemplo"
                        + " el numero 0");
                opcion2 = entrada.nextInt();
                if (opcion2 == 1) {
                    bandera = true;
                } else {
                    bandera = false;
                }
            } else {
                System.out.println("Opción incorrecta, ingrese de nuevo su"
                        + " opción.");
                bandera = true;
            }
        } while (bandera);//falso para salir

    }

    public static void ingresarPropietario(String idProp) {
        Scanner entrada = new Scanner(System.in);
        String nombreProp;
        String apellidoProp;
        String nombreArchivo = "Propietarios.txt";
        boolean bandera = true;
        LeerPropietario lectura = new LeerPropietario(nombreArchivo);
        lectura.establecerListaPropietario();
        ArrayList<Propietario> lista = lectura.obtenerListaPropietario();
        for (int i = 0; i < lista.size(); i++) {
            Propietario p = lista.get(i);
            if (p.obtenerIdentificacion().equals(idProp)) {
                System.out.println("Propietario ya registrado.\n" + p);
                bandera = false;
            }
        }
        if (bandera) {
            System.out.println("Nombre del Propietario: ");
            nombreProp = entrada.nextLine();
            System.out.println("Apellido del Propietario: ");
            apellidoProp = entrada.nextLine();
            Propietario propi = new Propietario(nombreProp, apellidoProp, idProp);
            propietario archivo = new propietario(nombreArchivo);
            archivo.establecerRegistro(propi);
            archivo.establecerSalida();
            archivo.cerrarArchivo();
        }
    }

    public static void ingresarUbicacion(String numeroC) {
        Scanner entrada = new Scanner(System.in);
        String nombreB;
        String referencia;
        String nombreArchivo = "Ubicaciones.txt";
        boolean bandera = true;
        LeerUbicacion lectura = new LeerUbicacion(nombreArchivo);
        lectura.establecerListaUbicacion();
        ArrayList<Ubicacion> lista = lectura.obtenerListaUbicacion();
        for (int i = 0; i < lista.size(); i++) {
            Ubicacion u = lista.get(i);
            if (u.obtenerNumeroCasa().equals(numeroC)) {
                System.out.println("Ubicación ya registrada.\n" + u);
                bandera = false;
            }
        }
        if (bandera) {
            System.out.println("Nombre del barrio: ");
            nombreB = entrada.nextLine();
            System.out.println("Referencias del barrio: ");
            referencia = entrada.nextLine();
            Ubicacion ubi = new Ubicacion(nombreB, referencia, numeroC);
            ubicacion archivo = new ubicacion(nombreArchivo);
            archivo.establecerRegistro(ubi);
            archivo.establecerSalida();
            archivo.cerrarArchivo();
        }
    }

    public static void ingresarCiudad(String ciudad) {
        Scanner entrada = new Scanner(System.in);
        String ci;
        String ci2;
        String provincia;
        String nombreArchivo = "ciudades.txt";
        boolean bandera = true;

        ci = ciudad.toLowerCase();
        LeerCiudad lectura = new LeerCiudad(nombreArchivo);
        lectura.establecerListaCiudad();
        ArrayList<Ciudad> lista = lectura.obtenerListaCiudad();
        for (int i = 0; i < lista.size(); i++) {
            Ciudad c = lista.get(i);
            ci2 = c.obtenerNombreCiudad().toLowerCase();
            if (ci2.equals(ci)) {
                System.out.println("Ciudad ya registrada.\n" + c);
                bandera = false;
            }
        }
        if (bandera) {
            System.out.println("Número de Provincia: ");
            provincia = entrada.nextLine();
            Ciudad ciud = new Ciudad(ciudad, provincia);
            ciudad archivo = new ciudad(nombreArchivo);
            archivo.establecerRegistro(ciud);
            archivo.establecerSalida();
            archivo.cerrarArchivo();
        }
    }

    public static void ingresarConstructora(String idEmp) {
        Scanner entrada = new Scanner(System.in);
        String nombreCons;
        String nombreArchivo = "constructoras.txt";
        boolean bandera = true;
        LeerConstructora lectura = new LeerConstructora(nombreArchivo);
        lectura.establecerListaConstructora();
        ArrayList<Constructora> lista = lectura.obtenerListaConstructora();
        for (int i = 0; i < lista.size(); i++) {
            Constructora c = lista.get(i);
            if (c.getId().equals(idEmp)) {
                System.out.println("Ubicación registrada.\n" + c);
                bandera = false;
            }
        }
        if (bandera) {
            System.out.println("Nombre del Barrio: ");
            nombreCons = entrada.nextLine();
            Constructora cons = new Constructora(nombreCons, idEmp);
            constructora archivo = new constructora(nombreArchivo);
            archivo.establecerRegistro(cons);
            archivo.establecerSalida();
            archivo.cerrarArchivo();
        }
    }

    public static void ingresarCasa() {
        Scanner entrada = new Scanner(System.in);
        String nombreArchivo =  ">>Casas.txt";
        String nombreArchivo1 = ">>Propietarios.txt";
        String nombreArchivo2 = ">>Ubicaciones.txt";
        String nombreArchivo3 = ">>Ciudades.txt";
        String nombreArchivo4 = ">>Constructoras.txt";
        String nombreProp = " ";
        String apellidoProp = " ";
        String idProp;
        double precioM2;
        int numeroM2;
        String nombreB = " ";
        String referencia = " ";
        String numeroCa;
        String ciudad;
        String provincia = " ";
        int nCuartos;
        String nombreEmp = " ";
        String idEmp;
        boolean buscar;
        System.out.println("Identificación del Propietario: ");
        idProp = entrada.nextLine();
        // buscar propietario
        buscar = buscarPropietario(idProp);
        if (buscar) {
        } else {
            ingresarPropietario(idProp);
        }
        LeerPropietario lectura = new LeerPropietario(nombreArchivo1);
        lectura.establecerListaPropietario();
        ArrayList<Propietario> lista = lectura.obtenerListaPropietario();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).obtenerIdentificacion().equals(idProp)) {
                nombreProp = lista.get(i).obtenerNombre();
                apellidoProp = lista.get(i).obtenerApellido();
            }
        }
        Propietario propDef = new Propietario(nombreProp, apellidoProp, idProp);
        System.out.println("Precio por metro cuadrado: ");
        precioM2 = entrada.nextDouble();
        System.out.println("Números de metros cuadrados: ");
        numeroM2 = entrada.nextInt();
        //  Aky  busca la ubicación 
        buscar = false;
        System.out.println("Número de Casa: ");
        numeroCa = entrada.nextLine();
        buscar = buscarUbicacion(numeroCa);
        if (buscar) {
        } else {
            ingresarUbicacion(numeroCa);
        }
        LeerUbicacion lectura2 = new LeerUbicacion(nombreArchivo2);
        lectura2.establecerListaUbicacion();
        ArrayList<Ubicacion> lista2 = lectura2.obtenerListaUbicacion();
        for (int i = 0; i < lista2.size(); i++) {
            if (lista2.get(i).obtenerNumeroCasa().equals(numeroCa)) {
                nombreB = lista2.get(i).obtenerNombreBarrio();
                referencia = lista2.get(i).obtenerReferencia();
            }
        }
        // Aky busca a la ciudad
        Ubicacion ubiDef = new Ubicacion(nombreB, referencia, numeroCa);
        buscar = false;
        System.out.println("Nombre de la ciudad: ");
        ciudad = entrada.nextLine();
        buscar = buscarCiudad(ciudad);
        if (buscar) {
        } else {
            ingresarCiudad(ciudad);
        }
        LeerCiudad lectura3 = new LeerCiudad(nombreArchivo3);
        lectura3.establecerListaCiudad();
        ArrayList<Ciudad> lista3 = lectura3.obtenerListaCiudad();
        for (int i = 0; i < lista3.size(); i++) {
            if (lista3.get(i).obtenerNombreCiudad().equals(ciudad)) {
                provincia = lista3.get(i).obtenerNombreProvincia();
            }
        }
        //Aky va a buscar a la Constructora
        Ciudad ciuDef = new Ciudad(ciudad, provincia);
        System.out.println("Número de cuartos: ");
        nCuartos = entrada.nextInt();
        buscar = false;
        System.out.println("ID de la constructora: ");
        idEmp = entrada.nextLine();
        buscar = buscarConstructora(idEmp);
        if (buscar) {
        } else {
            ingresarConstructora(idEmp);
        }
        LeerConstructora lectura4 = new LeerConstructora(nombreArchivo4);
        lectura4.establecerListaConstructora();
        ArrayList<Constructora> lista4 = lectura4.obtenerListaConstructora();
        for (int i = 0; i < lista4.size(); i++) {
            if (lista4.get(i).getId().equals(idEmp)) {
                nombreEmp = lista4.get(i).getNombre();
            }
        }
        Constructora constDef = new Constructora(nombreEmp, idEmp);
        Casa casa1 = new Casa(propDef, precioM2, numeroM2, ubiDef,
                ciuDef, nCuartos, constDef);
        casa1.establecerCostoFinal();
        casa archivo = new casa(nombreArchivo);
        archivo.establecerRegistro(casa1);
        archivo.establecerSalida();
        archivo.cerrarArchivo();
        
    }

    public static void ingresarDepartamento() {
        Scanner entrada = new Scanner(System.in);
        String nombreArchivo = "Casas.txt";
        String nombreArchivo1 = "Propietarios.txt";
        String nombreArchivo2 = "Ubicaciones.txt";
        String nombreArchivo3 = "Ciudades.txt";
        String nombreArchivo4 = "Constructoras.txt";
        String nombreProp = " ";
        String apellidoProp = " ";
        String idProp;
        double precioM2;
        int numeroM2;
        String nombreB = " ";
        String referencia = " ";
        String numeroCa;
        String ciudad;
        String provincia = " ";
        String nombreEmp = " ";
        String idEmp;
        boolean buscar;
        double alicuotaMensual;
        String nomEdi;
        String ubiDepEdi;
        System.out.println("Identificación del Propietario: ");
        idProp = entrada.nextLine();
        buscar = buscarPropietario(idProp); // Aky me va a buscar al propietario
        if (buscar) {
        } else {
            ingresarPropietario(idProp);
        }
        LeerPropietario lectura = new LeerPropietario(nombreArchivo1);
        lectura.establecerListaPropietario();
        ArrayList<Propietario> lista = lectura.obtenerListaPropietario();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).obtenerIdentificacion().equals(idProp)) {
                nombreProp = lista.get(i).obtenerNombre();
                apellidoProp = lista.get(i).obtenerApellido();
            }
        }
        Propietario propDef = new Propietario(nombreProp, apellidoProp, idProp);
        System.out.println("Precio por metro cuadrado: ");
        precioM2 = entrada.nextDouble();
        System.out.println("Número de metros cuadrados: ");
        numeroM2 = entrada.nextInt();
        System.out.println("Valor de la  alícuota mensual: ");
        alicuotaMensual = entrada.nextDouble();
        System.out.println("Número de Casa: ");
        numeroCa = entrada.nextLine();
        buscar = buscarUbicacion(numeroCa);
        if (buscar) {
        } else {
            ingresarUbicacion(numeroCa);
        }
        LeerUbicacion lectura2 = new LeerUbicacion(nombreArchivo2);
        lectura2.establecerListaUbicacion();
        ArrayList<Ubicacion> lista2 = lectura2.obtenerListaUbicacion();
        for (int i = 0; i < lista2.size(); i++) {
            if (lista2.get(i).obtenerNumeroCasa().equals(numeroCa)) {
                nombreB = lista2.get(i).obtenerNombreBarrio();
                referencia = lista2.get(i).obtenerReferencia();
            }
        }
        Ubicacion ubiDef = new Ubicacion(nombreB, referencia, numeroCa);
        System.out.println("Nombre de la ciudad: ");
        ciudad = entrada.nextLine();
        buscar = buscarCiudad(ciudad);
        if (buscar) {
        } else {
            ingresarCiudad(ciudad);
        }
        LeerCiudad lectura3 = new LeerCiudad(nombreArchivo3);
        lectura3.establecerListaCiudad();
        ArrayList<Ciudad> lista3 = lectura3.obtenerListaCiudad();
        for (int i = 0; i < lista3.size(); i++) {
            if (lista3.get(i).obtenerNombreCiudad().equals(ciudad)) {
                provincia = lista3.get(i).obtenerNombreProvincia();
            }
        }
        Ciudad ciuDef = new Ciudad(ciudad, provincia);
        System.out.println("Nombre del edificio: ");
        nomEdi = entrada.nextLine();
        System.out.println("Ubicacion del departamento: ");
        ubiDepEdi = entrada.nextLine();
        System.out.println("ID de la constructora: ");
        idEmp = entrada.nextLine();
        buscar = buscarConstructora(idEmp);
        if (buscar) {
        } else {
            ingresarConstructora(idEmp);
        }
        LeerConstructora lectura4 = new LeerConstructora(nombreArchivo4);
        lectura4.establecerListaConstructora();
        ArrayList<Constructora> lista4 = lectura4.obtenerListaConstructora();
        for (int i = 0; i < lista4.size(); i++) {
            if (lista4.get(i).getId().equals(idEmp)) {
                nombreEmp = lista4.get(i).getNombre();
            }
        }
        Constructora constDef = new Constructora(nombreEmp, idEmp);
        Departamento dep1 = new Departamento(propDef, precioM2, numeroM2, 
                alicuotaMensual, ubiDef, ciuDef, nomEdi, ubiDepEdi, constDef);
        dep1.establecerCostoFinal();
        departamento archivo = new departamento(nombreArchivo);
        archivo.establecerRegistro(dep1);
        archivo.establecerSalida();
        archivo.cerrarArchivo();
    }

    public static boolean buscarPropietario(String n) {
        boolean buscar = false;
        String nombreArchivo = "Propietarios.txt";
        LeerPropietario lectura = new LeerPropietario(nombreArchivo);
        lectura.establecerListaPropietario();
        ArrayList<Propietario> lista = lectura.obtenerListaPropietario();
        for (int i = 0; i < lista.size(); i++) {
            Propietario p = lista.get(i);
            if (p.obtenerIdentificacion().equals(n)) {
                buscar = true;
            }
        }
        return buscar;
    }

    public static boolean buscarUbicacion(String n) {
        boolean buscar = false;
        String nombreArchivo = "ubicaciones.txt";
        LeerUbicacion lectura = new LeerUbicacion(nombreArchivo);
        lectura.establecerListaUbicacion();
        ArrayList<Ubicacion> lista = lectura.obtenerListaUbicacion();
        for (int i = 0; i < lista.size(); i++) {
            Ubicacion u = lista.get(i);
            if (u.obtenerNumeroCasa().equals(n)) {
                buscar = true;
                // System.out.println(p);
            }
        }
        return buscar;
    }

    public static boolean buscarCiudad(String n) {
        boolean buscar = false;
        n = n.toLowerCase();
        String m;
        String nombreArchivo = "ciudades.txt";
        LeerCiudad lectura = new LeerCiudad(nombreArchivo);
        lectura.establecerListaCiudad();
        ArrayList<Ciudad> lista = lectura.obtenerListaCiudad();
        for (int i = 0; i < lista.size(); i++) {
            Ciudad c = lista.get(i);
            m = c.obtenerNombreCiudad().toLowerCase();
            if (m.equals(n)) {
                buscar = true;
                 System.out.println();
            }
        }
        return buscar;
    }

    public static boolean buscarConstructora(String n) {
        boolean buscar = false;
        String nombreArchivo = "Constructoras.txt";
        LeerConstructora lectura = new LeerConstructora(nombreArchivo);
        lectura.establecerListaConstructora();
        ArrayList<Constructora> lista = lectura.obtenerListaConstructora();
        for (int i = 0; i < lista.size(); i++) {
            Constructora c = lista.get(i);
            if (c.getNombre().equals(n)) {
                buscar = true;
            }
        }
        return buscar;
    }

    public static void Propietarios() {
        String nombreArchivo = "Propietarios.txt";
        LeerPropietario lectura = new LeerPropietario(nombreArchivo);
        lectura.establecerListaPropietario();
        System.out.println(lectura);
    }

    public static void Ubicaciones() {
        String nombreArchivo = "Ubicaciones.txt";
        LeerUbicacion lectura = new LeerUbicacion(nombreArchivo);
        lectura.establecerListaUbicacion();
        System.out.println(lectura);
    }

    public static void Ciudades() {
        String nombreArchivo = "Ciudades.txt";
        LeerCiudad lectura = new LeerCiudad(nombreArchivo);
        lectura.establecerListaCiudad();
        System.out.println(lectura);
    }

    public static void Constructoras() {
        String nombreArchivo = "Constructoras.txt";
        LeerConstructora lectura = new LeerConstructora(nombreArchivo);
        lectura.establecerListaConstructora();
        System.out.println(lectura);
    }
    

    public static void Casas() {
        String nombreArchivo = "Casas.txt";
        casa lectura = new casa(nombreArchivo);
        lectura.establecerLista();
        System.out.println(lectura);
    }

    public static void Departamentos() {
        String nombreArchivo = "Departamentos.txt";
        LeerDepartamento lectura = new LeerDepartamento(nombreArchivo);
        lectura.establecerListaDepartamento();
        System.out.println(lectura);
    }

}