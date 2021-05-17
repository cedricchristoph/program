/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        if (args.length < 1) return;
 
        int port = 6868;
 
        try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("Server is listening on port " + port);
 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println("Hello! How are you?");
                if (shutdown())
                    writer.println("TERMINATED");
                serverSocket.close();
            }
 
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public static boolean shutdown() {
        System.out.println("Do you want to shutdown? ");
        Scanner scan = new Scanner(System.in);
        if (scan.nextInt() == 1)
            return true;
        return false;
    }
}
