/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream_fichero;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Inf2
 */
public class Stream_fichero {

    static FileInputStream reader;
    static FileOutputStream writer;
    static int buffer[];
    String string = "";
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            writer = new FileOutputStream(new File("copia.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        while (scan.hasNext()) {
            writer.write
        }
    }
    
}
