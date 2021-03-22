
package tiposdepersonas;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TiposDePersonas {

    public static void main(String[] args) {
        ArrayList<Persona> lista = new ArrayList();
        ArrayList<Alumno> alumnos = new ArrayList();
        ArrayList<Profesor> profesores = new ArrayList();
        
        alumnos = (ArrayList<Alumno>)loadData("datos.txt", "alumnos");
        profesores = (ArrayList<Profesor>)loadData("datos.txt", "profesores");
        
        do {
            menu();
            int uInput = (Integer) read(" _:", "integer");
            switch (uInput){
                case 1:
                    String eleccion = "";
                    do{
                        eleccion = (String) read("Alumno o profesor?:", "string", "alumno", "profesor");
                        break;
                    }while (true);
                    Persona p = new Persona((String) read("Nombre: ", "string"),
                                            (String) read("Apellidos: ", "string"));
                    p.setFechaNacimiento((String) read("Fecha de nacimiento (dd/mm/yyyy): ", "string"));
                    switch (eleccion){
                        case "alumno":
                            Alumno a = new Alumno(p, (String) read("Curso: ", "string"), (byte) read("Altura: ", "byte"));
                            alumnos.add(a);
                            System.out.println("Alumno añadido");
                            break;
                        case "profesor":
                            Profesor pro = new Profesor(p, (String) read("Materia impartida: ", "string"));
                            profesores.add(pro);
                            System.out.println("Profesor añadido");
                            break;
                        default:
                            System.out.println("Error with election");
                            break;
                    }
                    break;
                case 2:
                    do{
                        eleccion = (String) read("Alumno o profesor?:", "string", "alumno", "profesor");
                        break;
                    }while (true);
                    int index = (Integer) read("Index de en lista: ", "integer");
                    try{
                        switch (eleccion){
                        case "alumno":
                            Alumno person = alumnos.get(index);
                            alumnos = seleccionarAlumno(alumnos, person);
                            break;
                        case "profesor":
                            Profesor pro = profesores.get(index);
                            profesores = seleccionarProfesor(profesores, pro);
                            break;
                        }
                    }catch(IndexOutOfBoundsException ex){
                        System.out.println("ERROR: No existe ningún registro en esa posición");
                    }
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println("ALUMNOS:");
                    int count = 0;
                    for (Alumno a : alumnos){
                        System.out.println(" (" + count + ") : " + a.getNombre() + " " + a.getApellidos());
                        count+=1;
                    }
                    if (count==0)
                        System.out.println("No hay ningún alumno\n");
                    System.out.println("\nPROFESORES:");
                    count = 0;
                    for (Profesor profe : profesores){
                        System.out.println(" (" + count + ") : " + profe.getNombre() + " " + profe.getApellidos());
                        count+=1;
                    }
                    if (count==0)
                        System.out.println("No hay ningún profesor\n");
                    
                    break;
                case 0:
                    saveData(alumnos, profesores);
                    System.out.println("Adiós ;)");
                    System.exit(0);
                default:
                    System.out.println("Entrada no conocida");
            }
        } while (true);
        
    }
     private static ArrayList<Profesor> seleccionarProfesor(ArrayList<Profesor> lista, Profesor p){
        int uInput = 0;
        lista.remove(p);
        do{
            submenuProfe(p.getNombre() + " " + p.getApellidos());
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
                    p.setDni((String) read("Nuevo DNI: ", "string"));
                    break;
                case 6:
                    p.mostrarTodo();
                    break;
                case 7:
                    p.setMateriaImpartida((String) read("Nueva materia impartida: ", "string"));
                    break;
                case 8:
                    p.addCurso((String) read("Asignatura: ", "string"), (Integer) read("Altura: ", "integer"));
                    break;
                case 9:
                    p.removeCurso((String) read("Curso: ", "string"));
                    break;
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
     
    private static ArrayList<Alumno> seleccionarAlumno(ArrayList<Alumno> lista, Alumno p){
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
                    p.setDni((String) read("Nuevo DNI: ", "string"));
                    break;
                case 6:
                    p.mostrarTodo();
                    break;
                case 7:
                    p.addNota((String) read("Asignatura: ", "string"), 
                              (Integer) read("Nota: ", "integer"));
                    break;
                case 8:
                    p.removeNota((String) read("Asignatura: ", "string"));
                    break;
                case 9:
                    p.setCurso((String) read("Nuevo curso: ", "string"));
                    break;
                case 10:
                    p.setAltura((byte) read("Nueva altura: ", "byte"));
                    break;
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
        tc.printRow(" 1 - Cambiar nombre");
        tc.printRow(" 2 - Cambiar apellidos");
        tc.printRow(" 3 - Añadir/Cambiar direccion");
        tc.printRow(" 4 - Cambiar fecha de nacimiento");
        tc.printRow(" 5 - Cambiar DNI");
        tc.printRow(" 6 - Mostrar todo");
        tc.setCustomOrientations("center");
        tc.printRow("---- DATOS ACADEMICOS ----");
        tc.setCustomOrientations("left");
        tc.printRow(" 7 - Añadir nota");
        tc.printRow(" 8 - Eliminar nota");
        tc.printRow(" 9 - Cambiar curso");
        tc.printRow("10 - Cambiar altura");
        tc.printRow(" 0 <-- Volver");
    }
    
    private static void submenuProfe(String nombreCompleto){
        TableConstructor tc = new TableConstructor();
        tc.setLineSeparator("-");
        tc.setAllSizes(26);
        tc.showSectionSeparator(false);
        tc.printHeader(nombreCompleto);
        tc.setCustomOrientations("left");
        tc.showLineMarker(true);
        tc.printRow(" 1 - Cambiar nombre");
        tc.printRow(" 2 - Cambiar apellidos");
        tc.printRow(" 3 - Añadir/Cambiar direccion");
        tc.printRow(" 4 - Cambiar fecha de nacimiento");
        tc.printRow(" 5 - Cambiar DNI");
        tc.printRow(" 6 - Mostrar todo");
        tc.setCustomOrientations("center");
        tc.printRow("---- DATOS PROFESOR ----");
        tc.setCustomOrientations("left");
        tc.printRow(" 7 - Cambiar materia impartida");
        tc.printRow(" 8 - Añadir curso");
        tc.printRow(" 9 - Eliminar curso");
        tc.printRow(" 0 <-- Volver");
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
        tc.printRow("0 - Guardar y salir");
    }
    
    private static ArrayList loadData(String filename, String listValue){
        TableConstructor tc = new TableConstructor();
        tc.showSectionSeparator(false);
        tc.setLineMarker("·");
        tc.setLineSeparator("·");
        tc.setAllSizes(40);
        ArrayList lista = new ArrayList();
        int line = 0;
        // <!START alumnos !> <!FINISH alumnos !>
        switch(listValue){
            
            case "alumnos":
                tc.printHeader("LOADING...");
                tc.showLineMarker(false);
                tc.showLineSeparator(false);
                try {
                    File myObj = new File("C:\\Users\\Inf2\\Documents\\NetBeansProjects\\TiposDePersonas\\src\\tiposdepersonas\\datos.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = "";
                        do {
                            data = myReader.nextLine();
                        } while (!(data.contains("<!START alumnos !>")) && myReader.hasNextLine());
                        while (myReader.hasNextLine() && !(data.contains("<!FINISH"))) {
                            data = myReader.nextLine();                           
                            String[] info = data.split(",");                         
                            try{
                                Persona p = new Persona(info[0], info[1], info[2], info[3]);
                                Direccion d = new Direccion(info[4],info[5],info[6],Integer.parseInt(info[7]));
                                p.setDireccion(d);
                                Alumno a = new Alumno(p,info[8], Byte.parseByte(info[9]));
                                lista.add(a);
                                line += 1;
                            }catch (Exception ex){
                                
                            }   
                        }
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("No se encontró el fichero");
                    e.printStackTrace();
                } catch (Exception ex){
                    System.out.println(ex);
                }
                break;
            case "profesores":
                line = 0;
                try {
                    File myObj = new File("C:\\Users\\Inf2\\Documents\\NetBeansProjects\\TiposDePersonas\\src\\tiposdepersonas\\datos.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = "";
                        String curso = "";
                        Integer altura = 0;
                        HashMap<String, Integer> cursos = new HashMap();
                        do {
                            data = myReader.nextLine();
                        } while (!(data.contains("<!START profesores !>")) && myReader.hasNextLine());
                        do {
                            data = myReader.nextLine();
                            if (data.equals("<!FINISH profesores !>"))
                                break;
                            String[] info = data.split(",");
                            String[] listCursos = info[9].split("\\|");
                            for(String x : listCursos){
                                String[] splitted = x.split("%");
                                curso = splitted[0];
                                altura = Integer.parseInt(splitted[1]);
                                cursos.put(curso, altura);
                            }
                            Persona p = new Persona(info[0], info[1], info[2], info[3]);
                            Direccion d = new Direccion(info[4],info[5],info[6],Integer.parseInt(info[7]));
                            p.setDireccion(d);
                            Profesor profe = new Profesor(p,info[8],cursos);
                            lista.add(profe);
                            line += 1;
                        } while (true);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                } catch (IndexOutOfBoundsException ex) {
                    
                }
                break;
        }
        return lista;
    }
    
    private static void saveData(ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores){
        System.out.println("Saving... please wait...");
        BufferedWriter writer = null;

            try {
            writer = new BufferedWriter(new FileWriter("C:\\Users\\Inf2\\Documents\\NetBeansProjects\\TiposDePersonas\\src\\tiposdepersonas\\datos.txt"));
            writer.write("<!START alumnos !>\n");
            for (Alumno alumno : alumnos){
                Direccion d = alumno.getDireccion();
                String dataline = alumno.getNombre() + "," +
                                  alumno.getApellidos() + "," +
                                  alumno.getFechaNacimiento() + "," +
                                  alumno.getDni() + "," +
                                  d.getCalle() + "," +
                                  d.getNumero() + "," +
                                  d.getProvincia() + "," +
                                  d.getCodigoPostal() + "," +
                                  alumno.getCurso() + "," +
                                  alumno.getAltura() + "\n";
                writer.write(dataline);
            }
            writer.write("<!FINISH alumnos !>");
            writer.write("\n");
            writer.write("<!START profesores !>\n");
            for (Profesor profe : profesores){
                Direccion d = profe.getDireccion();
                HashMap<String,Integer> cursos = profe.getCursos();
                String infoCursos = "";
                for (Iterator it=cursos.entrySet().iterator(); it.hasNext();){
                    Map.Entry<String, Integer> datos = (Map.Entry<String, Integer>)it.next();
                    infoCursos = infoCursos + datos.getKey() + "%" + datos.getValue() + "|";
                }
                String dataline = profe.getNombre() + "," +
                                  profe.getApellidos() + "," +
                                  profe.getFechaNacimiento() + "," +
                                  profe.getDni() + "," +
                                  d.getCalle() + "," +
                                  d.getNumero() + "," +
                                  d.getProvincia() + "," +
                                  d.getCodigoPostal() + "," +
                                  profe.getMateriaImpartida() + "," +
                                  infoCursos + "\n";
                writer.write(dataline);
            }
            writer.write("<!FINISH profesores !>\n");
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }    
    
    
    
 
    
    
   
    public static Object read(String message, String type, String... enumeration) {
        /* 
           Cedric's Advanced Reader.
	   VARIABLES:
		-> message: This given variable will be printed on scrren to the user
		-> type: Indicate what type of data your asking for (string, integer, boolean)
         */
        boolean check = false;
        try{
            String test = enumeration[0];
            check = true;
        } catch (Exception ex){
            check = false;
        }
        Scanner scan = new Scanner(System.in);
        
        switch (type) {
            case "string":
                if (!(check)){
                    System.out.println(message);
                    return (String) scan.nextLine();
                }
                do {
                    System.out.println(message);
                    String entrada = scan.nextLine();
                    for (int i=0; i<enumeration.length; i++){
                        if (enumeration[i].equals(entrada))
                                return entrada;
                    }   
                }while (true);
                
            case "integer":
                boolean correctInput = false;
                int num = 0;
                System.out.println(message);
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
                System.out.println(message);
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
                System.out.println(message);
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
