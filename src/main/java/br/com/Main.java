package br.com;

import br.com.controller.TicketController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicketController controller = new TicketController();

        int opcao;

        do{
            System.out.println("\n===== SISTEMA DE FILA =====");
            System.out.println("1 - Emitir ticket");
            System.out.println("2 - Chamar próximo");
            System.out.println("3 - Finalizar atendimento");
            System.out.println("4 - Mostrar filas");
            System.out.println("5 - Mostrar atendentes");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch(opcao){
                case 1 -> controller.emitirTicket(sc);
                case 2 -> controller.chamarProximo();
                case 3 -> controller.finalizarAtendimento(sc);
                case 4 -> controller.mostrarFilas();
                case 5 -> controller.mostrarAtendentes();
            }

        }while(opcao != 0);
    }
}