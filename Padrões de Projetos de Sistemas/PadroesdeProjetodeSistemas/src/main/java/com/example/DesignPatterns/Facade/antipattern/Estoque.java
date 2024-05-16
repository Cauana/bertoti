package com.example.DesignPatterns.Facade.antipattern;

public class Estoque{
    public boolean verificarDisponibilidade(String produto, int quantidade) {

        if (produto.equals("Camiseta") && quantidade <= 10) {
            System.out.println("Estoque disponível para " + quantidade + " unidades de " + produto);
            return true;
        } else {
            System.out.println("Estoque insuficiente para " + quantidade + " unidades de " + produto);
            return false;
        }
    }
}