package tc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TableConstructor tc = new TableConstructor();
        String[] info = new String[0];
        System.out.println("Introduzca la informacón en el siguiente orden:");
        tc.setCustomSizes(4, 20, 20, 30);
        tc.showSectionSeparator(false);
        tc.setLineSeparator("-");
        tc.printHeader("ID", "NOMBRE", "APELLIDO", "EMAIL");
        System.out.println("Para terminar el proceso, introduzca //exit");
        espacio();
        info = getData();
        tc.printHeader("ID", "NOMBRE", "APELLIDO", "EMAIL");
        tc.setLineMarker(".");
        tc.setLineSeparator(".");
        tc.showLineMarker(false);
        tc.showLineSeparator(false);
        tc.showSectionSeparator(false);
        tc.setCustomOrientations("center", "center", "center", "left");
        for (String row : info){
            String[] d = row.split(",");
            tc.printRow(d);
        }
        // TableFiller extienda la clase TableConstructor
        //TableFiller tf = new TableFiller();
        //tf.printTableWithData("persons", 50);
    }

    public static String[] getData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca la cantidad de filas que va a introducir:");
        int amount = scan.nextInt();
        String[] data = new String[amount];
        String unsorted = "";
        System.out.println("Introduzca sus datos de golpe:");
        for (int i=0;i<amount;i++){
            String nextLine = scan.next();
            if (nextLine.equals("COMPLETE")){
                break;
            }
            unsorted = unsorted + nextLine;
        }
        System.out.println(unsorted);
        data = unsorted.split("\",\"");
        System.out.println(Arrays.deepToString(data));
        espacio();
        System.out.println("LECTURA COMPLETA");
        
        return data;
    }
    
    public static void espacio(){
        System.out.println("");
        System.out.println("");
    }
}
