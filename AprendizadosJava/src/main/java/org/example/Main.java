package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String titular;
        boolean appEmExecucao = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um nome para acessar sua conta:");
        titular = scanner.nextLine();

        ContaBancaria contaUm = new ContaBancaria(titular);

        System.out.printf("Bem vindo, %s\n", titular);

        while(appEmExecucao){
            int opcaoSelecionada = 0;
            BigDecimal valorDigitado;

            System.out.println("""
            
            --- Java Banking ---
            
            Selecione uma opção abaixo e faça suas transações!
            
            1 - Depositar
            2 - Sacar
            3 - Ver Saldo
            4 - Sair
            """);

            opcaoSelecionada = scanner.nextInt();

            switch(opcaoSelecionada){
                case 1:
                    System.out.println("Digite o valor a ser depositado no formato 0,0:");
                    valorDigitado = scanner.nextBigDecimal();
                    contaUm.depositar(valorDigitado);
                    break;
                case 2:
                    System.out.println("Digite o valor a ser sacado no formato 0,0:");
                    valorDigitado = scanner.nextBigDecimal();
                    contaUm.sacar(valorDigitado);
                    break;
                case 3:
                    contaUm.getSaldo();
                    break;
                case 4:
                    System.out.println("Agradecemos seu uso. Até logo!");
                    appEmExecucao = false;
                    break;
                default:
                    System.out.println("Selecione uma opção de 1-4.");
            }

        }
    }
}