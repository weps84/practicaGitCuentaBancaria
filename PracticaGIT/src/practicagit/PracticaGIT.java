/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicagit;

import clases.Cliente;
import clases.TipoCuenta;
import clases.TipoOperacion;
import utilidad.*;

/**
 *
 * @author Weps
 */
public class PracticaGIT {

    static TipoCuenta[] tipcuenta;
    static int cont_tipc;
    static TipoOperacion[] tipope;
    static int cont_tipope;
    static Cliente[] ClienteNuevo;
    static int contadorCliente;
    static long idClienteIncrementado;
    static long idCuentaIncrementado;
    static long idOperacionIncrementado;

    public static Cliente[] ampliarArregloCliente(Cliente arreglo[], int extra) {
        Cliente nuevo[] = new Cliente[arreglo.length + extra];
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                nuevo[i] = arreglo[i];
            }
        }
        return nuevo;
    }

    public static TipoOperacion[] ampliarArregloTipoOperacion(TipoOperacion arreglo[], int extra) {
        TipoOperacion nuevo[] = new TipoOperacion[arreglo.length + extra];
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                nuevo[i] = arreglo[i];
            }
        }
        return nuevo;
    }

    public static TipoCuenta[] ampliarArregloTipoCuenta(TipoCuenta arreglo[], int extra) {
        TipoCuenta nuevo[] = new TipoCuenta[arreglo.length + extra];
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                nuevo[i] = arreglo[i];
            }
        }
        return nuevo;
    }

    public static void insertarTipoCuenta() {
        long idTipCuen;
        int band = 0;
        System.out.println("INGRESE EL IDENTIFICADOR UNICO DEL TIPO DE CUENTA: ");
        idTipCuen = Utilidad.leer_Long();
        for (int i = 0; i < cont_tipc && band == 0; i++) {
            //System.out.println(" entre ");
            if (tipcuenta[i].getId() == idTipCuen) {
                band = 1;
            }
        }
        if (band == 0) {
            if (cont_tipc >= tipcuenta.length) {
                tipcuenta = ampliarArregloTipoCuenta(tipcuenta, 10);
                //System.out.println("entre");
            }
            //System.out.println(" entre "+cont_tipc);
            tipcuenta[cont_tipc] = new TipoCuenta();
            tipcuenta[cont_tipc].addTipoCuenta(idTipCuen);
            cont_tipc++;
        } else {
            System.out.println("LO SIENTO DEBE DE RECTIFICAR EL IDENTIFICADOR UNICO DEL TIPO DE CUENTA YA QUE EL INGRESADO SE ENCUENTRA REGISTRADO ANTERIORMENTE");
        }
    }

    public static void insertarTipoOperaciones() {
        long idTipOpe;
        int band = 0;
        System.out.println("INGRESE EL IDENTIFICADOR UNICO DEL TIPO DE OPERACIÓN: ");
        idTipOpe = Utilidad.leer_Long();
        for (int i = 0; i < cont_tipope && band == 0; i++) {
            if (tipope[i].getId() == idTipOpe) {
                band = 1;
            }
        }
        if (band == 0) {
            if (cont_tipope >= tipope.length) {
                tipope = ampliarArregloTipoOperacion(tipope, 10);
                //System.out.println("entre");
            }
            tipope[cont_tipope] = new TipoOperacion();
            tipope[cont_tipope].addTipoOperacion(idTipOpe);
            cont_tipope++;
        } else {
            System.out.println("LO SIENTO DEBE DE RECTIFICAR EL IDENTIFICADOR UNICO DEL TIPO DE OPERACIÓN YA QUE EL INGRESADO SE ENCUENTRA REGISTRADO ANTERIORMENTE");
        }
    }

    public static void insertarCliente() {
        String cedula;
        System.out.println("--- MODULO PARA REGISTRAR CLIENTES ---");
        System.out.println("INGRESE EL NUMERO DE CEDULA DEL CLIENTE: ");
        cedula = Utilidad.leer_String();
        int swEncontrado = 0;
        //VALIDAR SI LA CEDULA EXISTE
        for (int i = 0; i < contadorCliente && swEncontrado == 0; i++) {
            //if (ArregloDatos[i]!=null){
            //if (ClienteNuevo[i]!=null){
            if (ClienteNuevo[i].getCedulaCliente().equals(cedula)) {
                swEncontrado = 1;
            }
            //}
        }
        if (swEncontrado == 1) {
            System.out.println("La cedula que esta intentando ingresar ya existe en nuestra base de datos");
        } else {
            if (contadorCliente >= ClienteNuevo.length) {
                ClienteNuevo = ampliarArregloCliente(ClienteNuevo, 10);
                //System.out.println("entre");
            }
            idClienteIncrementado++;
            ClienteNuevo[contadorCliente] = new Cliente();
            ClienteNuevo[contadorCliente].createCliente(cedula, idClienteIncrementado);
            contadorCliente++;
            System.out.println("/// DATOS INGRESADOS CON EXITO ///");
        }

    }

    public static void insertarCuentaBancaria() {
        if (contadorCliente == 0) {
            System.out.println("No existen clientes registrados....");
            return;
        }
        if (cont_tipc == 0) {
            System.out.println("No existen tipos de cuentas registrado.....");
            return;
        }
        System.out.println("/*********NUEVA CUENTA BANCARIA**********/");
        reporte_3();
        System.out.println("Cedula del Cliente: ");
        String cedula = Utilidad.leer_String();
        boolean enc = false;
        int pos = -1;
        for (int i = 0; i < contadorCliente && !enc; i++) {
            if (cedula.compareTo(ClienteNuevo[i].getCedulaCliente()) == 0) {
                enc = true;
                pos = i;
            }
        }
        if (!enc) {
            System.out.println("Cedula no registrada.........");
            return;
        }
        reporte_6();
        System.out.println("Id Tipo de Cuenta: ");
        enc = false;
        long id = Utilidad.leer_Long();
        int posTC = -1;
        for (int i = 0; i < cont_tipc && !enc; i++) {
            if (tipcuenta[i].getId() == id) {
                enc = true;
                posTC = i;
            }
        }
        if (!enc) {
            System.out.println("Este tipo de cuenta no esta registrada....");
            return;
        }
        idCuentaIncrementado++;
        ClienteNuevo[pos].NuevaCuentaBancaria(tipcuenta[posTC], idCuentaIncrementado);
    }

    public static void insertarOperacionBancaria() {
        if (cont_tipope == 0) {
            System.out.println("No hay tipo de operaciones registradas....");
            return;
        }
        if (contadorCliente == 0) {
            System.out.println("No hay Clientes registrados....");
            return;
        }
        System.out.println("/*********NUEVA OPERACION BANCARIA**********/");
        reporte_3();
        System.out.println("Cedula del Cliente: ");
        String cedula = Utilidad.leer_String();
        boolean enc = false;
        int pos = -1;
        for (int i = 0; i < contadorCliente && !enc; i++) {
            if (cedula.compareTo(ClienteNuevo[i].getCedulaCliente()) == 0) {
                enc = true;
                pos = i;
            }
        }
        if (!enc) {
            System.out.println("Cedula no registrada.........");
            return;
        }
        if (ClienteNuevo[pos].getContadorCuentas() == 0) {
            System.out.println("El cliente " + ClienteNuevo[pos].getNombresCLiente() + " no tiene cuentas asociadas....");
            return;
        }
        reporte_5();
        System.out.println("ID Tipo de Operacion: ");
        int id = Utilidad.leer_Int();
        enc = false;
        int posTO = -1;
        for (int i = 0; i < cont_tipope && !enc; i++) {
            if (tipope[i].getId() == id) {
                enc = true;
                posTO = i;
            }
        }
        if (!enc) {
            System.out.println("Tipo de operacion no registrada.....");
            return;
        }
        idOperacionIncrementado++;
        ClienteNuevo[pos].nuevaOperacionBancaria(tipope[posTO], idOperacionIncrementado);

    }

    public static void reporte_1() {
        System.out.println("Busqueda Por Cedula:");
        String cedulaBuscar = "";
        reporte_3();
        System.out.println("CEDULA A CONSULTAR: ");
        cedulaBuscar = Utilidad.leer_String();
        boolean sw = false;
        
        for(int i=0; i<contadorCliente && !sw; i++){
            if (ClienteNuevo[i].getCedulaCliente().compareTo(cedulaBuscar)==0){
                sw = false;
                System.out.println("ID\tNUMERO DE CUENTA\tDESCRIPCION\tMONTO DISPONIBLE");
                ClienteNuevo[i].mostrarCuentas();
                     
            }
        }
        if(!sw){
            System.out.println("CLIENTE NO REGISTRADO!!!!!");
        }
    }

    public static void reporte_2() {
        System.out.println("Busqueda de Cuenta por ID");
        System.out.println("ID\tNumero\tDescripcion\tMonto Actual");
        for (int i=0; i<contadorCliente; i++){
            ClienteNuevo[i].mostrarCuentas();
        }
        System.out.println("Id de la Cuenta a Consultar:");
        int id = Utilidad.leer_Int();
        boolean enc = false;
        for (int i=0; i<contadorCliente && !enc; i++){
            enc = ClienteNuevo[i].consultarCuentaPorId(id);
        }
        if(!enc){
            System.out.println("Id de cuenta no registrado....");
        }
    }

    public static void reporte_3() {
        System.out.println("LISTADO DE USUARIOS");
        System.out.println("ID \tCedula \t\tNombres Apellidos");
        for (int i = 0; i < ClienteNuevo.length; i++) {
            if (ClienteNuevo[i] != null) {
                //int num=i+1;
                System.out.println(ClienteNuevo[i].getIdCLiente() + "\t" + ClienteNuevo[i].getCedulaCliente() + "\t" + ClienteNuevo[i].getNombresCLiente());
            } else {
                break;
            }
        }
    }

    public static void reporte_4() {
    }

    public static void reporte_5() {
        System.out.println("LISTADO DE TIPOS DE OPERACIONES");
        System.out.println("N° \tID \tDESCRIPCIÓN");
        for (int i = 0; i < cont_tipope; i++) {
            int num = i + 1;
            System.out.println("" + num + " \t" + tipope[i].getId() + " \t" + tipope[i].getDescripcion());
        }
    }

    public static void reporte_6() {
        System.out.println("LISTADO DE TIPOS DE CUENTAS");
        System.out.println("N° \tID \tDESCRIPCIÓN");
        for (int i = 0; i < cont_tipc; i++) {
            int num = i + 1;
            System.out.println("" + num + " \t" + tipcuenta[i].getId() + " \t" + tipcuenta[i].getDescripcion());
        }
    }

    public static void reportes() {
        int opcion = -1;
        do {
            opcion = menuReportes();
            switch (opcion) {
                case 1:
                    reporte_1();
                    break;
                case 2:
                    reporte_2();
                    break;
                case 3:
                    reporte_3();
                    break;
                case 4:
                    reporte_4();
                    break;
                case 5:
                    reporte_5();
                    break;
                case 6:
                    reporte_6();
                    break;
                case 7:
                    System.out.println("Volviendo al Menu Principal");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 7);
    }

    public static int menu() {
        int opcion = 0;
        System.out.println("***********MENU PRINCIPAL************");
        System.out.println("1.- Nuevo Tipo de Cuenta.");
        System.out.println("2.- Nuevo Tipo de Operacion.");
        System.out.println("3.- Nuevo Cliente.");
        System.out.println("4.- Nueva Cuenta Bancaria");
        System.out.println("5.- Nueva Operaciones Bancarias");
        System.out.println("6.- Reportes");
        System.out.println("7.- Salir.");
        System.out.println("Seleccione su opcion: ");
        opcion = Utilidad.leer_Int();
        return opcion;
    }

    public static int menuReportes() {
        int opcion = -1;
        System.out.println("----------MENU REPORTES-------------");
        System.out.println("1.- Consulta de Usuario y observar sus cuentas");
        System.out.println("2.- Consultar cuenta con operaciones.");
        System.out.println("3.- Listado de Usuarios.");
        System.out.println("4.- Listado de Cuentas por tipos.");
        System.out.println("5.- Listado de tipos de Operaciones.");
        System.out.println("6.- Listado de tipo de Cuentas.");
        System.out.println("7.- Regresar al Menu Principal");
        System.out.println("Seleccione su opcion: ");
        opcion = Utilidad.leer_Int();
        return opcion;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        tipcuenta = new TipoCuenta[2];
        cont_tipc = 0;
        tipope = new TipoOperacion[2];
        cont_tipope = 0;
        ClienteNuevo = new Cliente[2];
        contadorCliente = 0;
        idClienteIncrementado = 0;
        idCuentaIncrementado = 0;
        idOperacionIncrementado = 0;
        int opcion = -1;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    insertarTipoCuenta();
                    break;
                case 2:
                    insertarTipoOperaciones();
                    break;
                case 3:
                    insertarCliente();
                    break;
                case 4:
                    insertarCuentaBancaria();
                    break;
                case 5:
                    insertarOperacionBancaria();
                    break;
                case 6:
                    reportes();
                    break;
                case 7:
                    System.out.println("Fin de la Aplicacion");
                    break;
                default:
                    System.out.println("Opcion Invalida!");
                    break;
            }
        } while (opcion != 7);
    }
}