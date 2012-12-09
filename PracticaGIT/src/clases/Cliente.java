/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import utilidad.Utilidad;

/**
 *
 * @author Weps
 */
public class Cliente {
    
    private long idCliente;
    private String nombresCliente;
    private String cedulaCliente;
    private CuentaBancaria[] cuentas;
    private int contadorCuentas;
    
    public Cliente() {
        nombresCliente = "";
        idCliente = 0;
        cedulaCliente = "";
    }
    
    public void createCliente(String CedulaIngresada, long idClienteIncrementado) {
        idCliente = idClienteIncrementado;
        cedulaCliente = CedulaIngresada;
        System.out.println("INGRESE NOMBRES Y APELLIDOS DEL CLIENTE");
        nombresCliente = Utilidad.leer_String();
        contadorCuentas = 0;
        cuentas = new CuentaBancaria[2];
    }
    
    private CuentaBancaria[] ampliarArregloCuenta(CuentaBancaria arreglo[], int extra) {
        CuentaBancaria nuevo[] = new CuentaBancaria[arreglo.length + extra];
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                nuevo[i] = arreglo[i];
            }
        }
        return nuevo;
    }
    
    public long getIdCLiente() {
        return idCliente;
    }
    
    public String getCedulaCliente() {
        return cedulaCliente;
    }
    
    public String getNombresCLiente() {
        return nombresCliente;
    }
    
    public void NuevaCuentaBancaria(TipoCuenta tipo, long id) {
        System.out.println("Numero de Cuenta: ");
        String numeroCuenta = Utilidad.leer_String();
        boolean enc = false;
        for (int i = 0; i < contadorCuentas && !enc; i++) {
            if (numeroCuenta.compareTo(cuentas[i].getNumeroCuenta()) == 0) {
                enc = true;
            }
        }
        if (enc) {
            System.out.println("Numero de cuenta registrada...");
            return;
        }
        if (contadorCuentas >= cuentas.length) {
            cuentas = ampliarArregloCuenta(cuentas, 10);
        }
        cuentas[contadorCuentas] = new CuentaBancaria();
        cuentas[contadorCuentas].createCuentaBancaria(tipo, id, numeroCuenta);
        contadorCuentas++;
    }
    
    public int getContadorCuentas() {
        return contadorCuentas;
    }
    
    public void nuevaOperacionBancaria(TipoOperacion tipo, long id) {
        System.out.println("***Cuentas*****");
        System.out.println("Numero\t\tMonto");
        for (int i = 0; i < contadorCuentas; i++) {
            System.out.println(cuentas[i].getNumeroCuenta() + "\t\t" + cuentas[i].getMontoCuenta());
        }
        System.out.println("Numero de Cuenta: ");
        String numero = Utilidad.leer_String();
        boolean enc = false;
        int posCuenta = -1;
        for (int i = 0; i < contadorCuentas && !enc; i++) {
            if (cuentas[i].getNumeroCuenta().compareToIgnoreCase(numero) == 0) {
                enc = true;
                posCuenta = i;
            }
        }
        if (!enc) {
            System.out.println("Numero de cuenta no existente....");
            return;
        }
        cuentas[posCuenta].nuevaOperacionBancaria(tipo, id);
    }
}
