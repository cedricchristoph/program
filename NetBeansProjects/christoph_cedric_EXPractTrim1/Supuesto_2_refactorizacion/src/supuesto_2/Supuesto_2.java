
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

        escribe("Menú principal");
        escribe("1 Sumar");
        escribe("2 Restar");
        escribe("3 Dividir");
        escribe("4 Multiplicar");
        escribe("5 Salir");
        escribe("");  
        escribe("Introduzca el número de la opción que quiera elegir.");      
    }
    
    // crearEspacio solo esta para hacer que sea más organizada la consola
    public static void crearEspacio(){
        escribe("");
        escribe("");
        escribe("");
    }
    // esta funcion se encarga de analizar el input del usuario y reenviar a la función correspondiente.
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
        Scanner scan = new Scanner(System.in);
        int A = 0;
        int B = 0;
        crearEspacio();
        
        escribe("Bienvenido a SUMAR");
        escribe("Introduzca un valor A:");
        
        try{
            A = scan.nextInt();
        }catch (InputMismatchException ex){
            System.out.println("No ha introducido un número");
        }
        
        escribe("Introduzca un valor B:");
        
        try{
        B = scan.nextInt();
        }catch (InputMismatchException ex){
            System.out.println("No ha introducido un número");
        }
        
        escribe(A + " + " + B + " = " + (A+B));
        crearEspacio();
    }
    
    // Función de restar   
    public static void restar(){
        Scanner scan = new Scanner(System.in);
        int A = 0;
        int B = 0;
        crearEspacio();
        
        escribe("Bienvenido a RESTAR");
        escribe("Introduzca un valor A:");
        
        try{
            A = scan.nextInt();
        }catch (InputMismatchException ex){
            System.out.println("No ha introducido un número");
        }
        
        escribe("Introduzca un valor B:");
        
        try{
        B = scan.nextInt();
        }catch (InputMismatchException ex){
            System.out.println("No ha introducido un número");
        }
        
        escribe(A + " - " + B + " = " + (A-B));
        crearEspacio();
    }
   
    // Función de dividir
    public static void dividir(){
        Scanner scan = new Scanner(System.in);
        int A = 0;
        int B = 0;
        crearEspacio();
        
        escribe("Bienvenido a DIVIDIR");
        escribe("Introduzca un valor A:");
        
        try{
            A = scan.nextInt();
        }catch (InputMismatchException ex){
            System.out.println("No ha introducido un número");
        }
        
        escribe("Introduzca un valor B:");
        
        try{
        B = scan.nextInt();
        }catch (InputMismatchException ex){
            System.out.println("No ha introducido un número");
        }
        
        escribe(A + " / " + B + " = " + (A/B));
        crearEspacio();
    }
    
    // Función de multiplicar
    public static void multiplicar()throws Exception{
        Scanner scan = new Scanner(System.in);
        int A = 0;
        int B = 0;
        crearEspacio();
        
        escribe("Bienvenido a MULTIPLICAR");
        escribe("Introduzca un valor A:");
        
        try{
            A = scan.nextInt();
        }catch (InputMismatchException ex){
            System.out.println("No ha introducido un número");
        }
        
        escribe("Introduzca un valor B:");
        
        try{
        B = scan.nextInt();
        }catch (InputMismatchException ex){
            System.out.println("No ha introducido un número");
        }
        escribe(A + " * " + B + " = " + (A*B));
        crearEspacio();
        
    }
    
}
