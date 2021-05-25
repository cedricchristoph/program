/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author Inf2
 */
public class Mina extends Celda {

    public Mina () 
    {
        super();
    }
    
    @Override
    public boolean esMina() 
    {
        return true;
    }
    
}
