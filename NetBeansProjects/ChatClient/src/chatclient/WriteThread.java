/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.io.*;
import java.net.*;
import java.util.Scanner;
 
/**
 * This thread is responsible for reading user's input and send it
 * to the server.
 * It runs in an infinite loop until the user types 'bye' to quit.
 *
 * @author www.codejava.net
 */
public class WriteThread extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private ChatClient client;
 
    public WriteThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;
 
        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
 
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduzca su nombre: ");
        String userName = scan.nextLine();
        client.setUserName(userName);
        writer.println(userName);
 
        String text;
 
        do {
            System.out.print(userName + " >>: ");
            text = scan.nextLine();
            writer.println(text);
            
        } while (!text.equals("disconnect"));
 
        try {
            socket.close();
        } catch (IOException ex) {
 
            System.out.println("Error sending message: " + ex.getMessage());
        }
    }
}
