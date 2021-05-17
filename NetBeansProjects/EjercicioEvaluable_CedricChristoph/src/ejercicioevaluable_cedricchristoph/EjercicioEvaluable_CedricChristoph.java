/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioevaluable_cedricchristoph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Programa para buscar si un número introducido por el usuario se encuentra dentro del primer million
 * de decimales de PI.
 * @author Cedric Christoph
 */
public class EjercicioEvaluable_CedricChristoph {
    static final String grey = "\033[1m";
    static final String black = "\033[0m";
    static int charAt;
    
    public static void main(String[] args) {
        final File archivoPI = new File("pi-million.txt");
        String input;
        System.out.println("Para salir del programa introduzca 'exit'");
        do {
            input = receiveInt("\nIntroduzca número a buscar en los decimales de PI:");
            if (input.equals("0"))
                break;
            String[] split = input.split("");
            Integer[] number = new Integer[split.length];
            for (int i=0; i<number.length; i++) {
                number[i] = Integer.parseInt(split[i]);
            }
            if (buscar(number, getPIDecimals(archivoPI))){
                System.out.println("Se ha encontrado su número en el primer million!!");
                System.out.println("Su número se encuentra en el caracter: " + charAt);
                mostrar(number, getPIDecimals(archivoPI));
            } else
                System.out.println(":( Su número no se encuentra en PI");
            
        } while (!(input.equals("0")));
        System.out.println("\n\nAdiós ;)");
    }
 
    /**
     * Muestra el segmento de PI que contiene el numero encontrado.
     * @param numero
     * @param decimals 
     */
    public static void mostrar(Integer[] numero, Integer[] decimals) {
        try {
            for (int i=charAt; i<(charAt+50); i++){
                System.out.print(grey);
                if (!(i<(charAt+numero.length)))
                    System.out.print(black);
                System.out.print(decimals[i]);
            }
        } catch (IndexOutOfBoundsException e) {
            
        }
    }
    
    /**
     * Función que devuelve un número introducido por el usuario.
     * @param message Mensaje que se mostrará al usuario
     * @return Integer número introducido por usuario
     */
    public static String receiveInt(String message) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        String input = scan.nextLine();
        try {
            Integer.parseInt(input);
            return input;
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Inténtelo de nuevo");
            return receiveInt(message);
        }
    }
    
    public static Integer[] getPIDecimals(File archivo) {
        try {
            String PI = "";
            Scanner scan = new Scanner(archivo);
            while (scan.hasNext()) {
                PI += scan.next();
            }
            String split[] = PI.split("");
            Integer[] decimals = new Integer[split.length];
            for (int i=0; i<split.length; i++) {
                try {
                    decimals[i] = Integer.parseInt(split[i]);
                } catch (NumberFormatException e) {
                    
                }
            }
            return decimals;
        } catch (FileNotFoundException ex) {
            System.out.println("Error: File not found");
        }
        return null;
    }
    
    public static boolean buscar(Integer[] numero, Integer[] decimals) {
        int counter = -1;
        int i = -1;
        Integer[] pattern = new Integer[numero.length];
        try {
            do {
                do {
                    if (isFinished(pattern)) {
                        if (hasBeenFound(pattern, numero.length)) {
                            charAt = i - numero.length + 1;
                            return true;
                        }
                        break;
                    }
                    counter++;
                    i++;
                    pattern[counter] = check(numero[counter], decimals[i]);
                } while ((pattern[counter]==1));
                pattern = new Integer[numero.length];
                counter = -1;
            } while (i < decimals.length);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }
    
    public static boolean hasBeenFound(Integer[] pattern, Integer limit) {
        Integer counter_valor = 0;
        for (Integer valor : pattern) {
            if (valor == 1)
                counter_valor++;
        }
        return counter_valor == limit;
    }
    
    public static boolean isFinished(Integer[] pattern) {
        int counter_valor = 0;
        for (Integer valor : pattern){
            if (valor != null)
                counter_valor++;
        }
        return counter_valor == pattern.length;
    }
    
    public static Integer check(Integer numero, Integer decimal) {
        if (numero == decimal) 
            return 1;
        else
            return 0;
    }
}
