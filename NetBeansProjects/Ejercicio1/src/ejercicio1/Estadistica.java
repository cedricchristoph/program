/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Inf2
 */
public class Estadistica {
    private int lineas, palabras, caracteres;
    HashMap<String, Integer> frecuenciaPalabras;
    ArrayList<Palabra> frecuencias;
    
    public Estadistica () 
    {
        lineas = 0;
        palabras = 0;
        caracteres = 0;
        frecuenciaPalabras = new HashMap<String, Integer>();
        frecuencias = new ArrayList();
    }
    
    public void analiza (String linea) 
    {
        String[] words = linea.split(" ");
        lineas++;
        palabras += words.length;
        caracteres += linea.length();
        for (String palabra : words) {
            palabra = palabra.replaceAll(":", "");
            palabra = palabra.replaceAll("\\.", "");
            palabra = palabra.replaceAll(";", "");
            palabra = palabra.replaceAll("_", "");
            palabra = palabra.replaceAll(",", "");

            if (contains(palabra))
                getPalabra(palabra).add();
            else
                frecuencias.add(new Palabra(palabra));
            
            /*if (!frecuenciaPalabras.containsKey(palabra))
                frecuenciaPalabras.put(palabra, 1);
            else {
                int oldValue = frecuenciaPalabras.get(palabra);
                frecuenciaPalabras.remove(palabra);
                frecuenciaPalabras.put(palabra, (oldValue + 1));
            }*/
            
        }
        
    }
    
    private Palabra getPalabra(String palabra) {
        for (Palabra p : frecuencias) {
            if ((p.getPalabra().equalsIgnoreCase(palabra)))
                return p;
        }
        return null;
    }
    
    private boolean contains(String palabra) 
    {
        int count = 0;
        for (Palabra p : frecuencias) {
            if (!(p.getPalabra().equalsIgnoreCase(palabra)))
                count++;
        }
        return !(count == frecuencias.size());
    }
    
    public String getResult() 
    {
        String result = "============ RESULTADOS ============\n"
                + "Nº lineas: " + getLineas() + "\n"
                + "Nº palabras: " + getPalabras() + "\n"
                + "Nº caracteres: " + getCaracteres() + "\n"
                + "   ------- PALABRAS MÁS USADAS -------\n";
        boolean isFirst = true;
        
        /**Map<String, Integer> sorted = frecuenciaPalabras.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));*/
        frecuencias.sort(Comparator.comparing(Palabra::getFrecuencia));
        for (int i = 0; i < 10; i++) {
            System.out.println(frecuencias.get(i).getPalabra() + "  " + frecuencias.get(i).getFrecuencia());
        }
        return result;
    }
    
    public int getLineas() {
        return lineas;
    }

    public int getPalabras() {
        return palabras;
    }

    public int getCaracteres() {
        return caracteres;
    }

    public HashMap<String, Integer> getFrecuenciaPalabras() {
        return frecuenciaPalabras;
    }

    public void setLineas(int lineas) {
        this.lineas = lineas;
    }

    public void setPalabras(int palabras) {
        this.palabras = palabras;
    }

    public void setCaracteres(int caracteres) {
        this.caracteres = caracteres;
    }

    public void setFrecuenciaPalabras(HashMap<String, Integer> frecuenciaPalabras) {
        this.frecuenciaPalabras = frecuenciaPalabras;
    }
    
    
    
}
