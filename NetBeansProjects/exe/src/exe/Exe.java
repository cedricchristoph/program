/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe;

import java.io.File;

/**
 *
 * @author 
 */
public class Exe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File origen;
        File destino;
        
        try {
            origen = new File(args[0]);
            destino = new File(args[1]);
            
            origen.renameTo(destino);
            
            System.out.println("Se ha copiado NEEÑo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
}
