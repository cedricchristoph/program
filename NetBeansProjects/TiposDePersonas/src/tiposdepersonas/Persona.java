/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposdepersonas;

import java.util.regex.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

/**
 *
 * @author Inf2
 */
public class Persona {
    private TableConstructor tc;
    protected String nombre;
    protected String apellidos;
    protected String fechaNacimiento;
    protected String dni;
    protected Direccion direccion;
    private final String datePattern = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
    
    // CONSTRUCTORS
    
    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = "not available";
        this.dni = "not available";
        direccion = new Direccion();
        tc = new TableConstructor();
    }
    
    public Persona(String nombre, String apellidos, String fechaNacimiento, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        direccion = new Direccion();
        tc = new TableConstructor();
        if (matches(fechaNacimiento, datePattern)) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            this.fechaNacimiento = "not available";
        }
    }

    public Persona(String nombre, String apellidos, Direccion direccion) {
        this.tc = new TableConstructor();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public Persona(String nombre, String apellidos, String fechaNacimiento, Direccion direccion) {
        this.tc = new TableConstructor();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        if (matches(fechaNacimiento, datePattern)) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            this.fechaNacimiento = "not available";
        }
    }

    public Persona(String nombre, String apellidos, String fechaNacimiento, String dni, Direccion direccion) {
        this.tc = new TableConstructor();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        if (matches(fechaNacimiento, datePattern)) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            this.fechaNacimiento = "not available";
        }
    }
    
    public Persona(Persona p){
        this.nombre = p.getNombre();
        this.apellidos = p.getApellidos();
        this.fechaNacimiento = p.getFechaNacimiento();
        this.dni = p.getDni();
        this.direccion = p.getDireccion();
        this.tc = new TableConstructor();
    }
    // GENERAL GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }
    
    public Direccion getDireccion() {
        return direccion;
    }
    
    // GENERAL SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public void setDireccion (Direccion d) {
        this.direccion = d;
    }
    
    // PUBLIC METHODS
    
    public void mostrarTodo(){
        tc.setLineMarker("-");
        tc.setLineSeparator("-");
        if (direccion.exists()) {
            tc.setCustomSizes(20, 20, 18, 16, 18, 36);
            tc.printHeader("NOMBRE", "APELLIDOS", "FECHA DE NACIMIENTO", "EDAD ACTUAL", "DNI", "DIRECCION");
            tc.setCustomOrientations("left", "left", "center", "center", "left", "left");
            tc.printRow(getNombre(), getApellidos(), getFechaNacimiento(), "" + getEdad(), getDni(),
                        direccion.getCalle() + " " + direccion.getNumero() + ", " + direccion.getProvincia());
        } else {
            tc.setCustomSizes(20, 20, 18, 16, 18);
            tc.printHeader("NOMBRE", "APELLIDOS", "FECHA DE NACIMIENTO", "EDAD ACTUAL", "DNI");
            tc.setCustomOrientations("left", "left", "center", "center", "left");
            tc.printRow(getNombre(), getApellidos(), getFechaNacimiento(), "" + getEdad(), getDni());
        }
    }
    
    public Integer getEdad(){
        Integer edad = 0;
        if (!(fechaNacimiento.equals("not available"))){
            String[] fecha = fechaNacimiento.split("/");
            int day = Integer.parseInt(fecha[0]);
            int month = Integer.parseInt(fecha[1]);
            int year = Integer.parseInt(fecha[2]);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");  
            String[] now = dtf.format(LocalDateTime.now()).split("/");
            int nowDay = Integer.parseInt(now[0]);
            int nowMonth = Integer.parseInt(now[1]);
            int nowYear = Integer.parseInt(now[2]);
            edad = nowYear - year;
            if ((month - nowMonth)>0){
                edad -= 1;
            } else if ((month - nowMonth)==0){
                if ((day - nowDay)>0) 
                    edad -= 1;         
                
            }
            return edad;
        }
        return null;
    }
    
    // PRIVATE METHODS
    
    private boolean matches(String input, String pattern){
        System.out.println("matching...");
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        if (m.matches()) {
            return true;
        }
            return false;
    }
}
