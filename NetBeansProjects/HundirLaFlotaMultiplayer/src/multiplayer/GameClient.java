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
            System.out.println("Estableciendo conexión...");
            
            input = new ReadThread(socket, this);
            output = new WriteThread(socket, this);
            
            input.run();
            output.run();
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
 
    }
 
    void setUserName(String userName) {
        this.userName = userName;
    }
 
    String getUserName() {
        return this.userName;
    }
 
    public void connect() {      
        GameClient client = new GameClient(hostname, port);
        client.execute();
    }
}
