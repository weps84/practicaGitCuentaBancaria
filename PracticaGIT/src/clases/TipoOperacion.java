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
    public TipoOperacion(){
       descripcion="";
       idTipoOperacion=-1;
   }

    public void addTipoOperacion(long id) {
        idTipoOperacion = id;
        System.out.println("INGRESE LA DESCRIPCIÓN DEL TIPO DE OPERACIÓN: ");
        descripcion = Utilidad.leer_String();
    }
    public long getId(){
      return idTipoOperacion;
    }
    public String getDescripcion(){
      return descripcion;
    }
}
