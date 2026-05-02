package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

class MainInteractivo {
    public static void main(String[] args) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Scanner scanner = new Scanner(System.in);


        Expendedor EXP = new Expendedor(5);
        Comprador COM = null;
        Moneda m = null;

        System.out.println("#############################\n"
                            +"#### MAQUINA EXPENDEDORA ####\n"+
                            "#############################\n");

        for(Opcion op : Opcion.values()) {System.out.println("("+op.ID+") ---> "+ op +" ($"+ op.precio+")");}

        while (true){
            int cual = 0;
            int cursor = 0;

            System.out.println("1. COMPRAR\n2. VER VUELTO\n3. PRODUCTO ACTUAL\n4. CREAR MONEDA\n5. SALIR");
            System.out.println("Indique una de las acciones");

            boolean valido = false;

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

                // 1 (COMPRAR)
                case 1:
                    for(Opcion op : Opcion.values()) {System.out.println("("+op.ID+") ---> "+ op +" ($"+ op.precio+")");}
                    System.out.println("Ingrese el ID del producto:");
                    try{
                        cual = scanner.nextInt();    //Mejorar la validacion posteriormente
                        Opcion Eleccion = null;

                        for (Opcion op : Opcion.values()){
                            if(cual == op.ID) {Eleccion = op; break;}
                        }
                        COM = new Comprador(m, cual, EXP);
                    } catch (NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;

                // 2 (VER VUELTO)
                case 2:
                    System.out.print("Vuelto actual: ");
                    if (COM != null) System.out.println(COM.cuantoVuelto());
                    else System.out.println(0);
                    break;

                // 3 (PRODUCTO ACTUAL)
                case 3:
                    if (COM != null){
                        System.out.println("Haz consumido un/una"+COM.queConsumiste());
                    } else {
                        System.out.println("No hay nada");
                    }
                    break;

                // 4 (CREAR MONEDA)
                case 4:
                    System.out.println("1 ===> 100\n2 ===> 500\n3 ===> 1000\n4 ===> 1500");
                    System.out.println("Elija la moneda a crear: ");

                    cual = scanner.nextInt();

                    if(cual == 1) m = new Moneda100();
                    if(cual == 2) m = new Moneda500();
                    if(cual == 3) m = new Moneda1000();
                    if(cual == 4) m = new Moneda1500();
                    break;

                // 5 (SALIR)
                case 5:
                    return;
            }
        }
    }
}