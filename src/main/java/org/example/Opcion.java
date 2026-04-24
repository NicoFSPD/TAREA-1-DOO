package org.example;

/**
 * Una enumeracion que le entrega a los productos constantes que los diferencian
 * @author Nicolas Silva
 * @version version 1, 23 de abril de 2026
 */
enum Opcion {
/** Se definen desde aqui, las constantes*/
    COCA(1,1500),
    SPRITE(2, 1500),
    FANTA(3, 1500),
    SNICKERS(4, 1300),
    SUPER8(5, 1000);
/** Dos valores int por producto: Su identificador (ID) y su precio*/
    private final int ID;
    private final int precio;
/** El constructor le asignara a las variables, las constantes predefinidas*/
    Opcion(int ID, int precio){
        this.ID = ID;
        this.precio = precio;
    }
/** getter para el Identificador
 * @return Identificador "ID"
 */
    public int getID() {
        return ID;
    }
/** getter para el precio
 * @return precio "precio"
 */
    public int getPrecio(){
        return precio;
    }
}