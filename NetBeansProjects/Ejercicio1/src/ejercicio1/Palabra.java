package ejercicio1;


public class Palabra {
    private String palabra;
    private int frecuencia;

    public Palabra(String palabra) {
        this.palabra = palabra;
        frecuencia = 0;
    }

    public String getPalabra() {
        return palabra;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    
    public void add() {
        frecuencia++;
    }
}
