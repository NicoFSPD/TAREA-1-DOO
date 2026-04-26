package org.example;


//------------------------------- SUPERCLASE -----------------------------------------

/**
 * clase abstracta de objeto que puede tomarse como bebida o dulce y sus respectivos tipos
 * Define la propiedad serie y metodos que tendrán luego los productos disponibles.
 */
abstract class Producto{       //super clase
    private int serie;

    /**
     * constructor de la clase producto
     * * @param numSerie será el ID del producto en cuestión
     */
    public Producto(int numSerie){  //constructor
        this.serie = numSerie;

        /**
         * Getter del ID del producto
         * * @return numSerie será el ID del producto en cuestión
         */
    }
    public int getSerie(){
        return this.serie;
    }

    /**
     * metodo abstracto que "realiza la acción" de comer/beber el producto
     * * @return retorna un string con el sonido o el nombre del producto consumido
     */
    public abstract String consumir();  //metodo abstracto
}


//------------------------------- SUBCLASES -----------------------------------------

abstract class Bebida extends Producto{        //subclase para las BEBIDAS
    public Bebida(int numSerie){
        super(numSerie);
    }
}
abstract class Dulce extends Producto{         //subclase para las DULCES
    public Dulce(int numSerie){
        super(numSerie);
    }
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
