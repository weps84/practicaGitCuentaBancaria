/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Calendar;
import java.util.Date;
import utilidad.*;

/**
 *
 * @author Weps
 */
public class CuentaBancaria {

    private Date fecha;
    private long idCuentaBancaria;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private OperacionBancaria[] operaciones;
    private int contadorOperaciones;
    private double montoCuenta;

    public void createCuentaBancaria(TipoCuenta tipo, long idCuentaBancaria, String nroCuenta) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.tipoCuenta = tipo;
        this.numeroCuenta = nroCuenta;
        System.out.println("Fecha");
        System.out.println("Dia: ");
        int dia = Utilidad.leer_Int();
        System.out.println("Mes (Numero): ");
        int mes = Utilidad.leer_Int();
        System.out.println("Año (Ejemplo: 2012): ");
        int anho = Utilidad.leer_Int();
        Calendar cal = Calendar.getInstance();
        cal.set(anho, mes, dia);
        this.fecha = cal.getTime();
        this.contadorOperaciones = 0;
        System.out.println("Monto Inicial de la Cuenta: ");
        this.montoCuenta = Utilidad.leer_Double();
        operaciones = new OperacionBancaria[2];
    }

    private OperacionBancaria[] ampliarArregloCuenta(OperacionBancaria arreglo[], int extra) {
        OperacionBancaria nuevo[] = new OperacionBancaria[arreglo.length + extra];
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                nuevo[i] = arreglo[i];
            }
        }
        return nuevo;
    }

    public boolean getCuentaBancariaById(long idCuentaBancaria) {
        return this.idCuentaBancaria == idCuentaBancaria;
    }

    public void mostrarCuenta(){
        System.out.println(this.idCuentaBancaria+"\t"+this.numeroCuenta+"\t"+this.tipoCuenta.getDescripcion()+"\t"+this.montoCuenta);
    }
    public void mostrarTodasLasTransacciones(){
        System.out.println("*****Listado de Operaciones*********");
        for (int i = 0; i < contadorOperaciones; i++) {
            System.out.println("1.---");
            operaciones[i].mostrarTransaccion();
        }
        System.out.println("Total disponible en la Cuenta: "+this.montoCuenta);
    }
    public Date getFecha() {
        return fecha;
    }

    public double getMontoCuenta() {
        return montoCuenta;
    }

    public long getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public OperacionBancaria[] getOperaciones() {
        return operaciones;
    }

    public void nuevaOperacionBancaria(TipoOperacion tipo, long id) {
        if (contadorOperaciones >= operaciones.length) {
            operaciones = ampliarArregloCuenta(operaciones, 10);
        }
        operaciones[contadorOperaciones] = new OperacionBancaria();
        this.montoCuenta = operaciones[contadorOperaciones].createOperacionBancaria(id, tipo, montoCuenta);
        contadorOperaciones++;
    }
}
