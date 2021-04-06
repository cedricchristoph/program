package prueba;

public class Empleado {
    private final String nombre;
    private final String dni;
    private double sueldo;
    private int edad;
    private int telefono;
    private String direccion;
    private String currency = "€";
    private TableConstructor tb = new TableConstructor();

    // CONSTRUCTORS
    public Empleado(String nombre, String dni, double sueldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldo = sueldo;
        this.edad = 0;
        this.telefono = 0;
        this.direccion = "no disponible";

        tb.showSectionSeparator(false);
        tb.setLineMarker("-");
        tb.setLineSeparator("-");
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }
    public double getSueldo() {
        return sueldo;
    }
    public int getEdad() {
        return edad;
    }
    public int getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getCurrency() {
        return currency;
    }

    // SETTERS
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // PUBLIC METHODS
    public void show(boolean printHeaders) {
        tb.setCustomSizes(20, 16, 10, 6, 16, 28);
        tb.showSectionSeparator(false);
        if (printHeaders)
            tb.printHeader("NOMBRE", "DNI", "SUELDO", "EDAD", "TLF", "DIRECCION");
        tb.printRow(getNombre(), getDni(), "" + getSueldo() + " " + getCurrency(), "" + getEdad(), "" + getTelefono(), getDireccion());
    }

    public void showRelevant(boolean printHeaders) {
        tb.setCustomSizes(20, 16, 16);
        if (printHeaders)
            tb.printHeader("DNI", "BRUTO", "NETO");
        tb.printRow(getDni(), "" + getSueldo() + " " + getCurrency(), "" + getSueldoNeto() + " " + getCurrency());
    }

    public double getSueldoNeto() {
        double brutoAnual = (sueldo * 12);
        int porcentaje = 0;

        if (brutoAnual < 12000){
            porcentaje = 20;
        } else if ((brutoAnual >= 12000) && (brutoAnual <= 25000)) {
            porcentaje = 30;
        } else if (brutoAnual > 25000) {
            porcentaje = 40;
        }

        return (sueldo - (sueldo * porcentaje / 100));
    }
}
