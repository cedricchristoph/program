/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploflujo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Inf2
 */
public class EjemploFlujo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try 
        {
            int c = 0;
            BufferedReader r = new BufferedReader(new FileReader("fichero.txt"));
            String linea = r.readLine();
            while (linea != null) {
                linea = r.readLine();
                c++;
            }
            r.close();
            System.out.println("Archivo recibido. Se han leído " + c + " líneas");
        } catch (Exception e) {
            
        }
    }
    
}
