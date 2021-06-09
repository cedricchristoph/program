/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *
 * CEDRIC CHRISTOPH
 * 
 */
public class User {
    
    // VARIABLES & CONSTANTS
    public static final int ADMIN = 1;
    public static final int STANDARD = 0;
    
    protected String username;
    protected String nombre;
    protected String apellidos;
    protected int nivelAcceso;
    private String pwd;
    
    // CONSTRUCTORS
    
    public User(String username, String nombre, String apellidos, int nivelAcceso, String pwd) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nivelAcceso = nivelAcceso;
        this.pwd = pwd;
    }
    public User(String username, String nombre, String apellidos, int nivelAcceso) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nivelAcceso = nivelAcceso;
    }
    public User(String username, int nivelAcceso) {
        this.username = username;
        this.nivelAcceso = nivelAcceso;
    }
    
    // GETTERS
    public int USER_ADMIN() {
        return ADMIN;
    }
    public int USER_STANDARD() {
        return STANDARD;
    }
    public String getUsername() {
        return username;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public int getNivelAcceso() {
        return nivelAcceso;
    }
    public String getPwd() {
        return pwd;
    }
    
    // SETTERS
    public void setUsername(String username) {
        this.username = username;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setNivelAcceso(int nivelAcceso) {
        switch (nivelAcceso) {
            case 0:
                this.nivelAcceso = STANDARD;
                break;
            case 1:
                this.nivelAcceso = ADMIN;
                break;
            default:
                this.nivelAcceso = STANDARD;
        }
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    // PUBLIC METHODS
    public void show() {
        System.out.println("USERNAME: " + username);
        System.out.println("NAME: " + nombre);
        System.out.println("SURNAME: " + apellidos);
        System.out.println("NIVEL: " + nivelAcceso);
        System.out.println("PWD: " + pwd);
    }
    
    
    // PRIVATE METHODS
    
}
