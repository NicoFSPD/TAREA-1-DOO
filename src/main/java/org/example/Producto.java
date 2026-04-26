package org.example;

public abstract class Bebida{
    private int serie;

    public Bebida(int numSerie){
        this.serie = numSerie;
    }

    public int getSerie() {
        return this.serie;
    }

    public abstract String beber();
}

class CocaCola extends Bebida{
    public CocaCola(int numSerie){
        super(numSerie);
    }

    @Override
    public String beber(){
        return "cocacola";
    }
}

class Sprite extends Bebida{
    public Sprite(int numSerie){
        super(numSerie);
    }

    @Override
    public String beber(){
        return "sprite";
    }
}
