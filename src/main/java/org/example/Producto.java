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

/**
 * clase abstracta que de los productos de tipo bebida
 * es heredada de la super clase producto
 */
abstract class Bebida extends Producto{        //subclase para las BEBIDAS
    /**
     * constructor de la clase Bebida
     * * @param numSerie será el ID de la bebida
     */
    public Bebida(int numSerie){
        super(numSerie);
    }
}

/**
 * clase abstracta que de los productos de tipo dulce
 * es heredada de la super clase producto
 */
abstract class Dulce extends Producto{         //subclase para las DULCES
    /**
     * constructor de la clase Dulce
     * * @param numSerie será el ID del dulce
     */
    public Dulce(int numSerie){
        super(numSerie);
    }
}


//-----------------------------------------------------------------------------------
//------------------------------- PRODUCTOS -----------------------------------------
//-----------------------------------------------------------------------------------

//------------------------------- BEBIDAS -----------------------------------------

/**
 * Objeto CocaCola
 */
class CocaCola extends Bebida{
    /**
     * constructor de la clase CocaCola
     * * @param numSerie será el ID de la cocacola comprada
     */
    public CocaCola(int numSerie){
        super(numSerie);
    }

    /**
     * acción de consumir la cocacola
     * * @return string "cocacola"
     */
    @Override
    public String consumir(){
        return "cocacola";
    }
}

/**
 * Objeto Sprite
 */
class Sprite extends Bebida{

    /**
     * constructor de la clase Sprite
     * * @param numSerie será el ID de la sprite comprada
     */
    public Sprite(int numSerie){
        super(numSerie);
    }
    /**
     * acción de consumir la sprite
     * * @return string "sprite"
     */
    @Override
    public String consumir(){
        return "sprite";
    }
}

/**
 * Objeto Fanta
 */
class Fanta extends Bebida{
    /**
     * constructor de la clase Fanta
     * * @param numSerie será el ID de la Fanta comprada
     */
    public Fanta(int numSerie){
        super(numSerie);
    }
    /**
     * acción de consumir la Fanta
     * * @return string "fanta"
     */
    @Override
    public String consumir(){
        return "fanta";
    }
}


//------------------------------- DULCES -----------------------------------------

/**
 * Objeto Snicker
 */
class Snickers extends Dulce{
    /**
     * constructor de la clase Snickers
     * * @param numSerie será el ID del snicker comprado
     */
    public Snickers(int numSerie){  //constructor
        super(numSerie);
    }
    /**
     * acción de consumir un snicker
     * * @return string "snickers"
     */
    @Override
    public String consumir(){
        return "snickers";
    }
}

/**
 * Objeto Super8
 */
class Super8 extends Dulce{
    /**
     * constructor de la clase Super8
     * * @param numSerie será el ID del super8 comprado
     */
    public Super8(int numSerie){    //constructor
        super(numSerie);
    }
    /**
     * acción de consumir la cocacola
     * * @return string "cocacola"
     */
    @Override
    public String consumir(){
        return "super8";
    }
}





