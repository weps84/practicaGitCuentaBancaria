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
public class TipoCuenta {

    private String descripcion;
    private long idTipoCuenta;

    public void addTipoCuenta() {
        System.out.println("INGRESE EL IDENTIFICADOR UNICO DEL TIPO DE CUENTA: ");
        idTipoCuenta = Utilidad.leer_Long();
        System.out.println("INGRESE LA DESCRIPCIÓN DEL TIPO DE CUENTA: ");
        descripcion = Utilidad.leer_String();
    }
}
