/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Weps
 */
public class Utilidad {

    public static String leer_String() {
        String texto = null;
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader buff = new BufferedReader(in);
            texto = buff.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Utilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
    }

    public static long leer_Long() {
        long valor = -1;
        try {
            String texto = leer_String();
            valor = Long.parseLong(texto);
        } catch (Exception e) {
            valor = -1;
        }
        return valor;
    }

    public static double leer_Double() {
        double valor = -1;
        try {
            String texto = leer_String();
            valor = Double.parseDouble(texto);
        } catch (Exception e) {
            valor = -1;
        }
        return valor;
    }

    public static int leer_Int() {
        int valor = -1;
        try {
            String texto = leer_String();
            valor = Integer.parseInt(texto);
        } catch (Exception e) {
            valor = -1;
        }
        return valor;
    }
}
