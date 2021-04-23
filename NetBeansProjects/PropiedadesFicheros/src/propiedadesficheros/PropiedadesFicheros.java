
package propiedadesficheros;
import java.io.*;
import java.util.*;
/**
 *
 * @author Inf2
 */
public class PropiedadesFicheros {

    static int subFolders = 0;
    
    public static void main(String[] args) {
        File miDir = new File("");
        String[] cmdSplit;
        do {
            String input = getInput("$: ");
            if (input.startsWith("cd")) {
                cmdSplit = input.split(" ");
                miDir = new File(cmdSplit[1]);
                if (miDir.exists() && miDir.isDirectory()) {
                    System.out.println("\033[1mRuta seleccionada\033[0m");
                } else {
                    System.out.println("\033[1mRuta no encontrada\033[0m");
                }
            } else if (input.equals("show content")) {
                switch (getSiNo("Desea ver el peso de los archivos/directorios? (si/no): ")) {
                    case "si":
                        System.out.println("SI");
                        showDirectoryContent(miDir, true);
                        break;
                    case "no":
                        System.out.println("NO");
                        showDirectoryContent(miDir, false);
                        break;
                    default:
                        System.out.println("Se canceló el comando");
                        break;
                }
            } else if (input.equals("exit")) {
                System.exit(0);
            } else if (input.equals("help")) {
                showHelp();
            } else if (input.startsWith("search")) {
                cmdSplit = input.split(" ");
                searchFor(cmdSplit[1].toLowerCase(), miDir, getBool("Desea comprobar subdirectorios? (si/no): "));
            }
        } while (true);
    }
    
    public static void showDirectoryContent(File f, boolean info) {
        System.out.println("\n\n================================");
        System.out.print(f.getName());
        System.out.println(" (" + getSize(f) + ")");
        System.out.print("================================\n");
        try {
            printContent(f, info);
        } catch (Exception ex) {
            System.out.println("\033[1mOcurrió un error. No se pudo mostrar todo el contenido\033[0m");
            subFolders = 0;
        }
    }
    
    public static void printContent(File f, boolean info) {
        if (f.exists()){
            File[] lista = f.listFiles();
            Arrays.sort(lista);
            for (File fileFound : lista) {
                for (int i=0; i<subFolders; i++) {
                    System.out.print("    ");
                }
                if (fileFound.isDirectory()){
                    subFolders += 1;
                    System.out.print("\033[0m" + fileFound.getName());
                    if (info) {
                        System.out.print(" (" + getSize(fileFound) + ")\n");
                    } else {
                        System.out.print("\n");
                    }
                    printContent(fileFound, info);
                    subFolders -= 1;
                } else {
                    System.out.print("\033[1m" + fileFound.getName());
                    if (info) {
                        System.out.print(" (" + getSize(fileFound) + ")" + "\033[0m \n");
                    } else {
                        System.out.print("\n");
                    }
                }
            }
            
        } else {
            System.out.println("\033[1mRuta no encontrada\033[0m");
        }
    }
    
    public static void searchFor(String query, File f, boolean checkSubDir) {
        if (f.exists()) {
            File[] lista = f.listFiles();
            Arrays.sort(lista);
            for (File fileFound : lista) {
                if (fileFound.getName().toLowerCase().contains(query)) {
                    if (fileFound.isDirectory()) {
                        System.out.println("DIRECTORY FOUND : " + fileFound.getName() + " (" + fileFound.getPath() + ")");
                    } else {
                        System.out.println("\033[1mFILE FOUND      : " + fileFound.getName() + " (" + fileFound.getPath() + ")");
                    }
                }
                if (fileFound.isDirectory() && checkSubDir) {
                    searchFor(query, fileFound, checkSubDir);
                }
            }
        } else {
            System.out.println("\033[1mRuta no encontrada\033[0m");
        }
    }
    
    public static String getSiNo(String msg) {
        switch (getInput(msg)) {
            case "si":
                return "si";
            case "no":
                return "no";
            default:
                throw new InputMismatchException("Entrada no válida");
        }
    }
    public static boolean getBool(String msg) {
            switch (getInput(msg)) {
            case "si":
                return true;
            case "no":
                return false;
            default:
                throw new InputMismatchException("Entrada no válida");
            }

    }
    public static void showHelp() {
        System.out.println("\033[1m" +
                "Here you can find a list of commands to use\n" + 
                "\033[1m> help - shows this text\n" +
                "\033[1m> cd [absolute path] - lets you select a directory\n" +
                "\033[1m> show content - shows all files and subdirectories of the selected path\n" +
                "\033[1m> exit - terminates the program\n\033[0m");
    }
    public static String getSize(File f) {
        double bytes = f.length();
        if (bytes >= 1000000000) {
            return (bytes/1000000000) + " Gb"; // GIGABYTES
        } else if (bytes >= 1000000) {
            return (bytes/1000000) + " Mb"; // MEGABYTES
        } else if (bytes >= 1000) {
            return (bytes/1000) + " Kb"; // KILOBYTES
        } else {
            return bytes + " bytes"; // BYTES
        }
    }
    public static String getInput(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
