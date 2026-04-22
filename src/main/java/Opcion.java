enum Opcion {
    COCA(1,1500),
    SPRITE(2, 1500),
    FANTA(3, 1500),
    SNICKERS(4, 1300),
    SUPER8(5, 1000);

    private final int ID;
    private final int precio;

    Opcion(int ID, int precio){
        this.ID = ID;
        this.precio = precio;
    }

    public int getID() {
        return ID;
    }
    public int getPrecio(){
        return precio;
    }
}