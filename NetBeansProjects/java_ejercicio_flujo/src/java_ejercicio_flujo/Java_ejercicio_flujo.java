/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_ejercicio_flujo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Inf2
 */
public class Java_ejercicio_flujo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputStream is = null;
        BufferedReader br = null;
         
        try {
             
            is = System.in;
            br = new BufferedReader(new InputStreamReader(is));
             
            String line = null;
             
            while ((line = br.readLine()) != null) {
                if (line.equals("quit")) {
                    break;
                }
                System.out.println("Line entered : " + line);
            }
             
        }
        catch (IOException ioe) {
            System.out.println("Exception while reading input " + ioe);
        }
        finally {
            // close the streams using close method
            try {
                if (br != null) {
                    br.close();
                }
            }
            catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }
 
        }
    }
}