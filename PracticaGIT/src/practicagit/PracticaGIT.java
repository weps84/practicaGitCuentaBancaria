/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicagit;
import clases.TipoCuenta;
import clases.TipoOperacion;
import clases.Cliente;
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
    // COMPAÑEROS LO LIMITE A 500 (static Cliente[] ClienteNuevo=new Cliente[500]) YA QUE 
    // AL DEJARLO DE ESTA FORMA static Cliente[] ClienteNuevo ME DABA  UN ERROR DE PUNTERO 
    // NULO AL COMPARAR EL OBJETO EN EL FOR
    static Cliente[] ClienteNuevo;
    static int contadorCliente;  
    static long idClienteIncrementado;
    public static Cliente[] ampliarArregloCliente(Cliente arreglo[], int extra){
		//creo el arreglo con el tamaño original mas el extra a ampliar
		Cliente nuevo[] = new Cliente[arreglo.length+extra];
		//ahora copiare los datos del viejo arreglo al nuevo
		for(int i = 0;i < arreglo.length;i++){
			//antes de copiar verifico k no sea nulo pa evitar excepciones
			//si es nulo no necesito copiar, lo dejo asi
			if(arreglo[i] != null){
				nuevo[i] = arreglo[i];
			}
		}
		//ahora retorno el arreglo con tamaño extra y con los datos k contenia antes
		return nuevo;
	} 
    public static TipoOperacion[] ampliarArregloTipoOperacion(TipoOperacion arreglo[], int extra){
		//creo el arreglo con el tamaño original mas el extra a ampliar
		TipoOperacion nuevo[] = new TipoOperacion[arreglo.length+extra];
		//ahora copiare los datos del viejo arreglo al nuevo
		for(int i = 0;i < arreglo.length;i++){
			//antes de copiar verifico k no sea nulo pa evitar excepciones
			//si es nulo no necesito copiar, lo dejo asi
			if(arreglo[i] != null){
				nuevo[i] = arreglo[i];
			}
		}
		//ahora retorno el arreglo con tamaño extra y con los datos k contenia antes
		return nuevo;
	}  
    
    public static TipoCuenta[] ampliarArregloTipoCuenta(TipoCuenta arreglo[], int extra){
		//creo el arreglo con el tamaño original mas el extra a ampliar
		TipoCuenta nuevo[] = new TipoCuenta[arreglo.length+extra];
		//ahora copiare los datos del viejo arreglo al nuevo
		for(int i = 0;i < arreglo.length;i++){
			//antes de copiar verifico k no sea nulo pa evitar excepciones
			//si es nulo no necesito copiar, lo dejo asi
			if(arreglo[i] != null){
				nuevo[i] = arreglo[i];
			}
		}
		//ahora retorno el arreglo con tamaño extra y con los datos k contenia antes
		return nuevo;
	}
    public static void insertarTipoCuenta() {
        long idTipCuen;
        int band=0;
        //System.out.println("cont_tipc: "+cont_tipc+" TAMAÑO DEL ARREGLO: "+tipcuenta.length);
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
            if(cont_tipc>=tipcuenta.length){
              tipcuenta=ampliarArregloTipoCuenta(tipcuenta,10);
              //System.out.println("entre");
            }
              //System.out.println(" entre "+cont_tipc);
            tipcuenta[cont_tipc]=new TipoCuenta();
            tipcuenta[cont_tipc].addTipoCuenta(idTipCuen);
            cont_tipc++;
          }
          else{
            System.out.println("LO SIENTO DEBE DE RECTIFICAR EL IDENTIFICADOR UNICO DEL TIPO DE CUENTA YA QUE EL INGRESADO SE ENCUENTRA REGISTRADO ANTERIORMENTE");
          }
        /*}
        else{
          System.out.println("LO SIENTO HA SOBREPASADO EL LÍMITE DE 500 TIPOS DE CUENTA, POR LO QUE NO SE PUEDE CREAR UNA NUEVA");
        }*/
    }

    public static void insertarTipoOperaciones() {
          long idTipOpe;
          int band=0;
        //if(cont_tipope<500){
          // ¿¿¿ NUVIA EL IDENTIFICADOR UNICO NO DEBERIA INCREMENTARSE AUTOMATICAMENTE SIN NECESIDAD DE PEDIRLO???
          // YO LO INCREMENTO AUTOMATICAMENTE EN EL CLIENTE O CORRIJANME SI ME EQUIVOCO////
          System.out.println("INGRESE EL IDENTIFICADOR UNICO DEL TIPO DE OPERACIÓN: ");
          idTipOpe = Utilidad.leer_Long();
          for(int i=0; i<cont_tipope && band==0; i++){
            if(tipope[i].getId()==idTipOpe){
              band=1;
            }
          }
          if(band==0){
            if(cont_tipope>=tipope.length){
              tipope=ampliarArregloTipoOperacion(tipope,10);
              //System.out.println("entre");
            }
            tipope[cont_tipope]=new TipoOperacion();
            tipope[cont_tipope].addTipoOperacion(idTipOpe);
            cont_tipope++;
          }
          else{
            System.out.println("LO SIENTO DEBE DE RECTIFICAR EL IDENTIFICADOR UNICO DEL TIPO DE OPERACIÓN YA QUE EL INGRESADO SE ENCUENTRA REGISTRADO ANTERIORMENTE");
          }
        /*
        else{
          System.out.println("LO SIENTO HA SOBREPASADO EL LÍMITE DE 500 TIPOS DE OPERACIÓN, POR LO QUE NO SE PUEDE CREAR UNO NUEVO");
        }*/
    }

    public static void insertarCliente() {
        String cedula;
           System.out.println("--- MODULO PARA REGISTRAR CLIENTES ---");
        System.out.println("INGRESE EL NUMERO DE CEDULA DEL CLIENTE: ");
        cedula = Utilidad.leer_String();
        int swEncontrado=0;
        //VALIDAR SI LA CEDULA EXISTE
        for(int i=0;i<contadorCliente && swEncontrado==0;i++){
            //if (ArregloDatos[i]!=null){
            //if (ClienteNuevo[i]!=null){
                if (ClienteNuevo[i].getCedulaCliente().equals(cedula)){
                    swEncontrado=1;
                }
            //}
        }
        if (swEncontrado==1){
            System.out.println("La cedula que esta intentando ingresar ya existe en nuestra base de datos");
        }else{
            if(contadorCliente>=ClienteNuevo.length){
              ClienteNuevo=ampliarArregloCliente(ClienteNuevo,10);
              //System.out.println("entre");
            }
            idClienteIncrementado++;
            ClienteNuevo[contadorCliente]=new Cliente();
            ClienteNuevo[contadorCliente].createCliente(cedula,idClienteIncrementado);
            contadorCliente++;
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
        System.out.println("LISTADO DE USUARIOS");
        System.out.println("ID \tCedula \t\tNombres Apellidos");
        for(int i=0;i<ClienteNuevo.length;i++){            
            if (ClienteNuevo[i]!=null){
                //int num=i+1;
                System.out.println(ClienteNuevo[i].getIdCLiente()+"\t"+ClienteNuevo[i].getCedulaCliente()+"\t"+ClienteNuevo[i].getNombresCLiente());
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
        tipcuenta = new TipoCuenta[2];
        cont_tipc=0;
        tipope = new TipoOperacion[2];
        cont_tipope=0;
        ClienteNuevo = new Cliente[2];
        contadorCliente=0;
        idClienteIncrementado=0;
        /*int n;
        System.out.println("INGRESE LA CANTIDAD DE TIPO DE OPERACIONES QUE TIENE EL BANCO");
        n= Utilidad.leer_Int();    
        ampliarArreglo(tipope,n);
        System.out.println("INGRESE LA CANTIDAD DE TIPO DE CUENTAS QUE TIENE EL BANCO");
        n= Utilidad.leer_Int();    
        ampliarArreglo(tipcuenta,n);
        System.out.println("INGRESE LA CANTIDAD DE CLIENTES QUE TIENE EL BANCO");
        n= Utilidad.leer_Int();    
        ampliarArreglo(ClienteNuevo,n);*/
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