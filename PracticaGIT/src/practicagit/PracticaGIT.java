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
    static TipoCuenta[] tipcuenta;
    static int cont_tipc;    
    static TipoOperacion[] tipope;
    static int cont_tipope;    
    public static void insertarTipoCuenta() {
        long idTipCuen;
        int band=0;
        if(cont_tipc<500){
          System.out.println("INGRESE EL IDENTIFICADOR UNICO DEL TIPO DE CUENTA: ");
          idTipCuen = Utilidad.leer_Long();
          //System.out.println(" ID: "+idTipCuen);
          for(int i=0; i<cont_tipc && band==0; i++){
              //System.out.println(" entre ");
            if(tipcuenta[i].getId()==idTipCuen){
              band=1;
            }
          }
          if(band==0){
              //System.out.println(" entre "+cont_tipc);
            tipcuenta[cont_tipc]=new TipoCuenta();
            tipcuenta[cont_tipc].addTipoCuenta(idTipCuen);
            cont_tipc++;
          }
          else{
            System.out.println("LO SIENTO DEBE DE RECTIFICAR EL IDENTIFICADOR UNICO DEL TIPO DE CUENTA YA QUE EL INGRESADO SE ENCUENTRA REGISTRADO ANTERIORMENTE");
          }
        }
        else{
          System.out.println("LO SIENTO HA SOBREPASADO EL LÍMITE DE 500 TIPOS DE CUENTA, POR LO QUE NO SE PUEDE CREAR UNA NUEVA");
        }
    }

    public static void insertarTipoOperaciones() {
          long idTipOpe;
          int band=0;
        if(cont_tipope<500){
          System.out.println("INGRESE EL IDENTIFICADOR UNICO DEL TIPO DE OPERACIÓN: ");
          idTipOpe = Utilidad.leer_Long();
          for(int i=0; i<cont_tipope && band==0; i++){
            if(tipope[i].getId()==idTipOpe){
              band=1;
            }
          }
          if(band==0){
            tipope[cont_tipope]=new TipoOperacion();
            tipope[cont_tipope].addTipoOperacion(idTipOpe);
            cont_tipope++;
          }
          else{
            System.out.println("LO SIENTO DEBE DE RECTIFICAR EL IDENTIFICADOR UNICO DEL TIPO DE OPERACIÓN YA QUE EL INGRESADO SE ENCUENTRA REGISTRADO ANTERIORMENTE");
          }
        }
        else{
          System.out.println("LO SIENTO HA SOBREPASADO EL LÍMITE DE 500 TIPOS DE OPERACIÓN, POR LO QUE NO SE PUEDE CREAR UNO NUEVO");
        }
    }

    public static void insertarCliente() {
        System.out.println("--- MODULO PARA REGISTRAR CLIENTES ---");
        System.out.println("Introduzca el numero de cedula: ");
        String cedula = Utilidad.leer_String();
        swEncontrado=0;
        //VALIDAR SI LA CEDULA EXISTE
        for(int i=0;i<ArregloDatos.length;i++){
            if (ArregloDatos[i]!=null){
                verDatosArreglo = ArregloDatos[i].split(";");
                if (cedula.equals(verDatosArreglo[0])){
                    swEncontrado=1;
                    break;
                }
            }
        }
        if (swEncontrado==1){
            System.out.println("La cedula que esta intentando ingresar ya existe en nuestra base de datos");
        }else{
            System.out.println("Introduzca los apellidos: ");
            String apellidos = Utilidad.leer_String();
            System.out.println("Introduzca los nombres: ");
            String nombres = Utilidad.leer_String();
            System.out.println("Introduzca la edad: ");
            int edad = Utilidad.leer_Int();            
            System.out.println("Introduzca el numero de telefono: ");
            String telefono = Utilidad.leer_String();
            System.out.println("Introduzca la direccion: ");
            String direccion = Utilidad.leer_String();
            //EL ARREGLO ES LIMITADO A 500 POSICIONES
            ArregloDatos[contadorDatoColumna]= cedula+";"+apellidos+";"+nombres+";"+edad+";"+telefono+";"+direccion;
            contadorDatoColumna++;
            System.out.println("/// DATOS INGRESADOS CON EXITO ///");
        }

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
        System.out.println("Cedula\tApellidos\tNombres\tEdad\tTelefono\tDireccion");
        String reemplazar;
        for(int i=0;i<ArregloDatos.length;i++){            
            if (ArregloDatos[i]!=null){
                reemplazar = ArregloDatos[i].replace(";","\t");
                //for(int j=0;j<3;j++){
                System.out.println(reemplazar); 
                //}
            }else{
                break;
            }
        }    
    
    }

    public static void reporte_4() {
    }

    public static void reporte_5() {
        System.out.println("LISTADO DE TIPOS DE OPERACIONES");
        System.out.println("N° \tID \tDESCRIPCIÓN");
        for(int i=0;i<cont_tipope;i++){
           int num=i+1;
           System.out.println(""+num+" \t"+tipope[i].getId()+" \t"+tipope[i].getDescripcion());
        }
    }

    public static void reporte_6() {
        System.out.println("LISTADO DE TIPOS DE CUENTAS");
        System.out.println("N° \tID \tDESCRIPCIÓN");
        for(int i=0;i<cont_tipc;i++){
           int num=i+1;
           System.out.println(""+num+" \t"+tipcuenta[i].getId()+" \t"+tipcuenta[i].getDescripcion());
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
        tipcuenta = new TipoCuenta[500];
        cont_tipc=0;    
        tipope = new TipoOperacion[500];
        cont_tipope=0;
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
