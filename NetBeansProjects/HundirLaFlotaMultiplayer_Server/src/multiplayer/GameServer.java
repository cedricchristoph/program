/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplayer;


import Game.Game;
import Game.Interpretor;
import Game.Playground;
import java.io.*;
import java.net.*;
import java.util.*;
 
import game.*;

/**
 * This is the chat server program.
 * Press Ctrl + C to terminate the program.
 *
 * @author www.codejava.net
 */
public class GameServer {
    
    public static String version = "1.0.0";
    public static String info = "################ GAME SERVER ################\n" +
                                "# VERSION: " + version + "                            #\n" +
                                "# INSTRUCTIONS:                             #\n" +
                                "#  > Check your IP and Port settings        #\n" +
                                "#     - Type 'change port' to change port   #\n" +
                                "#  > Start the server by typing 'start'     #\n" +
                                "#  > Stop the server by typing 'shutdown'   #\n" +
                                "#  > 'accept' to let a player join          #\n" +
                                "#############################################\n\n";
    InetAddress ip;

    public final int HOST = 0, GUEST = 1, ALL = 2;
    
    /**
     * Connection variables
     */
    private static int port;
    private Set<String> userNames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();
    private String status;
    private final ServerSocket serverSocket;
    
    private boolean isConnected;
    private HostThread host;
    private UserThread guest;
    
    
    /**
     * Game variables
     */
    private Game game;
    private Interpretor interpretor;
    

    public GameServer(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
        isConnected = false;
    }
 
    public void execute() throws IOException {
            ip = InetAddress.getLocalHost();
            System.out.println("\n[STATUS]: Up");
            System.out.println("\nIP: " + ip + ":" + serverSocket.getLocalPort());
            isConnected = true;
            while(true){
                String cmd = getString("$: ");
                switch(cmd) {
                    case "accept":
                        if (isConnected) {
                            System.out.println("Waiting for users to connect...");
                            Socket socket = serverSocket.accept();
                            if (userNames.isEmpty()) {
                                host = new HostThread(socket, this);
                                host.start();
                                System.out.println("Host has connected to the server");
                            } else {
                                guest = new UserThread(socket, this);
                                guest.start();
                                System.out.println("User has connected to the server");
                            }
                        } else {
                            System.out.println("No server running");
                        }
                        break;
                    case "stop":
                        stopGame();
                        break;
                    case "shutdown":
                        stopGame();
                        break;
                    case "start game":
                        startGame();
                        break;
                    case "exit":
                        if (isConnected)
                            stopGame();
                        System.exit(0);
                        break;
                    case "change port":
                        System.out.print("Introduzca nuevo puerto: ");
                        port = getInt();
                        System.out.println("El puerto será actualizando en cuanto se reinicie el servidor");
                        break;
                    case "restart":
                        stopGame();
                        System.out.println("[STATUS]: Starting...");
                        GameServer server = new GameServer(port);
                        server.execute();
                    default:
                        if (isConnected)
                            broadcast(cmd, ALL, true);
                        else 
                            System.out.println("No server running");
                }
            }
    }

    public void startGame() {
        // REQUEST Playgrounds from players
        try {
            Playground one = new Playground("Player One", Interpretor.convert(host.requestPlayground()));
            one.toString();
        } catch (Exception e) {
            System.out.println("An unknown error ocurred");
        } 
        System.out.println("Playground uno creado.");
        
        stopGame();
        //Playground two = new Playground("Player Two", interpretor.convert(guest.requestPlayground()));
        
        
    }
    
    public void stopGame() {
        if (isConnected) {
            try {
            
                broadcast("[STATUS]: Shutting down...", ALL, true);
                host.
                serverSocket.close();
             
            } catch (IOException e) {
            
            } finally {
                isConnected = false;
                System.out.println("\n[STATUS]: Down");
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(info);
        port = 8686;
        System.out.println("[STATUS]: Starting...");
        try {
            GameServer server = new GameServer(port);
            server.execute();
        } catch (IOException e) {
            System.out.println("An error ocurred trying to initiate the server.");
            if (e.getMessage().contains("already")) {
                System.out.println("Maybe the port you have entered is already being used by another software!");
            }
        } finally {
            System.out.println("\n[STATUS]: Down");
        }
       
    }

    public static Integer getInt() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    
    public String getString(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    /**
     * Delivers a message from one user to others (broadcasting)
     */
    void broadcast(String message, int destination, boolean show) {
        
        try {
            switch (destination) {
            case HOST:
                if (show)
                    System.out.println("<Host received> : " + message);
                host.sendMessage(message);
                break;
            case GUEST:
                if (show)
                    System.out.println("<Guest received> : " + message);
                guest.sendMessage(message);
                break;
            default:
                broadcast(message, HOST, false);
                broadcast(message, GUEST, false);
                System.out.println("<Everyone received> : " + message);
                break;
            }
        } catch (NullPointerException e) {
                
        } catch (Exception e) {
            System.out.println("An error ocurred. The message may have been not received by all users.");
            System.out.println("Error: " + e.getMessage());
        }
    }
 
    /**
     * Stores username of the newly connected client.
     */
    void addUserName(String userName) {
        userNames.add(userName);
    }
 
    /**
     * When a client is disconneted, removes the associated username and UserThread
     */
    void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }
 
    Set<String> getUserNames() {
        return this.userNames;
    }
 
    /**
     * Returns true if there are other users connected (not count the currently connected user)
     */
    boolean hasUsers() {
        return !this.userNames.isEmpty();
    }
    
    public String getStatus() {
        return status;
    }
}