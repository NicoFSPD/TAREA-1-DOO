package org.example;

import java.util.ArrayList;
import java.util.Collections;



public class Main {
    public static void main(String[] args) {


        Expendedor exp = new Expendedor(2);



        //CODIGO PARA LA PRUEBA 1 (CASO EN QUE SE COMPRA Y DA VUELTO)
        Moneda m1 = new Moneda1000();
        Comprador c1 = new Comprador(m1, Opcion.SNICKERS.ID, exp);
        System.out.println("tomó/comió; "+ c1.queConsumiste());
        System.out.println("Vuelto total: "+ c1.cuantoVuelto());


        //CODIGO PARA LA PRUEBA 2 (NO ALCANZA EL DINERO PARA LA COMPRA)
        Moneda m2 = new Moneda500();
        Comprador c2 = new Comprador(m2, Opcion.COCA.ID, exp);
        System.out.println("tomó/comió; "+ c2.queConsumiste());
        System.out.println("Vuelto total: "+ c2.cuantoVuelto());

        //CODIGO PARA LA PRUEBA 3 (MONEDA INVALIDA)
        Comprador c3 = new Comprador(null, Opcion.SPRITE.ID, exp);
        System.out.println("tomó/comió; "+ c3.queConsumiste());
        System.out.println("Vuelto total: "+ c3.cuantoVuelto());

        //CODIGO PARA LA PRUEBA 4 (ID PRODUCTO INVALIDO)
        Moneda m4 = new Moneda1000();
        Comprador c4 = new Comprador(m4, 67, exp);
        System.out.println("tomó/comió; "+ c4.queConsumiste());
        System.out.println("Vuelto total: "+ c4.cuantoVuelto());

        //CODIGO PARA LA PRUEBA 5 (SIN STOCK)
        Moneda m5 = new Moneda1500();

        new Comprador(m5, Opcion.FANTA.ID, exp);
        new Comprador(m5, Opcion.FANTA.ID, exp);

        Comprador c5 = new Comprador(m5, Opcion.FANTA.ID, exp);
        System.out.println("tomó/comió; "+ c5.queConsumiste());
        System.out.println("Vuelto total: "+ c5.cuantoVuelto());

        //CODIGO PARA LA PRUEBA 6 (orden con comparable)
        ArrayList<Moneda> listaMonedas = new ArrayList<>();
        listaMonedas.add(new Moneda1000());
        listaMonedas.add(new Moneda100());
        listaMonedas.add(new Moneda1500());
        listaMonedas.add(new Moneda500());

        for (Moneda moneda : listaMonedas){     //impresion de la lista en el orden desordenado
            System.out.println(moneda.toString());
        }

        Collections.sort(listaMonedas); //orden con comparables

        for (Moneda moneda : listaMonedas){       //impresion de a lista luego de ser ordenado
            System.out.println(moneda.toString());
        }


    }
}
