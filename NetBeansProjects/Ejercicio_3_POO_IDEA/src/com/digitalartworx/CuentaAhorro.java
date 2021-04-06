package com.digitalartworx;

public class CuentaAhorro extends CuentaBancaria {
    private final double saldoMinimo;

    // CONSTRUCTORS
    public CuentaAhorro(String propietario, String iban, double interesAnualBasico, double saldoMinimo) {
        super(propietario, iban, interesAnualBasico);
        this.saldoMinimo = saldoMinimo;
    }

    // PUBLIC METHODS
    @Override
    public void mostrarDetalles(boolean showHeaders) {
        if (showHeaders)
            tb.printHeader("TIPO", "PROPIETARIO", "IBAN", "SALDO", "INTERESES");
        tb.printRow("Ahorro", getPropietario(), getIban(), getSaldo() + " " + getCurrency(), "" + calcularIntereses() + "%");
    }

    @Override
    public void show(boolean showHeaders) {
        if (showHeaders)
            tb.printHeader("PROPIETARIO", "IBAN", "TIPO");
        tb.printRow(getPropietario(), getIban(), "Ahorro");
    }

    @Override
    public double calcularIntereses() {
       if (getSaldo() < saldoMinimo) {
           return getInteresAnualBasico()/2;
       } else {
           return getInteresAnualBasico()*2;
       }
    }
}
