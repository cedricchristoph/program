package ejercicio3;

/**
 *
 *  Examen Final Java. Clase Cliente
 *  EJERCICIO 3
 *  @author Cedric Christoph
 *
 */
public class Cliente {
    
    private String NIF,
                   nombre,
                   tlf,
                   direccion;
    
    private double deuda;

    /**
     * Constructor completo
     * @param NIF
     * @param nombre
     * @param tlf
     * @param direccion
     * @param deuda 
     */
    public Cliente (String NIF, String nombre, String tlf, String direccion, Integer deuda) 
    {
        this.NIF = NIF;
        this.nombre = nombre;
        this.tlf = tlf;
        this.direccion = direccion;
        this.deuda = deuda;
    }
    
    /**
     * Constructor básico
     * @param NIF NIF cliente
     * @param nombre Nombre cliente
     */
    public Cliente (String NIF, String nombre) 
    {
        this.NIF = NIF;
        this.nombre = nombre;
    }
    
    /**
     * Constructor vacío
     */
    public Cliente () 
    {
        
    }

    public String getNIF() {
        return NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTlf() {
        return tlf;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }
    
    public void Mostrar(){
        System.out.println("\nInformación del cliente:");
        System.out.println(this.getNIF());
        System.out.println(this.getNombre());
        System.out.println(this.getDireccion());
        System.out.println(this.getTlf());
        System.out.println(this.getDeuda());
    }
}
