package org.example;

public class Comprador{
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualProducto, Expendedor exp) {
        this.vuelto = 0;
        this.sonido = null;

        try {

            Producto p = exp.comprarProducto(m, cualProducto);
            if (p != null) {
                this.sonido = p.consumir();
            }

        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println("error, no se pudo realizar la compra: " + e.getMessage());
        } finally {
            boolean hayVuelto = true;
            while (hayVuelto) {
                try {
                    Moneda monedaVuelto = exp.getVuelto();
                    this.vuelto += monedaVuelto.getValor();
                } catch (NoHayProductoException ex) {
                    hayVuelto = false;
                }
            }
        }
    }


    public int cuantoVuelto(){
        return this.vuelto;
    }

    public String queConsumiste(){
        return this.sonido;
    }
}
