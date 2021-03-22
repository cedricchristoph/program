/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposdepersonas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Alumno extends Persona {
    
    private String curso;
    private byte altura;
    private HashMap<String, Integer> notas;
    
    public Alumno(String nombre, String apellidos){
        super(nombre, apellidos);
        notas = new HashMap();
    }
    
    public Alumno(Persona p, String curso, byte altura) {
        super(p);
        this.curso = curso;
        this.altura = altura;
        notas = new HashMap();
    }

    
    // GETTERS

    public String getCurso() {
        return curso;
    }

    public byte getAltura() {
        return altura;
    }

    public HashMap<String, Integer> getNotas() {
        return notas;
    }
    
    // SETTERS

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setAltura(byte altura) {
        this.altura = altura;
    }

    public void setNotas(HashMap<String, Integer> notas) {
        this.notas = notas;
    }
    

    // PUBLIC METHODS
    
    public void addNota(String asignatura, Integer nota){
        if (!(notas.containsKey(asignatura))){
            notas.put(asignatura, nota);
        } else {
            System.out.println("No se pudo añair esta nota, ya que la asignatura ya tiene nota");
        }
    }
    
    public Integer getNota(String asignatura){
        if (notas.containsKey(asignatura)){
            return notas.get(asignatura);
        }
        return null;
    }
    
    public void removeNota(String asignatura) {
        if (notas.containsKey(asignatura)){
            notas.remove(asignatura);
        }
    }
    
    public void mostrarTodo(){
        super.mostrarTodo();
        tc.printRow("CURSANDO", getAltura() + "º " + getCurso());
        System.out.println("NOTAS DISPONIBLES:");
        tc.setCustomSizes(16, 6);
        tc.printHeader("ASIGNATURA", "NOTA");
        int count = 0;
        for (Iterator it=notas.entrySet().iterator(); it.hasNext();){
            count += 1;
            Map.Entry<String, Integer> datos = (Map.Entry<String, Integer>)it.next();
            tc.printRow(datos.getKey(), "" + datos.getValue());
        }
        if (count==0)
            tc.printHeader("No hay notas disponibles");
    }
}
