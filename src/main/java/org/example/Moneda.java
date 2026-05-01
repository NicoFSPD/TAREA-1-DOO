package org.example;

public abstract class Moneda implements Comparable<Moneda> {
    public Moneda() {
    }

    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();

    @Override
    public int compareTo(Moneda otraMoneda) {
        return Integer.compare(this.getValor(), otraMoneda.getValor());
    }

    @Override
    public String toString() {
        return "Moneda de " + this.getValor() + " (Serie: " + this.hashCode() + ")";
    }
}

