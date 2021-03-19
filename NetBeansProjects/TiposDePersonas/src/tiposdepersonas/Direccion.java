/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposdepersonas;

/**
 *
 * @author Inf2
 */
public class Direccion {
    String calle;
    String numero;
    String provincia;
    Integer codigoPostal;
    
    // CONSTRUCTORS
    
    public Direccion(){
        calle = "";
        numero = "";
        provincia = "";
        codigoPostal = 0;
    }
    
    public Direccion (String calle, String numero, String provincia, Integer codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
    }

    // GETTERS

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getProvincia() {
        return provincia;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }
    
    // SETTERS

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    // PUBLIC METHODS
    
    public boolean exists(){
        if (!(calle.isEmpty()) && !(numero.isEmpty()) && !(provincia.isEmpty()) && (codigoPostal != 0))
            return true;
        return false;
    }
}
