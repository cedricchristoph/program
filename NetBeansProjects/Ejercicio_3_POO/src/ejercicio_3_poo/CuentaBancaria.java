package ejercicio_3_poo;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public abstract class CuentaBancaria {
    private String propietario;
    private String iban;
    private double saldo;
    private final double interesAnualBasico;
    private Currency currency;
    protected TableConstructor tb = new TableConstructor();

    // CONSTRUCTORS
    public CuentaBancaria(String propietario, String iban, double interesAnualBasico) {
        this.propietario = propietario;
        iban = iban.replaceAll(" ", "");
        this.iban = iban;
        saldo = 0d;
        this.interesAnualBasico = interesAnualBasico;
        this.currency = new Currency("Dollar", "$", 1);
        
        tb.setAllSizes(20);
    }
    public CuentaBancaria(String propietario, String iban, double interesAnualBasico, Currency currency) {
        this.propietario = propietario;
        iban = iban.replaceAll(" ", "");
        this.iban = iban;
        saldo = 0d;
        this.interesAnualBasico = interesAnualBasico;
        this.currency = currency;
        
        tb.setAllSizes(20);
    }
    public CuentaBancaria(String propietario, String iban, double interesAnualBasico, Currency currency, double startCapital) {
        this.propietario = propietario;
        iban = iban.replaceAll(" ", "");
        this.iban = iban;
        saldo = startCapital;
        this.interesAnualBasico = interesAnualBasico;
        this.currency = currency;
        
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
    public Currency getCurrency() {
        return currency;
    }
    public String getCurrencySign() {
        return currency.getSign();
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
    public void setCurrency(Currency currency) {
        double tmpSaldo = saldo;
        retirar(saldo);
        ingresar(this.currency.getConvertion(tmpSaldo, currency));
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
        for (CuentaBancaria c : cuentas) {
            if (c.getIban().equals(ibanDestinatario)) {
                c.ingresar(currency.getConvertion(cantidad, c.getCurrency()));
                retirar(cantidad);
                System.out.println("Transferencia completada.");
                System.out.println("DETALLES DE TRANSFERENCIA");
                System.out.println("    - SALDO DE CUENTA (antes) : " + (saldo+cantidad) + " " + getCurrencySign());
                System.out.println("    - DINERO TRANSFERIDO      : " + cantidad + " " + getCurrencySign() + " --> " + ibanDestinatario);
                System.out.println("    - SALDO DE CUENTA (actual): " + (saldo) + " " + getCurrencySign());
            }
        }
        return cuentas;
    }

    public abstract double calcularIntereses();

    // PRIVATE/PROTECTED METHODS
    protected void changeSaldo(double cantidad) {
        DecimalFormat df2 = new DecimalFormat("#.##");
        df2.setRoundingMode(RoundingMode.CEILING);
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
        saldo = Double.parseDouble(df2.format(saldo));
    }
}
