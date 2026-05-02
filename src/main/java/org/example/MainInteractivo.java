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

            }
        }
    }
}