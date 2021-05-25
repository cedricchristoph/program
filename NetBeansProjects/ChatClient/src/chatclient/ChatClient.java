/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.net.*;
import java.io.*;
import java.util.Scanner;

import chatclient.ReadThread;
import chatclient.WriteThread;

public class ChatClient {
    private String hostname;
    private int port;
    private String userName;
 
    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }
 
    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);
 
            System.out.println("Connected");
 
            new ReadThread(socket, this).start();
            new WriteThread(socket, this).start();
  
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
 
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("IP: ");
        String hostname = scan.nextLine();
        System.out.println("Port: ");
        int port = Integer.parseInt(scan.nextLine());
        ChatClient client = new ChatClient(hostname, port);
        client.execute();
    }
}
