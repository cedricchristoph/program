package examen_segundo_trimestre_cedric_christoph;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *      CEDRIC CHRISTOPH
 *      DAM - PRO
 *      EXAMEN 2do TRIMESTRE
 */

public class Examen_Segundo_Trimestre_Cedric_Christoph {

    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando lista de libros...\n");
        ListaLibros libros = new ListaLibros();
        System.out.println("Lista creada satisfactoriamente.\n");
        do{
            libros = menu(libros);
        } while (true);
    }
    
    public static ListaLibros menu(ListaLibros libros) throws Exception{
        Scanner scan = new Scanner(System.in);
        boolean receivedType = false;
        // MOSTAR MENU
        System.out.println("============= MENU =============\n");
        System.out.println("------------ LIBROS ------------");
        System.out.println(" 1  - Añadir un libro");
        System.out.println(" 2  - Eliminar un libro (index)");
        System.out.println("10  - Vender un libro");
        System.out.println("------------ BÚSQUEDA -----------");
        System.out.println(" 3  - Recibir index de un libro");
        System.out.println(" 4  - Recibir libro (index)");
        System.out.println("------------- LISTA -------------");
        System.out.println(" 5  - Mostar todos los libros");
        System.out.println(" 6  - Mostrar libros de editorial");
        System.out.println(" 7  - Mostrar libros sin stock");
        System.out.println(" 8  - Borrar toda la lista");
        System.out.println("------------- ORDEN -------------");
        System.out.println(" 9  - Ordenar lista por ISBN\n");
        System.out.println(" 0  - SALIR");
        System.out.println("================================\n");
        
        // RECIBIR ENTRADA DEL USUARIO
        switch(scan.nextLine()){
            default:
                System.out.println("Entrada no conocida");
                break;
            case "0":
                System.exit(0);
            case "1":
                receivedType = false;
                System.out.println("Introduzca el ISBN:");
                String newIsbn = scan.nextLine();
                System.out.println("Introduzca el título:");
                String newTitulo = scan.nextLine();
                System.out.println("Intrpduzca el autor:");
                String newAutor = scan.nextLine();
                System.out.println("Introduzca la editorial:");
                String newEd = scan.nextLine();
                System.out.println("Introduzca el stock:");
                int newStock = 0;
                do{

                    try{
                        newStock = scan.nextInt();
                        receivedType = true;
                    }catch (Exception ex){
                        receivedType = false;
                        System.out.println("No ha introducido un número");
                        scan.nextLine();
                    }
                }while(!(receivedType));
                double newPrecio = 0.0;
                Libro nuevoLibro = new Libro();
                do{
                    try{
                        System.out.println("Introduzca un precio:");
                        newPrecio = scan.nextDouble();
                        receivedType = true;
                    }catch (InputMismatchException ex){
                        receivedType = false;
                        System.out.println("No ha introducido un número");
                        scan.nextLine();
                    }
                }while(!(receivedType));
                Libro newLibro = new Libro(newIsbn, newTitulo, newAutor, newEd, newStock, newPrecio);
                libros.addLibro(newLibro);
                return libros;
            case "2":
                int delIndex = -1;
                receivedType = false;
                do{
                    System.out.println("Introduzca el index a borrar:");
                    try{
                        delIndex = scan.nextInt();
                        if (delIndex >= 0){
                            receivedType = true;
                            break;
                        }
                    } catch (InputMismatchException ex){
                        receivedType = false;
                        System.out.println("No ha introducido un número");
                        scan.nextLine();
                    }
                }while (!(receivedType));
                libros.removeLibro(delIndex);
                return libros;
            case "3":
                receivedType = false;
                System.out.println("Introduzca el ISBN:");
                String searchIsbn = scan.nextLine();
                System.out.println("Introduzca el título:");
                String searchTitulo = scan.nextLine();
                System.out.println("Intrpduzca el autor:");
                String searchAutor = scan.nextLine();
                System.out.println("Introduzca la editorial:");
                String searchEd = scan.nextLine();
                int searchStock = 0;
                do{
                    try{
                        System.out.println("Introduzca el stock:");
                        searchStock = scan.nextInt();
                        receivedType = true;
                    }catch (InputMismatchException ex){
                        receivedType = false;
                        System.out.println("No ha introducido un número");
                        scan.nextLine();
                    }
                }while(!(receivedType));
                double searchPrecio = (double) 0;
                do{
                    try{
                        System.out.println("Introduzca un precio:");
                        searchPrecio = scan.nextDouble();
                        receivedType = true;
                    }catch (InputMismatchException ex){
                        receivedType = false;
                        System.out.println("No ha introducido un número");
                        scan.nextLine();
                    }
                }while(!(receivedType));
                Libro searchLibro = new Libro(searchIsbn, searchTitulo, searchAutor, searchEd, searchStock, searchPrecio);
                Integer foundIndex = libros.getPosicion(searchLibro);
                if (!(foundIndex == null))
                    System.out.println("La posición de su libro en la lista es: " + foundIndex);
                break;
            case "4":
                receivedType = false;
                int getIndex = -1;
                do{
                    try{
                        getIndex = scan.nextInt();
                        receivedType = true;
                    }catch (InputMismatchException ex){
                        receivedType = false;
                        System.out.println("No ha introducido un número");
                        scan.nextLine();
                    }
                }while(!(receivedType));
                Libro getLibro = libros.getLibro(getIndex);
                getLibro.Mostrar();
                break;
            case "5":
                libros.mostrarTodo();
                break;  
            case "6":
                System.out.println("Introduzca editorial a buscar:");
                String mostrarEditorial = scan.nextLine();
                libros.mostrarLibros(mostrarEditorial);
                break;
            case "7":
                libros.mostarLibrosSinStock();
                break;
            case "8":
                libros.eraseList();
                break;
            case "9":
                libros.ordenarLibros();
                break;    
            case "10":
                int venderIndex = -1;
                int venderCantidad = 0;
                do{
                    try{
                        System.out.println("Introduzca index del libro a vender:");
                        venderIndex = scan.nextInt();
                        if (venderIndex >= 0)
                            receivedType = true;
                    }catch (InputMismatchException ex){
                        receivedType = false;
                        System.out.println("No ha introducido un número");
                        scan.nextLine();
                    }
                }while(!(receivedType));
                do{
                    try{
                        System.out.println("Introduzca cantidad a vender:");
                        venderCantidad = scan.nextInt();
                        receivedType = true;
                    }catch (InputMismatchException ex){
                        receivedType = false;
                        System.out.println("No ha introducido un número");
                        scan.nextLine();
                    }
                }while(!(receivedType));
                libros.venderLibro(venderIndex, venderCantidad);
                return libros;
        }
        return libros;
    }
    
}
