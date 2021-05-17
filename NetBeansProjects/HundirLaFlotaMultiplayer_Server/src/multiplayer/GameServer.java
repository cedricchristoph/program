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
    
    public final int HOST = 0, GUEST = 1, ALL = 2;
    
    /**
     * Connection variables
     */
    private String ip;
    private static int port;
    private Set<String> userNames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();
    private String status;
    private final ServerSocket serverSocket;
    
    private boolean isConnected;
    private UserThread host;
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
        
            System.out.println("\n[STATUS]: Up");
            System.out.println("\nIP: " + serverSocket.getLocalSocketAddress());
            System.out.println("Port: " + serverSocket.getLocalPort());
            isConnected = true;
            while(true){
                String cmd = getString("$: ");
                switch(cmd) {
                    case "accept":
                        if (isConnected) {
                            System.out.println("Waiting for users to connect...");
                            Socket socket = serverSocket.accept();
                            if (userNames.isEmpty()) {
                                host = new UserThread(socket, this);
                                host.start();
                                System.out.println("HOST_CONNECTED");
                            } else {
                                guest = new UserThread(socket, this);
                                guest.start();
                                System.out.println("USER_CONNECTED");
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
                    case "ip":
                        System.out.print("Introduzca nuevo puerto: ");
                        port = getInt();
                        System.out.println("Puerto actualizado. Servidor tiene que reiniciar para hacer efecto.");
                        break;
                    case "restart":
                        stopGame();
                        System.out.println("[STATUS]: Starting...");
                        GameServer server = new GameServer(port);
                        server.execute();
                    default:
                        if (isConnected)
                            broadcast(cmd, ALL);
                        else 
                            System.out.println("No server running");
                }
            }
    }

    public void startGame() {
        interpretor = new Interpretor();
        // REQUEST Playgrounds from players
        try {
            Playground one = new Playground("Player One", interpretor.convert(host.requestPlayground()));
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
            
                broadcast("Server is shutting down...", ALL);
                serverSocket.close();
             
            } catch (IOException e) {
            
            } finally {
                isConnected = false;
                System.out.println("\n[STATUS]: Down");
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.print("To start the game server please enter a port: ");
        port = getInt();
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
    void broadcast(String message, int destination) {
        try {
            switch (destination) {
            case HOST:
                host.sendMessage(message);
                break;
            case GUEST:
                guest.sendMessage(message);
                break;
            default:
                broadcast(message, HOST);
                broadcast(message, GUEST);
                System.out.println("GLOBAL MESSAGE: " + message);
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