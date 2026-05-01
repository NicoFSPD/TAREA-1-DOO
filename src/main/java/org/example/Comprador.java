package org.example;

public class Comprador{
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualProducto, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        this.vuelto = 0;

        Producto p = exp.comprarProducto(m, cualProducto);

        if (p != null){
            this.sonido = p.consumir();
        } else {
            this.sonido = null;
        }

        Moneda monedaVuelto = exp.getVuelto();
        while (monedaVuelto != null){
            this.vuelto += monedaVuelto.getValor();
            monedaVuelto = exp.getVuelto();
        }
    }

    public int cuantoVuelto(){
        return this.vuelto;
    }

    public String queConsumiste(){
        return this.sonido;
    }
}
