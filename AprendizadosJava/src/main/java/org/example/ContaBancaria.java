package org.example;

import java.math.BigDecimal;

public class ContaBancaria {
    private final String titular;
    private BigDecimal saldo;

    public ContaBancaria(String titular){
        this.titular = titular;
        this.saldo = BigDecimal.ZERO;
    };

    public void depositar(BigDecimal valor){
        ValidarValor(valor);
        saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor){
        ValidarValor(valor);
        if (saldo.compareTo(valor) < 0){
            throw new IllegalArgumentException("O valor de saque é maior do que o valor disponível.");
        }
        saldo = saldo.subtract(valor);
    }

    public void getSaldo(){
        System.out.printf("Seu saldo é R$%s", saldo);;
    };

    private void ValidarValor(BigDecimal valor){
        if(valor == null || valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }
    }
}
