/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_segundo_trimestre_cedric_christoph;

class Libro implements Comparable<Libro>{
    private String isbn;
    private String titulo, autor, editorial;
    private int stock;
    private double precio;

    Libro(){
        this.isbn="";
        this.titulo="";
        this.autor="";
        this.editorial="";
        this.stock=0;
        this.precio=0.0;
    }

    Libro(String isbn, String ti, String au, String ed, int st, double pr)throws Exception{
        if (isbn==null || ti==null || au==null || ed==null || st==0 || pr==0)
            throw new Exception("Faltan datos del libro!");
        else{
            this.isbn=isbn;
            this.titulo=ti;
            this.autor=au;
            this.editorial=ed;
            this.stock=st;
            this.precio=pr;
        }
    }
    
    public String getIsbn(){
        return this.isbn;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public String getEditorial(){
        return this.editorial;
    }
    
    public int getStock(){
        return this.stock;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public void setIsbn(String isbn){
        this.isbn=isbn;
    }
    
    public void setTitulo(String ti){
        this.titulo=ti;
    }
    
    public void setAutor(String au){
        this.autor=au;
    }
    
    public void setEditorial(String ed){
        this.editorial=ed;
    }
    
    public void setStock(int st){
        this.stock=st;
    }
    
    public void setPrecio(double pr){
        this.precio=pr;
    }
  
    public void Mostrar(){
        System.out.println("\n\tInformacion del libro\n");
        System.out.println("ISBN: "+this.isbn);
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Autor: "+this.autor);
        System.out.println("Editorial: "+this.editorial);
        System.out.println("Stock: "+this.stock);
        System.out.println("Precio: "+this.precio);
    }

    public boolean Hay_stock(){
        return stock>0;
    }

    public boolean Es_editorial (String ed){
        return this.editorial.equals(ed);
    }

    public int Vender(int unid){
        if (unid > stock)
            return -1;
        else
        {
            this.stock-=unid;
            return stock;
        }
    }
    
    @Override
    public int compareTo(Libro l) {
        return isbn.compareTo(l.isbn); 
    }
}
