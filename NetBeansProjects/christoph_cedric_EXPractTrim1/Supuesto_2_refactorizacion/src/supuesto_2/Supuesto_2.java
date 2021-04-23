
package supuesto_2;
import java.util.*;
/**
 *
 * @author Cedric Christoph
 */
public class Supuesto_2 {
    public static void main(String[] args)throws Exception {
        // Definimos las variables que necesitaremos
        Scanner scan = new Scanner(System.in);
        byte menuInput = 0;
       // El while me permite que el programa nunca acabe.
        while (true){
            showMenu();
            try
            {
                menuInput = scan.nextByte();
                if (!(menuInput >= 1 && menuInput <= 5)){
                    throw new Exception("No existe este punto del menú. Inténtelo de nuevo");
                }
                else    
                {
                    navegar(menuInput);
                }
                
            }
            catch (Exception ex)
            {
                menuInput = 0;
                System.out.println(ex.getMessage());
                scan.nextLine();
            }
        }
        
    }
    // Para no tener que escribir siempre System.out.println he creado esta función.
    public static void escribe(String x){
        System.out.println(x);
    }
    // showMenu simplemente imprime el menu completo.
    public static void showMenu(){
        System.out.println("Menú principal");
        System.out.println("1 Sumar");
        System.out.println("2 Restar");
        System.out.println("3 Dividir");
        System.out.println("4 Multiplicar");
        System.out.println("5 Salir");
        System.out.println("");  
        System.out.println("Introduzca el número de la opción que quiera elegir.");      
    }
    
    // crearEspacio solo esta para hacer que sea más organizada la consola
    public static void crearEspacio(){
        System.out.println("\n\n");
    }
    
    // esta funcion se encarga de analizar el input del usuario 
    // y reenviar a la función correspondiente.
    public static void navegar(byte input)throws Exception{
        switch (input) {
            case 1:
                sumar();
                break;
            case 2:
                restar();
                break;
            case 3:
                dividir();
                break;
            case 4:
                multiplicar();
                break;    
            case 5:
                crearEspacio();
                escribe("Gracias por usar mi programa.");
                escribe(":)");
                System.exit(0);
        }
    }
    
    // Función de sumar
    public static void sumar(){
        crearEspacio();
        System.out.println("Bienvenido a SUMAR");
        Integer A = getInt("Introduzca un valor A:");
        Integer B = getInt("Introduzca un valor B:");
        escribe(A + " + " + B + " = " + (A+B));
    }
    
    // Función de restar   
    public static void restar(){
        crearEspacio();
        System.out.println("Bienvenido a RESTAR");
        Integer A = getInt("Introduzca un valor A:");
        Integer B = getInt("Introduzca un valor B:");
        escribe(A + " - " + B + " = " + (A-B));
    }
   
    // Función de dividir
    public static void dividir(){
        crearEspacio();
        System.out.println("Bienvenido a DIVIDIR");
        Integer A = getInt("Introduzca un valor A:");
        Integer B = getInt("Introduzca un valor B:");
        System.out.println(A + " / " + B + " = " + (A/B));
    }
    
    // Función de multiplicar
    public static void multiplicar()throws Exception{
        crearEspacio();
        System.out.println("Bienvenido a MULTIPLICAR");
        Integer A = getInt("Introduzca un valor A:");
        Integer B = getInt("Introduzca un valor B:");
        System.out.println(A + " * " + B + " = " + (A*B));
    }
    
    public static Integer getInt(String messageToPrint) {
        Scanner scan = new Scanner(System.in);
        System.out.println(messageToPrint);
        try {
            return scan.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("You typed an incorrect value");
            return null;
        }
    }
    
}
