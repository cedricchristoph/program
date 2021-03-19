/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votos;

/**
 *
 * @author Inf2
 */
public class Voto {
    String nombre;
    String apellidos;
    int valor;
    
    public Voto(String nombre, String apellidos, int valor){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.valor = valor;
    }
    public Voto(int valor){
        nombre = "Persona";
        apellidos = "Random";
        this.valor = valor;
    }

    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public int getVoto(){
        return valor;
    }
}
