/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Weps
 */
public class Cliente {
    private long idCliente;
    private String nombresCliente;
    private String cedulaCliente;
    private CuentaBancaria[] cuentas;

    public Cliente(){
        nombresCliente="";
        idCliente=0;
        cedulaCliente="";
    }
    public void createCliente(String CedulaIngresada, long idClienteIncrementado) {
        idCliente=idClienteIncrementado;
        cedulaCliente=CedulaIngresada;
        System.out.println("INGRESE NOMBRES Y APELLIDOS DEL CLIENTE");
        nombresCliente=Utilidad.leer_String();
    } 
    
    public long getIdCLiente(){
        return idCliente;
    }
    
    public String getCedulaCliente(){
        return cedulaCliente;
    }
    
    public String getNombresCLiente(){
        return nombresCliente;
    }
}
