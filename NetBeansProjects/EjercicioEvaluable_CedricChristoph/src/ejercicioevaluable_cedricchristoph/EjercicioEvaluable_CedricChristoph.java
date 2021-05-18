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
    
    /**
     * Constantes String que indican colores para la salida
     */
    static final String grey = "\033[1m";
    static final String black = "\033[0m";
    
    /**
     * Variable Integer la cual contendrá la posición de la primera cifra
     * del número introducido por el usuario en los decimales de PI.
     * 
     * Ej.: NUMERO: 265   charAt=7   -> El 2 de 265 está en posición 7 de PI.
     * 
     */
    static int charAt;
    
    /**
     * Método main que inicia la estructura lógica del programa.
     * @param args
     */
    public static void main(String[] args) {
        final File archivoPI = new File("pi-million.txt");
        String input;
        System.out.println("Para salir del programa introduzca '0'");
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
                System.out.println("Su número se encuentra en el caracter: " + charAt + "\n");
                mostrar(number, getPIDecimals(archivoPI));
            } else
                System.out.println(":( Su número no se encuentra en PI");
            
        } while (!(input.equals("0")));
        System.out.println("\nAdiós ;)");
    }
 
    /**
     * 
     * Muestra un segmento de PI que contiene el numero encontrado.
     * La dimensión de dicho segmento será el número del usuario +50 números.
     * El número del usuario será destacado en color negro. 
     * El segmento sobrante se muestra en color gris.
     * 
     * @param numero El número del usuario que se encontró
     * @param decimals Todos los decimales de PI
     * 
     */
    public static void mostrar(Integer[] numero, Integer[] decimals) {
        try {
            System.out.print(grey + "...");
            for (int i=charAt; i<(charAt+50); i++){
                System.out.print(black);
                if (!(i<(charAt+numero.length)))
                    System.out.print(grey);
                System.out.print(decimals[i]);
            }
            System.out.print("..." + black + "\n");
        } catch (IndexOutOfBoundsException e) {
            
        }
    }
    
    /**
     * 
     * Función que devuelve un número introducido por el usuario.
     * 
     * @param message Mensaje que se mostrará al usuario
     * @return Integer número introducido por usuario
     * 
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
    
    /**
     * 
     * Función para leer el archivo .txt que contiene decimales de PI.
     * 
     * Devuelve un vector de Integer de cada decimal.
     * @param archivo Archivo .txt que contiene PI
     * @return Vector Integer de decimales
     * 
     */
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
    
    /**
     * 
     * Función que se encarga de encontrar el número que busca el usuario.
     * Utilizamos un vector de Integer cuyos valores solo pueden ser 'null', '0' o '1'.
     * Dicho vector se llenará de '1' cuando se haya encontrado el número.
     * 
     * @param numero Vector del número introducido por el usuario
     * @param decimals Vector de decimales de PI a comprobar
     * @return Devuelve true si se ha encontrado el número
     * 
     */
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
    
    /**
     * 
     * Comprueba si el vector 'pattern' está completamente lleno de '1' o no.
     * 
     * @param pattern Vector de Integer que indica los resultados de búsqueda del patrón a buscar
     * @param limit El valor de cifras que tiene el número introducido por el usuario.
     * @return Devuelve true si todos los Integer del vector pattern son '1'
     * 
     */
    public static boolean hasBeenFound(Integer[] pattern, Integer limit) {
        Integer counter_valor = 0;
        for (Integer valor : pattern) {
            if (valor == 1)
                counter_valor++;
        }
        return counter_valor == limit;
    }
    
    /**
     * 
     * Función que comprueba si el vector pattern está lleno o siguen habiendo valores 'null'
     * 
     * @param pattern Vector integer a comprobar
     * @return Devuelve true si ya no existen valores 'null' en el vector.
     * 
     */
    public static boolean isFinished(Integer[] pattern) {
        int counter_valor = 0;
        for (Integer valor : pattern){
            if (valor != null)
                counter_valor++;
        }
        return counter_valor == pattern.length;
    }
    
    /**
     * 
     * Función que comprueba si el número y el decimal que se le proporciona son iguales o no.
     * 
     * @param numero Integer. Una cifra del número introducido por el usuario
     * @param decimal Integer. Decimal actual de PI a comparar con el número
     * @return Devuelve true si numero == decimal.
     * 
     */
    public static Integer check(Integer numero, Integer decimal) {
        if (numero == decimal) 
            return 1;
        else
            return 0;
    }
}
