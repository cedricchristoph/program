
import java.util.List;

public class Profesor extends Persona {
    String nombre;
    int edad;
    List<Prestamo> prestamos;

    public Profesor(String nombre, int edad, String numeroDeTelefono) {
        super(numeroDeTelefono);
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void printInformacionPersonal() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Teléfono: " + getNumeroDeTelefono());
    }
    
    public void printTodaLaInformacion() {
        printInformacionPersonal();
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }
}




