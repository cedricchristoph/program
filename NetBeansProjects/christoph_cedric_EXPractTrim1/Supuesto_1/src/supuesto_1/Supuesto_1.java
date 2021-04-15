
package supuesto_1;

import java.util.Arrays;

/**
 *
 * @author Cedric Christoph
 */
public class Supuesto_1 {
    public static void main(String[] args) {
        // Definimos las variables que necesitaremos a lo largo del código.
        String caracter = "";
        
        // Creamos el array que contiene el texto.
        String[] text = {"E", "n", " ", "u", "n", " ", "l", "u", "g", "a", "r", " ",
                         "d", "e", " ", "l", "a", " ", "m", "a", "n", "c", "h", "a", "."};
        
        // Array creado.
        // Imprimimos en pantalla nuestro array.
        System.out.println(Arrays.toString(text));
        
        // Sustituimos todos los vocales por *
        for (int j=0; j<text.length; j++) {
            // Miramos cada elemento uno por uno
            caracter = text[j];
            
            // Averiguamos si es una vocal:
            switch (caracter)
            {
                case "a":
                    caracter = "*"; 
                    break;
                case "A":
                    caracter = "*"; 
                    break;
                case "e":
                    caracter = "*"; 
                    break;
                case "E":
                    caracter = "*"; 
                    break;
                case "i":
                    caracter = "*"; 
                    break;
                case "I":
                    caracter = "*"; 
                    break;
                case "o":
                    caracter = "*"; 
                    break;
                case "O":
                    caracter = "*"; 
                    break;
                case "u":
                    caracter = "*"; 
                    break;
                case "U":
                    caracter = "*"; 
                    break;
            }
            // En el caso de que sea vocal se sustituirá por la *.
            // Si no se queda el caracter que estaba anteriormente.
            text[j] = caracter;
        }
        
        System.out.println(Arrays.toString(text));
    }
    
}
