/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Inf2
 */
public class Votos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Voto> votos = new ArrayList();
        Candidato[] candidatos = new Candidato[12];
        int uInput = 0;
        
        TableBuilder tb = new TableBuilder(40);
        tb.printHeaders("ELECCIONES");
        tb.printMultiLineElement("Los 12 candidatos están listos para ser elegidos. Los candidatos se eligen a través de los siguientes números:");
        /*System.out.println("=============== ELECCIONES ===============");
        System.out.println("  Los 12 candidatos están listos para");
        System.out.println("  ser elegidos. Los candidatos se eligen");
        System.out.println("  a través de los siguientes números:");
        System.out.println("==========================================\n");*/
        introducirCandidatos(candidatos);
        showCandidatos(candidatos);
        votos = votar();
        
        do{
            menu();
            uInput = getVoto(" _: ");
            switch(uInput){
                case 1:
                    getAllVotos(votos,candidatos);
                    break;
                case 2:
                    getGanador(votos,candidatos);
                    break;
                case 3:
                    showNulos(votos);
                    break;
                case 0:
                    System.exit(0);
            }
        }while (true);
        
    }
    
    public static void showNulos(ArrayList<Voto> votos){
        TableBuilder tb = new TableBuilder();
        tb.printHeaders("TOTAL DE VOTOS NULOS");
        int counter = 0;
        for (Voto voto : votos){
            if (voto.getVoto() == -1)
                counter +=1;
        }
        tb.printRow("" + counter);
    }
    
    public static void getGanador(ArrayList<Voto> votos, Candidato[] candidatos){
        TableBuilder tb = new TableBuilder();
        
        int[] totales = new int[12];
        for (Candidato candidato : candidatos){
            int ID = candidato.getID();
            int counter = 0;
            for (Voto voto : votos){
                if (voto.getVoto() == ID)
                    counter +=1;
            }
            totales[ID] = counter;
        }
        
        int valor = -1;
        LinkedList<Integer> idGanadores = new LinkedList();
        for (int i=0; i<12; i++){
            if (totales[i]>valor){
                valor = totales[i];
                try{
                    idGanadores.removeFirst();
                }catch (Exception ex){
                    
                }
                idGanadores.addFirst(i);
            }
        }
        
        for (int i=0; i<12; i++){
            if (totales[i]==valor){
                if(!(i == idGanadores.getFirst()))
                    idGanadores.add(i);
            }
        }
        
        if (idGanadores.getFirst() == idGanadores.getLast()){
            tb.setSizeToAutomatic();
            tb.printHeaders("        > GANADOR DE LA ELECCIÓN <      ");
        }else{
            tb.setSize(42);
            String[] header = {"EMPATE EN LA ELECCIÓN ENTRE "};
            tb.printHeaders("EMPATE EN LA ELECCIÓN ENTRE ");       
        }
        tb.setSizeToAutomatic();
        tb.printHeaders("Nombre del ganador", "Votos en total");
        for (Candidato candidato : candidatos){
            for (int id : idGanadores){
                if (candidato.getID() == id){
                    tb.setSize(22);
                    //String[] data = {candidato.getNombre(), "" + valor};
                    tb.printRow(candidato.getNombre(), "" + valor);
                    //System.out.println("  Nombre: " + candidato.getNombre());
                    //System.out.println("   Votos: " + valor);
                    //System.out.println("___________________________________________________\n");
                }
            }
        }   
        System.out.println("\n");
    }
    
    public static void getAllVotos(ArrayList<Voto> votos, Candidato[] candidatos){
        System.out.println("==================== RESULTADOS ===================");
        TableBuilder tb = new TableBuilder(16);
        String[] header = {"ID", "Candidato", "Votos"};
        tb.printHeaders(header);
        for (Candidato candidato : candidatos){
            int ID = candidato.getID();
            int counter = 0;
            for (Voto voto : votos){
                if (voto.getVoto() == ID)
                    counter +=1;
            }
            
            String[] data = {"" + ID, candidato.getNombre(), "" + counter};
            tb.printRow(data, "right", "left", "center");
            //System.out.println("  Candidato (" + ID + "): " + candidato.getNombre());
            //System.out.println("   Votos: " + counter);
            //System.out.println("________________________________\n");
        }
    }
    
    public static void menu(){
        System.out.println("=================== MENU ===================");
        System.out.println(" 1 Obtener el número de votos por candidato");
        System.out.println(" 2 Obtener candidato ganador");
        System.out.println(" 3 Obtener total de votos nulos (-1)");
        System.out.println(" 0 Exit");
    }
    
    
    public static ArrayList<Voto> votar(){
        System.out.println("=========== BIENVENIDO A LA VOTACIÓN ============");
        ArrayList<Voto> votos = new ArrayList();
        int input = -2;
        System.out.println("Para salir de la votación introduzca '100'\n");
        do{
            input = getVoto("Introduzca ID del candidato a elegir: ");
            if (input==100){break;}
            Voto v = new Voto(input);
            votos.add(v);
        }while(true);
        return votos;
    }
    
    public static Candidato[] introducirCandidatos(Candidato[] candidatos){
        String[] nombres = {"Alfredo","Alejandraa","Jose Pedro Marrero","Daniel Topas Khamitsevich"
                           ,"Angel","Adriana","Jose","Sabina",
                            "Jorge","Samara","Ricardo","Jesus"};
        Scanner scan = new Scanner(System.in);
        for (int i=0; i<12; i++){
            candidatos[i] = new Candidato(nombres[i],nombres[i],i);
        }
        return candidatos;
    }
    
    public static void showCandidatos(Candidato[] candidatos){
        TableBuilder tb = new TableBuilder();
        String[] headers = {"ID","Nombre"};
        tb.printHeaders(headers);
        
        for (Candidato candidato : candidatos){
            String[] data = {"" + candidato.getID(), candidato.getNombre()};
            tb.printRow(data, "right", "left");
        }
    }
    
    public static int getVoto(String message){
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        return scan.nextInt();
    }
}
