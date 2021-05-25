/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.util.Scanner;

/**
 *
 * @author Inf2
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Juego partida = new Juego(Juego.PRINCIPIANTE);
        partida.init();
        do {
            int x;
            int y;
            //partida.show();
            partida.showDevMap();
            System.out.print("Introduzca X: ");
            x = getInt();
            System.out.print("Introduzca Y: ");
            y = getInt();
            System.out.println(x + " "+ y);
            partida.select(x, y);
            System.out.println(partida.getMinasAlrededor(x, y));
            System.out.println("\n\n");
        } while (!(partida.hasFinished));
        
        System.out.println("¡Le has dado a una mina!");
    }
    
    public static int getInt() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    
}
