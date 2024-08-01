package br.ufscar.dc.dsw.domain;

public class Intervalo {

    private int minimo;
    private int maximo;
    private int incremento;

    public Intervalo(){
        this.minimo = -100;
        this.maximo = 100;
    }

    // Getters
    public int getMinimo() {
        return minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public int getIncremento() {
        return incremento;
    }

    // Setters
    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }
}
