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
public class TipoOperacion {

    private String descripcion;
    private long idTipoOperacion;

    public void addTipoOperacion() {
        System.out.println("INGRESE EL IDENTIFICADOR UNICO DEL TIPO DE OPERACIÓN: ");
        idTipoOperacion = Utilidad.leer_Long();
        System.out.println("INGRESE LA DESCRIPCIÓN DEL TIPO DE OPERACIÓN: ");
        descripcion = Utilidad.leer_String();
    }
}
