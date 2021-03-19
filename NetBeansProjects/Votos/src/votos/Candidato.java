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
public class Candidato {
    int ID;
    String nombre;
    String apellidos;
    
    public Candidato(String nombre, String apellidos, int ID){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ID = ID;
        
    }
    public Candidato(){
        
    }
    
    public int getID(){
        return ID;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
}
