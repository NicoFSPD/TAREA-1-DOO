package org.example;

public class Expendedor{
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVu;
    private int precio;

    public Expendedor(int numBebidas, int precioBebidas){
        this.precio = precioBebidas;
        this.coca = new Deposito<>();
        this.sprite = new Deposito<>();
        this.monVu = new Deposito<>();

        for (int i=0;i<numBebidas;i++){
            coca.addElemento(new CocaCola(100+i));
            sprite.addElemento(new Sprite(200+i));
        }
    }

    public Bebida comprarBebida(Moneda m, int cual){
        if (m == null){
            return null;
        }

        if (m.getValor() >= this.precio){
            Bebida b = null;

            if (cual == COCA){
                b = coca.getElemento();
            } else if (cual == SPRITE){
                b = sprite.getElemento();
            }

            if (b != null){
                int vueltoTotal = m.getValor() - this.precio;
                while (vueltoTotal > 0) {
                    monVu.addElemento(new Moneda100());
                    vueltoTotal -= 100;
                }
                return b;
            } else{
                monVu.addElemento(m);
                return null;
            }
        } else{
            monVu.addElemento(m);
            return null;
        }
    }

    public Moneda getVuelto(){
        return monVu.getElemento();
    }
}
