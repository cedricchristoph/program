package tiposdepersonas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Profesor extends Persona{
    
    private String materiaImpartida;
    private HashMap<String, Integer> cursos;
    
    // CONSTRUCTORS
    
    public Profesor (Persona p, String materiaImpartida) {
        super(p);
        this.materiaImpartida = materiaImpartida;
        cursos = new HashMap();
        //tc = new TableConstructor();
    }
    
    // GETTERS
    
    public String getMateriaImpartida() {
        return materiaImpartida;
    }

    public HashMap<String, Integer> getCursos() {
        return cursos;
    }
    
    // SETTERS

    public void setMateriaImpartida(String materiaImpartida) {
        this.materiaImpartida = materiaImpartida;
    }

    public void setCursos(HashMap<String, Integer> cursos) {
        this.cursos = cursos;
    }

    
    // PUBLIC METHODS
    
    public void mostrarTodo(){
        super.mostrarTodo();
        tc.printHeader("Materia impartida", "Curso y altura");
        for (Iterator it=cursos.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, Integer> datos = (Map.Entry<String, Integer>)it.next();
            tc.printRow(materiaImpartida, datos.getValue() + "º " + datos.getKey());
        }
    }
    
    public void addCurso(String curso, Integer altura){
        cursos.put(curso, altura);
    }
    
    public void removeCurso(String curso) {
        if (cursos.containsKey(curso))
            cursos.remove(curso);
    }
}
