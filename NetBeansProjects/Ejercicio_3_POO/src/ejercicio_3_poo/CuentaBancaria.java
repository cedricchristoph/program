package ejercicio_3_poo;

import java.util.*;

public abstract class CuentaBancaria {
    private String propietario;
    private String iban;
    private double saldo;
    private final double interesAnualBasico;
    private String currency = "€";
    protected TableConstructor tb = new TableConstructor();

    // CONSTRUCTORS
    public CuentaBancaria(String propietario, String iban, double interesAnualBasico) {
        this.propietario = propietario;
        iban = iban.replaceAll(" ", "");
        this.iban = iban;
        saldo = 0d;
        this.interesAnualBasico = interesAnualBasico;

        tb.setAllSizes(20);
    }

    // GETTERS
    public String getIban() {
        return iban;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getPropietario() { return propietario; }
    public double getInteresAnualBasico() {
        return interesAnualBasico;
    }
    public String getCurrency() {
        return currency;
    }

    // SETTERS
    public void setIban(String iban) {
        iban = iban.replaceAll(" ", "");
        this.iban = iban;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // PUBLIC METHODS

    public abstract void mostrarDetalles(boolean showHeaders);
    public abstract void show(boolean showHeaders);

    public void ingresar(double cantidad) {
        changeSaldo(cantidad);
    }

    public void retirar(double cantidad) {
        changeSaldo(-cantidad);
    }

    public LinkedList<CuentaBancaria> transferir(LinkedList<CuentaBancaria> cuentas, String ibanDestinatario, double cantidad) {
        
        // CHECK SUFFICIENT BALANCE
        if (cantidad > saldo) {
            System.out.println("No tiene suficiente saldo para realizar esta transferencia.");
            System.out.println("DETALLES: ");
            System.out.println("    - SALDO DE CUENTA     : " + saldo + " " + getCurrency());
            System.out.println("    - DINERO A TRANSFERIR : " + cantidad + " " + getCurrency());
            System.out.println("    - FALTA               : " + (cantidad - saldo) + " " + getCurrency());
            return cuentas;
        }
        // TRANSFER
        ibanDestinatario = ibanDestinatario.replaceAll(" ", "");
        for (Iterator<CuentaBancaria> it = cuentas.iterator(); it.hasNext(); ) {
            CuentaBancaria c = it.next();
            if (c.getIban().equals(ibanDestinatario)) {
                c.ingresar(cantidad);
                retirar(cantidad);
                System.out.println("Transferencia completada.");
                System.out.println("DETALLES DE TRANSFERENCIA");
                System.out.println("    - SALDO DE CUENTA (antes) : " + (saldo+cantidad) + " " + getCurrency());
                System.out.println("    - DINERO TRANSFERIDO      : " + cantidad + " " + getCurrency() + " --> " + ibanDestinatario);
                System.out.println("    - SALDO DE CUENTA (actual): " + (saldo) + " " + getCurrency());
            }
        }
        return cuentas;
    }

    public abstract double calcularIntereses();

    // PRIVATE/PROTECTED METHODS
    protected void changeSaldo(double cantidad) {
        if (cantidad < 0) {
            // RETIRAR
            if (cantidad > saldo) {
                System.out.println("No tiene saldo suficiente en la cuenta");
            } else {
                saldo += cantidad;
            }
        } else {
            // INGRESAR
            saldo += cantidad;
        }
    }
}
