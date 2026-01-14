package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        double balance = 0;
        boolean isRunning = true;
        int choice;

        while(isRunning){
            System.out.println("************************");
            System.out.println("       BANCO JAVA       ");
            System.out.println("************************");
            System.out.println("1. Mostrar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Sair");
            System.out.println("************************");

            System.out.println("Escolha uma opção (1-4): ");
            choice = scanner.nextInt();

            switch(choice){
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> isRunning = false;
                default -> System.out.println("Escolha inválida");
            };
        };

        System.out.println("***************************");
        System.out.println("O Banco Java agradece. Tenha um ótimo dia!");
        System.out.println("***************************");

        scanner.close();
    }

    static void showBalance(double balance){
        System.out.println("************************");
        System.out.printf("$%.2f\n", balance);
    }

    static double deposit(){
        double amount;

        System.out.print("Insira uma quantidade para ser depositada: ");

        amount = scanner.nextDouble();

        if(amount < 0){
            System.out.println("O valor não pode ser negativo");
            return 0;
        } else {
            return amount;
        }
    }

    static double withdraw(double balance){
        double amount;

        System.out.println("Insira uma quantidade para ser sacada: ");
        amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Fundos insuficientes");
            return 0;
        } else if (amount < 0) {
            System.out.println("O valor não pode ser negativo");
            return 0;
        } else {
            return amount;
        }
    };
}














