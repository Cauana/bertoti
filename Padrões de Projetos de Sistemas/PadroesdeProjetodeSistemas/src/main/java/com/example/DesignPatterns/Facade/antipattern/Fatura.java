package com.example.DesignPatterns.Facade.antipattern;

public class Fatura{
    public void gerarFatura(String produto, int quantidade, String cliente) {
        System.out.println("Fatura gerada para " + quantidade + " unidades de " + produto + " para " + cliente);
    }
}