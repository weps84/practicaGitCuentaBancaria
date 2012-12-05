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
    public TipoCuenta(){
       descripcion="";
       idTipoCuenta=-1;
   }
    public void addTipoCuenta(long id) {
        idTipoCuenta = id;
        System.out.println("INGRESE LA DESCRIPCIÓN DEL TIPO DE CUENTA: ");
        descripcion = Utilidad.leer_String();
    }
    public long getId(){
      return idTipoCuenta;
    }
    public String getDescripcion(){
      return descripcion;
    }
}
