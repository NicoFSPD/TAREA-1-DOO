package org.example;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Clase principal que sirve como banco de pruebas para el sistema del expendedor
 * Esta clase demuestra el funcionamiento de las compras, el manejo de excepciones
 * y la capacidad de ordenar monedas mediante la interfaz Comparable
 * @author Eduardo Riveros
 * @version 1, 02 de mayo de 2026
 */
public class Main {
    /**
     * Metodo principal que ejecuta las pruebas requeridas
     * Realiza seis pruebas especificas:
     * 1)Compra exitosa con entrega de vuelto
     * 2)Intento de compra con saldo insuficiente
     * 3)Intento de compra con moneda nula (PagoIncorrectoException)
     * 4)Intento de compra con un ID de producto inexistente
     * 5)Intento de compra en un deposito sin stock (NoHayProductoException)
     * 6)Ordenamiento de una lista de monedas usando Collections.sort
     *
     * @param args Argumentos de linea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        /**
         * Instancia del expendedor con una capacidad inicial de 2 productos por deposito
         */
        Expendedor exp = new Expendedor(2);

        /**
         * Codigo para la prueba 1 (caso en que se compra y da vuelto)
         */
        Moneda m1 = new Moneda1000();
        Comprador c1 = new Comprador(m1, Opcion.SNICKERS.ID, exp);
        System.out.println("tomó/comió; "+ c1.queConsumiste());
        System.out.println("Vuelto total: "+ c1.cuantoVuelto());


        /**
         * Codigo para la prueba 2 (no alcanza el dinero para la compra)
         */
        Moneda m2 = new Moneda500();
        Comprador c2 = new Comprador(m2, Opcion.COCA.ID, exp);
        System.out.println("tomó/comió; "+ c2.queConsumiste());
        System.out.println("Vuelto total: "+ c2.cuantoVuelto());

        /**
         * Codigo para la prueba 3 (moneda invalidada)
         */
        Comprador c3 = new Comprador(null, Opcion.SPRITE.ID, exp);
        System.out.println("tomó/comió; "+ c3.queConsumiste());
        System.out.println("Vuelto total: "+ c3.cuantoVuelto());

        /**
         * Codigo para la prueba 4 (ID producto invalido)
         */
        Moneda m4 = new Moneda1000();
        Comprador c4 = new Comprador(m4, 67, exp);
        System.out.println("tomó/comió; "+ c4.queConsumiste());
        System.out.println("Vuelto total: "+ c4.cuantoVuelto());

        /**
         * Codigo para la prueba 5 (sin stock)
         */
        Moneda m5 = new Moneda1500();

        new Comprador(m5, Opcion.FANTA.ID, exp);
        new Comprador(m5, Opcion.FANTA.ID, exp);

        Comprador c5 = new Comprador(m5, Opcion.FANTA.ID, exp);
        System.out.println("tomó/comió; "+ c5.queConsumiste());
        System.out.println("Vuelto total: "+ c5.cuantoVuelto());

        /**
         * Codigo para la prueba 6 (orden con comparable)
         */
        ArrayList<Moneda> listaMonedas = new ArrayList<>();
        listaMonedas.add(new Moneda1000());
        listaMonedas.add(new Moneda100());
        listaMonedas.add(new Moneda1500());
        listaMonedas.add(new Moneda500());

        /**
         * Impresion de la lista en el orden desordenado
         */
        for (Moneda moneda : listaMonedas){
            System.out.println(moneda.toString());
        }

        /**
         * Orden con comparables
         */
        Collections.sort(listaMonedas);

        /**
         * Impresion de la lista luego de ser ordenado
         */
        for (Moneda moneda : listaMonedas){
            System.out.println(moneda.toString());
        }
    }
}
