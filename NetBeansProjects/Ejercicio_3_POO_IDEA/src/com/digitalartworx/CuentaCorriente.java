package com.digitalartworx;

public class CuentaCorriente extends CuentaBancaria {

    // CONSTRUCTORS
    public CuentaCorriente(String propietario, String iban, double interesAnualBasico) {
        super(propietario, iban, interesAnualBasico);
    }

    // PUBLIC METHODS
    @Override
    public void mostrarDetalles(boolean showHeaders) {
        if (showHeaders)
            tb.printHeader("TIPO", "PROPIETARIO", "IBAN", "SALDO", "INTERESES");
        tb.printRow("Corriente", getPropietario(), getIban(), getSaldo() + " " + getCurrency(), "" + calcularIntereses() + "%");
    }

    @Override
    public void show(boolean showHeaders) {
        if (showHeaders)
            tb.printHeader("PROPIETARIO", "IBAN", "TIPO");
        tb.printRow(getPropietario(), getIban(), "Corriente");
    }

    @Override
    public double calcularIntereses() {
        return getInteresAnualBasico();
    }
}
