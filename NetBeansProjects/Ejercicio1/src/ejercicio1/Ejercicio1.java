/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Inf2
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File fichero = new File(getInput("Introduzca la ruta de un fichero a analizar:"));
            BufferedReader reader = new BufferedReader(new FileReader(fichero));
            Estadistica estadistica = new Estadistica();
            String linea;
            while ((linea = reader.readLine()) != null) {
                estadistica.analiza(linea);
            }
            reader.close();
            System.out.println(estadistica.getResult());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static String getInput(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        return scan.nextLine();
    }
}
