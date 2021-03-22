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
    }
    
    public Profesor (Persona p, String materiaImpartida, HashMap<String, Integer> cursos) {
        super(p);
        this.materiaImpartida = materiaImpartida;
        this.cursos = cursos;
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
        tc.printRow("MATERIA IMPARTIDA", materiaImpartida);
        int count = 0;
        if (!(cursos.isEmpty())){
            for (Iterator it=cursos.entrySet().iterator(); it.hasNext();){
                Map.Entry<String, Integer> datos = (Map.Entry<String, Integer>)it.next();
                if (count==0){
                    tc.printRow("CURSOS", datos.getValue() + "º " + datos.getKey());
                    count += 1;
                    continue;
                }
                tc.printRow("", datos.getValue() + "º " + datos.getKey());
            }
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
