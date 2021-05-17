/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplayer;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * This thread handles connection for each connected client, so the server
 * can handle multiple clients at the same time.
 *
 * @author www.codejava.net
 */
public class HostThread extends Thread {
    private Socket socket;
    private GameServer server;
    private PrintWriter writer;
    private Integer player = null;
    
    
    public HostThread(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;
    }
    
 
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
 
            server.broadcast("Welcome player! You are the host.", server.HOST, true);
            
            String serverMessage;
            String clientMessage;
 
            do {
                clientMessage = reader.readLine();
                serverMessage = "[" + player + "]: " + clientMessage;
                server.broadcast(serverMessage, server.GUEST, true);
               
            } while (!clientMessage.equals("leave"));
 
            socket.close();
 
            server.broadcast("Player " + player + " quitted the server.", server.ALL, true);
            
            
        } catch (IOException ex) {
            System.out.println("Connection lost with host"); 
        }
    }
 
    /**
     * Sends a list of online users to the newly connected user.
     */
    void printUsers() {
        if (server.hasUsers()) {
            writer.println("Connected users: " + server.getUserNames());
        } else {
            writer.println("No other users connected");
        }
    }
 
    /**
     * Sends a message to the client.
     */
    void sendMessage(String message) {
        writer.println(message);
    }
    
    String requestPlayground() {
        String playground = "";
        try {
            writer.println("Please send your playground. Line by line. The field must be 8x8 so the structure must be like following:");
            writer.println("S | S |   |   |   |   |   |   |");
            writer.println("  |   |   |   |   |   |   |   |");
            writer.println("  | S |   |   |   |   |   |   |");
            writer.println("  | S |   |   |   |   |   |   |");
            writer.println("  | S |   | S | S | S |   |   |");
            writer.println("  | S |   |   |   |   |   |   |");
            writer.println("  |   |   |   |   |   |   |   |");
            writer.println("  |   |   |   |   |   |   |   |");
        
            int linesReceived = 0;
            
            do {
                InputStream input;
                try {
                    input = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    String receivedLine = reader.readLine();
                    linesReceived++;
                    playground += receivedLine + "\n";
                } catch (IOException ex) {
                    Logger.getLogger(UserThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (!(linesReceived==8));
        } catch (Exception e) {
            System.out.println("An error ocurred with the user thread. Connection was lost.");
        } finally {
            return playground;    
        }
        
    }
}