/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicagit;
import clases.TipoCuenta;
import clases.TipoOperacion;
import utilidad.*;

/**
 *
 * @author Weps
 */
public class PracticaGIT {
    TipoCuenta[] tipcuenta = new TipoCuenta[500];
    int cont_tipc=0;
    
    TipoOperacion[] tipope = new TipoOperacion[500];
    int cont_tipope=0;
    
    public static void insertarTipoCuenta() {
        tipcuenta[cont_tipc].addTipoCuenta();
        cont_tipc++;
    }

    public static void insertarTipoOperaciones() {
        tipope[cont_tipope].addTipoOperacion();
        cont_tipope++;
    }

    public static void insertarCliente() {
    }

    public static void insertarCuentaBancaria() {
    }

    public static void insertarOperacionBancaria() {
    }

    public static void reporte_1() {
    }

    public static void reporte_2() {
    }

    public static void reporte_3() {
    }

    public static void reporte_4() {
    }

    public static void reporte_5() {
    }

    public static void reporte_6() {
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
