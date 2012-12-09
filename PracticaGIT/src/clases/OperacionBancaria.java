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
public class OperacionBancaria {

    private String claveOperacion;
    private Date fechaOperacion;
    private long idOperacion;
    private TipoOperacion tipoOperacion;
    private double montoOperacion;
    private double montoActual;
    private String estado;

    public void getListOperacionesByDate(Date inicio, Date fin) {
    }

    public void mostrarTransaccion(){
        System.out.println("IdOperacion: "+this.idOperacion);
        System.out.println("Fecha: "+this.fechaOperacion.toString());
        System.out.println("Tipo de Operacion: "+this.tipoOperacion.getDescripcion());
        System.out.println("Monto de la Operacion: "+this.montoOperacion);
        System.out.println("Monto de la Cuenta al momento: "+this.montoActual);
        System.out.println("Estado de la Operacion: "+this.estado);
    }
    public double createOperacionBancaria(long idOperacion, TipoOperacion tipo, double montoActual) {
        System.out.println("Clave de la Operacion: ");
        this.claveOperacion = Utilidad.leer_String();
        this.idOperacion = idOperacion;
        this.tipoOperacion = tipo;
        System.out.println("Fecha");
        System.out.println("Dia: ");
        int dia = Utilidad.leer_Int();
        System.out.println("Mes (Numero): ");
        int mes = Utilidad.leer_Int();
        System.out.println("Año (Ejemplo: 2012): ");
        int anho = Utilidad.leer_Int();
        Calendar cal = Calendar.getInstance();
        cal.set(anho, mes, dia);
        this.fechaOperacion = cal.getTime();

        System.out.println("Monto de la Transaccion: ");
        this.montoOperacion = Utilidad.leer_Double();
        this.montoActual = montoActual;
        if (this.tipoOperacion.getTipo() == 1) {
            if (this.montoOperacion > this.montoActual) {
                System.out.println("No podemos procesar su transaccion, SALDO INSUFICIENTE....");
                this.estado = "NEGADA- SALDO INSUFICIENTE";
            } else {
                this.montoActual -= this.montoOperacion;
                this.estado = "APROBADA";
            }
        } else {
            if (this.tipoOperacion.getTipo() == 2) {
                this.montoActual += this.montoOperacion;
                this.estado = "APROBADA";
            }
        }
        return this.montoActual;
    }

    public String getClaveOperacion() {
        return claveOperacion;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public long getIdOperacion() {
        return idOperacion;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public double getMontoOperacion() {
        return montoOperacion;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public String getEstado() {
        return estado;
    }
}
