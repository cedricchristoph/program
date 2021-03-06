/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplayer;


import java.net.*;
import java.io.*;
import java.util.Scanner;

import multiplayer.ReadThread;
import multiplayer.WriteThread;

/**
 * This is the chat client program.
 * Type 'bye' to terminte the program.
 *
 * @author www.codejava.net
 */
public class GameClient {
    private String hostname;
    private int port;
    private String userName;
    
    private ReadThread input;
    private WriteThread output;
    
 
    public GameClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }
 
    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);            
            new ReadThread(socket, this).run();
            new WriteThread(socket, this).run();
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Server not running");
        }
 
    }
    
    void setUserName(String userName) {
        this.userName = userName;
    }
 
    String getUserName() {
        return this.userName;
    }
 
    public void connect() {      
        do {
            GameClient client = new GameClient(hostname, port);
            System.out.println("Estableciendo conexión...");
            client.execute();
            System.out.println("\n'retry' / 'exit'");
        } while (!(new Scanner(System.in).nextLine()).equals("exit"));
        System.exit(0);
    }
}
