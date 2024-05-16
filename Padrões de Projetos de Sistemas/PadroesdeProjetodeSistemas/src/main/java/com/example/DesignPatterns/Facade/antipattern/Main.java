package com.example.DesignPatterns.Facade.antipattern;

public class Main {
    public static void main(String[] args) {
        LojaOnlineFacadeAntiPattern lojaFacade = new LojaOnlineFacadeAntiPattern();
        lojaFacade.realizarPedido("Camiseta", 2, "João");
    }
}