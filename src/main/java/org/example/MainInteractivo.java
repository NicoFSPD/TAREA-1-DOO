package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que implementa una interfaz de consola interactiva para el sistema
 * Permite al usuario realizar compras, gestionar monedas y consultar el estado
 * del comprador en tiempo real mediante un menu de opciones
 * @author Eduardo Riveros
 * @author Nicolas Silva
 * @version 1, 02 de mayo de 2026
 */

class MainInteractivo {
    /**
     * Punto de entrada para la ejecucion del menu interactivo.
     * Gestiona el flujo principal del programa, incluyendo la creacion de monedas,
     * la seleccion de productos del expendedor y el manejo del ciclo de vida del comprador
     *
     * @param args Argumentos de linea de comandos (no utilizados)
     * @throws NoHayProductoException Si se intenta comprar un producto sin stock
     * @throws PagoInsuficienteException Si el valor de la moneda es menor al precio del producto
     * @throws PagoIncorrectoException Si se intenta comprar sin haber ingresado una moneda
     */
    public static void main(String[] args) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        /**
         * Scanner para capturar la entrada del usuario por consola
         */
        Scanner scanner = new Scanner(System.in);
        /**
         * Instancia del expendedor con una carga inicial de 5 productos por tipo
         */
        Expendedor EXP = new Expendedor(5);
        /**
         * Referencia al comprador actual
         */
        Comprador COM = null;
        /**
         * Moneda que el usuario crea y mantiene "en la mano" antes de comprar
         */
        Moneda m = null;

        System.out.println("#############################\n"
                            +"#### MAQUINA EXPENDEDORA ####\n"+
                            "#############################\n");
        /**
         * Despliegue inicial de productos y precios segun la enumeracion
         */
        for(Opcion op : Opcion.values()) {System.out.println("("+op.ID+") ---> "+ op +" ($"+ op.precio+")");}

        while (true){
            int cual = 0;
            int cursor = 0;

            System.out.println("1. COMPRAR\n2. VER VUELTO\n3. PRODUCTO ACTUAL\n4. CREAR MONEDA\n5. SALIR");
            System.out.println("Indique una de las acciones");

            boolean valido = false;
            /**
             * Validacion de entrada para evitar errores por tipos de datos incorrectos
             */
            while (!valido) {
                System.out.print(": ");
                try {
                    cursor = scanner.nextInt();
                    if (cursor >= 1 && cursor <= 5) {
                        valido = true;
                    } else {
                        System.out.println("Opcion inválida, intente de nuevo");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar una de las opciones");
                    scanner.nextLine();
                }
            }
            switch (cursor){
                /**
                 * Caso 1 (comprar)
                 */
                case 1:
                    for(Opcion op : Opcion.values()) {System.out.println("("+op.ID+") ---> "+ op +" ($"+ op.precio+")");}
                    System.out.println("Ingrese el ID del producto:");
                        cual = scanner.nextInt();
                        Opcion Eleccion = null;

                        for (Opcion op : Opcion.values()) {
                            if (cual == op.ID) {
                                Eleccion = op;
                                break;
                            }
                        }
                        COM = new Comprador(m, cual, EXP);
                        m = null;
                        break;


                /**
                 * Caso 2 (ver vuelto)
                 */
                case 2:
                    System.out.print("Vuelto actual: ");
                    if (COM != null) System.out.println(COM.cuantoVuelto());
                    else System.out.println(0);
                    break;

                /**
                 * Caso 3 (producto actual)
                 */
                case 3:
                    if (COM != null){
                        System.out.println("Haz consumido un/una"+COM.queConsumiste());
                    } else {
                        System.out.println("No hay nada");
                    }
                    break;

                /**
                 * Caso 4 (crear moneda)
                 */
                case 4:
                    System.out.println("1 ===> 100\n2 ===> 500\n3 ===> 1000\n4 ===> 1500");
                    System.out.println("Elija la moneda a crear: ");

                    cual = scanner.nextInt();

                    if(cual == 1) m = new Moneda100();
                    if(cual == 2) m = new Moneda500();
                    if(cual == 3) m = new Moneda1000();
                    if(cual == 4) m = new Moneda1500();
                    break;

                /**
                 * Caso 5 (Salir)
                 */
                case 5:
                    return;
            }
        }
    }
}