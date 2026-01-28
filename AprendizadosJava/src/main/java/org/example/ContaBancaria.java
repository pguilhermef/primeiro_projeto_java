package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String titular;
        BigDecimal saldo = new BigDecimal("0.0");
        boolean appEmExecucao = true;
        Integer opcaoSelecionada;

        while(appEmExecucao){
            System.out.println("""
            Bem vindo ao Java Banking!
            
            Selecione uma opção abaixo e faça suas transações!
            
            1 - Depositar
            2 - Sacar
            3 - Ver Saldo
            4 - Sair
            """);

            opcaoSelecionada = scanner.nextInt();

            switch(opcaoSelecionada){
                case 1:
                    depositar();
                case 2:
                    sacar();
                case 3:
                    getSaldo();
                case 4:
                    System.out.println("Agradecemos seu uso. Até logo!");
                    appEmExecucao = false;
                default:
                    System.out.println("Selecione uma opção de 1-4.");
            }

        }
    }

    public void depositar(){
        System.out.println("Digite um valor para depositar em sua conta:");
        BigDecimal valor = scanner.nextBigDecimal();

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Não é possível adicionar valores negativos.");
        } else {
            saldo = saldo.add(valor);
            System.out.printf("Você retirou um total de R$%s\n", valor);
        }
    }

    public void sacar(){
        System.out.println("Digite um valor para sacar em sua conta:");
        BigDecimal valor = scanner.nextBigDecimal();

        if(valor == null || valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Não é possível sacar valores negativos.");
        } else {
            saldo = saldo.subtract(valor);
            System.out.printf("Você retirou um total de R$%s\n", valor);
        }
    }

    public void getSaldo(){
        System.out.println("Seu total de saldo em conta é: " + saldo);
    }
}
