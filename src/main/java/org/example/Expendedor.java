package org.example;

public class Expendedor{

    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;

    private int precio;

    public Expendedor(int numProductos){

        this.coca = new Deposito<>();
        this.sprite = new Deposito<>();
        this.fanta = new Deposito<>();
        this.snickers = new Deposito<>();
        this.super8 = new Deposito<>();
        this.monVu = new Deposito<>();


        for (int i=0;i<numProductos;i++){
            coca.addElemento(new CocaCola(100+i));
            sprite.addElemento(new Sprite(200+i));
            fanta.addElemento(new Fanta(300+i));
            snickers.addElemento(new Snickers(400+i));
            super8.addElemento(new Super8(500+1));
        }
    }

    public Producto comprarProducto(Moneda m, int cual){
        if (m == null){
            return null;
        }

        int precio;
        Deposito<? extends Producto> D = null;

        if(cual == Opcion.COCA.ID) {precio = Opcion.COCA.precio; D = coca;}
        else if(cual == Opcion.SPRITE.ID) {precio = Opcion.SPRITE.precio; D = sprite;}
        else if(cual == Opcion.FANTA.ID) {precio = Opcion.FANTA.precio; D = fanta;}
        else if(cual == Opcion.SNICKERS.ID) {precio = Opcion.SNICKERS.precio; D = snickers;}
        else if(cual == Opcion.SUPER8.ID) {precio = Opcion.SUPER8.precio; D = super8;}
        else{
            monVu.addElemento(m);
            return null;
        }

        if (m.getValor() >= precio){
            int vueltoTotal = m.getValor() - precio;
            while (vueltoTotal > 0) {
                monVu.addElemento(new Moneda100());
                vueltoTotal -= 100;
            }
            return D.getElemento();
        } else{
            monVu.addElemento(m);
            return null;
        }
    }

    public Moneda getVuelto(){
        return monVu.getElemento();
    }
}
