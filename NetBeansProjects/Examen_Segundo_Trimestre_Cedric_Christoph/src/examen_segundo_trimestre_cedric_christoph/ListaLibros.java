/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_segundo_trimestre_cedric_christoph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Inf2
 */
public class ListaLibros {
    private ArrayList<Libro> lista;
    
    // Constructor de la clase que simplemente cree la estructura de datos. 
    public ListaLibros(){
        lista = new ArrayList();
    }
    
    public ListaLibros(ArrayList<Libro> lista){
        this.lista = lista;
    }
    
    //Métodos get que proporcionen la lista completa.
    public ArrayList<Libro> getLista(){
        return lista;
    }
    
    //Métodos set que permitan establecer la lista completa y modificar un sólo libro. 
    public void setLista(ArrayList<Libro> lista){
        this.lista = lista;
    }
    
    // MÉTODOS DE OPERACIONES SOBRE LA LISTA:
    public void addLibro(String isbn, String ti, String au, String ed, int st, double pr) throws Exception{
        Libro l = new Libro(isbn, ti, au, ed, st, pr);   
        lista.add(l);
    }
    
    //      Añadir un nuevo libro a la lista (proporcionado como parámetro)
    public void addLibro(Libro l){
        lista.add(l);
    }
    
    //      Comprobar si la lista está vacía. 
    public boolean checkListEmpty(){
        return lista.isEmpty();
    }
    
    //      Retornar el número de libros de la lista. 
    public int cantidadLibrosEnLista(){
        return lista.size();
    }
    
    //      Obtener el libro que ocupa una determinada posición en la lista. 
    public Libro getLibro(int index){
        return lista.get(index);
    }
    
    //      Eliminar el libro que ocupa una determinada posición en la lista. 
    public void removeLibro(int index){
        try{
            lista.remove(index);
        }catch (Exception ex){
            System.out.println("No existe este libro");
        }
    }
    
    //      Borrar la lista completa. 
    public void eraseList(){
        lista.removeAll(lista);
    }
    
    // MÉTODOS DE UTILIDADES VARIAS SOBRE LA LISTA DE LIBROS:
    //      Mostrar todos los libros de la lista por medio de un iterador y del método Mostrar 
    //      de la clase Libro. 
    public void mostrarTodo(){
        for (Iterator<Libro> it=lista.iterator(); it.hasNext(); ){
            Libro l = it.next();
            l.Mostrar();
        }
    }
    
    //      Mostrar todos los libros de una cierta editorial (recibida como 
    //      parámetro) mediante un for (var : estructura) y los métodos necesarios de Libro. 
    public void mostrarLibros(String editorial){
        for (Libro libro : lista){
            if (libro.getEditorial().equals(editorial))
                libro.Mostrar();
        }
    }
    
    //      Mostrar todos los libros sin stock
    public void mostarLibrosSinStock(){
        for (Libro libro : lista){
            if (!(libro.Hay_stock()))
                libro.Mostrar();
        }
    }
    
    
    // Con las modificaciones que creas convenientes de la clase Libro u 
    // otras desarrolla los siguientes métodos en ListaLibros: 
    
    //      Ordenación de los libros de la lista por su ISBN (ascendente). 
    public void ordenarLibros(){
        /*for (int i=0; i<lista.size()-1; i++){
            System.out.println("entre");
            for (int j=0; j<(lista.size()-1); j++){
                if (lista.get(j).getIsbn().compareTo(lista.get(j+1).getIsbn()) > 0) {
                    System.out.println(lista.get(j).getIsbn() + " va después de " + lista.get(j+1).getIsbn());
                    Libro l = lista.get(j);
                    lista.add(j, lista.get(j+1));
                    lista.add(j+1, l);
                }
            }
        }
        */
        lista.sort(null);
        System.out.println("Libros ordenados por ISBN");
    }
    
    //      Búsqueda en la lista de un libro recibido por parámetro, 
    //      localizándolo también por su ISBN. Devolver su posición.
    public Integer getPosicion(Libro l){
        int indexCounter = 0;
        for (Iterator<Libro> it=lista.iterator(); it.hasNext(); ){
            Libro libro = it.next();
            if (libro.getIsbn().equals(l.getIsbn()))
                return indexCounter;
            indexCounter +=1;
        }
        return null;
    }
    
    
    // OTROS MÉTODOS
    public void venderLibro(int index, int cantidad){
        if (cantidad > lista.get(index).getStock()){
            System.out.println("No hay stock suficiente");
        }else{
            lista.get(index).Vender(cantidad);
            System.out.println("Se han vendido " + cantidad + " unidades de " + lista.get(index).getTitulo());
        }
    }
    
}
