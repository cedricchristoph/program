package prueba;

import java.util.*;

public class Empresa {
    private final String nombre;
    private final String cif;
    private int telefono;
    private String direccion;
    private LinkedList<Empleado> empleados;
    private TableConstructor tb = new TableConstructor();

    // CONSTRUCTORS
    public Empresa(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        this.empleados = new LinkedList<Empleado>();
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
    public String getCif() {
        return cif;
    }
    public int getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }

    // SETTERS
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
    }


    // PUBLIC METHODS
    public void show(boolean printHeaders) {
        tb.setAllSizes(20);
        tb.showSectionSeparator(false);
        if (printHeaders)
            tb.printHeader("NOMBRE", "CIF", "TLF", "DIRECCION");
        tb.printRow(getNombre(), getCif(), "" + getTelefono(), getDireccion());
    }

    public void addEmpleado(String nombre, String dni, double sueldo) {
        Empleado e = new Empleado(nombre, dni, sueldo);
        empleados.add(e);
    }

    public void removeEmpleado(String removeDni) {
        for (Iterator<Empleado> it=empleados.iterator(); it.hasNext(); ) {
            Empleado e = it.next();
            if (e.getDni().equals(removeDni))
                it.remove();
        }
    }

    public void showAllEmpleados() {
        tb.setCustomSizes(20, 16, 10, 6, 16, 28);
        tb.showSectionSeparator(false);
        tb.printHeader("NOMBRE", "DNI", "SUELDO", "EDAD", "TLF", "DIRECCION");
        for (Iterator<Empleado> it = empleados.iterator(); it.hasNext(); ) {
            Empleado e = it.next();
            e.show(false);
        }
    }

    public void showRelevantData() {
        tb.setCustomSizes(20, 16, 16);
        tb.showSectionSeparator(false);
        tb.printHeader("DNI", "BRUTO", "NETO");
        for (Iterator<Empleado> it = empleados.iterator(); it.hasNext(); ) {
            Empleado e = it.next();
            e.showRelevant(false);
        }
    }

    public void calcAllBruto() {
        double allBruto = 0;
        for (Iterator<Empleado> it = empleados.iterator(); it.hasNext(); ) {
            Empleado e = it.next();
            allBruto += e.getSueldo();
        }

        tb.setCustomSizes(20);
        tb.printHeader("TOTAL BRUTO");
        tb.printRow("" + allBruto);
    }

    public void calcAllNeto() {
        double allNeto = 0;
        for (Iterator<Empleado> it = empleados.iterator(); it.hasNext(); ) {
            Empleado e = it.next();
            allNeto += e.getSueldoNeto();
        }

        tb.setCustomSizes(20);
        tb.printHeader("TOTAL NETO");
        tb.printRow("" + allNeto);
    }

}
