package ejercicio3;

import java.io.*;
import java.util.Scanner;

/**
 *
 *  Examen Final Java. Clase Main
 *  EJERCICIO 3
 *  @author Cedric Christoph
 *
 */
public class Ejercicio3 {

    private static final File fichero = new File("clientes.txt");
    private static Clientes datos = new Clientes();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try {
            datos.loadData();
            do {
                showMenu();
                navegar(getInput("$:"));
            } while (true);
        } catch (IOException e) {
            System.out.println("Ocurrió un error: No se encontró el archivo clientes.txt");
            try {
                fichero.createNewFile();
                System.out.println("Se creó el fichero. Reinicie el programa");
            } catch (IOException ex) {
                
            }
        }

    }
    
    public static void navegar (String input) throws IOException 
    {
        switch (input) {
            case "0":
                datos.saveData();
                System.exit(0);
            case "1":
                listar();
                break;
            case "2":
                mostrarCliente(
                        datos.buscar(
                                getInput("Introduzca NIF a buscar:")
                        )
                );
                break;
            case "3":
                if (datos.eliminar(getInput("Introduzca NIF a eliminar:"))) {
                    System.out.println("Se eliminó el cliente correctamente");
                } else {
                    System.out.println("No se pudo borrar ningun cliente con ese NIF");
                }
                break;
            case "4":
                if (datos.eliminarFichero()) {
                    System.out.println("Se eliminó el fichero");
                } else {
                    System.out.println("No se pudo eliminar el fichero");
                }
                break;
        }
    }
    
    public static void mostrarCliente (Cliente cliente) 
    {
        if (cliente != null) {
            System.out.println("------------------------------");
            System.out.println(">       NIF: " + cliente.getNIF());
            System.out.println(">    Nombre: " + cliente.getNombre());
            System.out.println(">  Teléfono: " + cliente.getTlf());
            System.out.println("> Dirección: " + cliente.getDireccion());
            System.out.println(">     Deuda: " + cliente.getDeuda() + " €");
            System.out.println("------------------------------\n");
        } else {
            System.out.println("No se encontró ningun cliente");
        }
    }
    
    public static void listar ()
    {
        for (Cliente cliente : datos.getLista()) {
            mostrarCliente(cliente);
        }
    }
    
    public static void showMenu ()
    {
        System.out.println("============== MENU ==============");
        System.out.println("(1) Listar clientes");
        System.out.println("(2) Buscar clientes");
        System.out.println("(3) Borrar cliente usando NIF");
        System.out.println("(4) Eliminar fichero");
        System.out.println("(0) Salir");
        System.out.println("==================================");
    }
    
    public static String getInput(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        return scan.nextLine();
    }
}
