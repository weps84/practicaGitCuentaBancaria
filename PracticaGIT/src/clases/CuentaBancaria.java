/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.SimpleDateFormat;
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
    private OperacionBancaria [] operaciones;
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
    }

    public void getCuentaBancariaById(long idCuentaBancaria) {
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
    
}
