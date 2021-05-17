/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Inf2
 */
public class Test_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 6868;
        String msg;
        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected.");
            do {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                msg = reader.readLine();
                if (!msg.equals("TERMINATED"))
                    System.out.println(msg);
                else
                    break;
            } while (true);
            System.out.println("Disconnected from the server");
            
        } catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
 
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
    
}
