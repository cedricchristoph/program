/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local;

import java.util.Scanner;

/**
 *
 * @author Inf2
 */
public class GameClient {

    // Multiplayer varialbes
    static multiplayer.GameClient connection;
    
    
    static Game game;
    static Interpretor interpretor;
    
    
    public static void main(String[] args) {
        interpretor = new Interpretor();
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca IP: ");
        String ip = scan.nextLine();
        System.out.println("Introduzca Puerto: ");
        int port = scan.nextInt();
        connection = new multiplayer.GameClient(ip, port);
        connection.connect();
        
    }
    
}
