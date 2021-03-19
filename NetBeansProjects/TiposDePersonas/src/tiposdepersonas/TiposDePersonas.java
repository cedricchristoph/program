
package tiposdepersonas;

import java.util.ArrayList;
import java.util.Scanner;

public class TiposDePersonas {

    public static void main(String[] args) {
        ArrayList<Persona> lista = new ArrayList();
        ArrayList<Alumno> alumnos = new ArrayList();
        do {
            menu();
            int uInput = (Integer) read(" _:", "integer");
            switch (uInput){
                case 1:
                    Persona p = new Persona((String) read("Nombre: ", "string"),
                                            (String) read("Apellidos: ", "string"));
                    p.setFechaNacimiento((String) read("Fecha de nacimiento (dd/mm/yyyy): ", "string"));
                    Alumno a = new Alumno(p, (String) read("Curso: ", "string"), (byte) read("Altura: ", "byte"));
                    alumnos.add(a);
                    break;
                case 2:
                    int index = (Integer) read("Index de persna: ", "integer");
                    Alumno person = alumnos.get(index);
                    alumnos = seleccionar(alumnos, person);
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 0:
                    System.out.println("Adiós ;)");
                    System.exit(0);
                default:
                    System.out.println("Entrada no conocida");
            }
        } while (true);
        
    }
    
    private static ArrayList<Alumno> seleccionar(ArrayList<Alumno> lista, Alumno p){
        int uInput = 0;
        lista.remove(p);
        do{
            submenu(p.getNombre() + " " + p.getApellidos());
            uInput = (Integer) read(" _:", "integer");
            switch(uInput){
                case 1:
                    p.setNombre((String) read("Nuevo nombre: ", "string"));
                    break;
                case 2:
                    p.setApellidos((String) read("Nuevos apellidos: ", "string"));
                    break;
                case 3:
                    System.out.println("Nueva dirección:");
                    Direccion d = new Direccion((String) read("Calle: ", "string"),
                                     (String) read("Numero: ", "string"),
                                     (String) read("Provincia: ", "string"),
                                     (Integer) read("Codigo postal: ", "integer"));
                    p.setDireccion(d);
                    break;
                case 4:
                    p.setFechaNacimiento((String) read("Nueva fecha de nacimiento (dd/mm/yyyy): ", "string"));
                    break;
                case 5:
                    p.mostrarTodo();
                    break;
                case 6:
                    p.addNota((String) read("Asignatura: ", "string"), 
                              (Integer) read("Nota: ", "integer"));
                    break;
                case 7:
                    p.removeNota((String) read("Asignatura: ", "string"));
                    break;
                case 8:
                    p.setCurso((String) read("Nuevo curso: ", "string"));
                    break;
                case 9:
                    p.setAltura((byte) read("Nueva altura: ", "byte"));
                case 0:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Entrada no conocida");
                    break;
            }
        }while(uInput!=0);
        lista.add(p);
        return lista;
    }
    
    private static void submenu(String nombreCompleto){
        TableConstructor tc = new TableConstructor();
        tc.setLineSeparator("-");
        tc.setAllSizes(26);
        tc.showSectionSeparator(false);
        tc.printHeader(nombreCompleto);
        tc.setCustomOrientations("left");
        tc.showLineMarker(true);
        tc.printRow("1 - Cambiar nombre");
        tc.printRow("2 - Cambiar apellidos");
        tc.printRow("3 - Añadir/Cambiar direccion");
        tc.printRow("4 - Cambiar fecha de nacimiento");
        tc.printRow("5 - Mostrar todo");
        tc.setCustomOrientations("center");
        tc.printRow("--- DATOS ACADEMICOS ---");
        tc.setCustomOrientations("left");
        tc.printRow("6 - Añadir nota");
        tc.printRow("7 - Eliminar nota");
        tc.printRow("8 - Cambiar curso");
        tc.printRow("9 - Cambiar altura");
        tc.printRow("0 - Volver");
    }
    private static void menu(){
        TableConstructor tc = new TableConstructor();
        tc.setLineSeparator("-");
        tc.setAllSizes(26);
        tc.showSectionSeparator(false);
        tc.printHeader("MENU");
        tc.setCustomOrientations("left");
        tc.showLineMarker(true);
        tc.printRow("1 - Añadir persona");
        tc.printRow("2 - Seleccionar persona");
        tc.printRow("3 - Eliminar persona");
        tc.printRow("4 - Ver lista de personas");
        tc.printRow("0 - Salir");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    public static Object read(String message, String type) {
        /* 
           Cedric's Advanced Reader.
	   VARIABLES:
		-> message: This given variable will be printed on scrren to the user
		-> type: Indicate what type of data your asking for (string, integer, boolean)
         */
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        switch (type) {
            case "string":
                return (String) scan.nextLine();
            case "integer":
                boolean correctInput = false;
                int num = 0;
                do {
                    try {
                        Scanner lector = new Scanner(System.in);
                        num = lector.nextInt();
                        correctInput = true;
                    } catch (Exception ex) {
                        System.out.println("Entrada no válida, inténtelo de nuevo");
                        System.out.println(message);
                    }
                } while (!(correctInput));
                return num;
            
            case "boolean":
                String input = scan.nextLine();
                switch (input) {
                    case "si":
                        return (boolean) true;
                    case "yes":
                        return (boolean) true;
                    case "1":
                        return (boolean) true;
                    case "no":
                        return (boolean) false;
                    case "0":
                        return (boolean) false;                    
                    default:
                        System.out.println("ERROR: You have entered no valid value to convert to boolean");
                        return (boolean) false;
                }
            case "byte":
                boolean correctByte = false;
                byte b = 0;
                do {
                    try {
                        Scanner lector = new Scanner(System.in);
                        b = lector.nextByte();
                        correctByte = true;
                    } catch (Exception ex) {
                        System.out.println("Entrada no válida, inténtelo de nuevo");
                        System.out.println(message);
                    }
                } while (!(correctByte));
                return b;
            default:
                System.out.println("ERROR: You have not correctly specified which type of data you are looking for");
                return (String) "";
        }
    }
}
