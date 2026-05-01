package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

class Main{
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
        }
    }
}