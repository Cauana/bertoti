package main.java.com.example.DesignPatterns.Facade.Pattern;

public class Main {
    public static void main(String[] args) {
        LojaOnline lojaFacade = new LojaOnline(); 
        lojaFacade.realizarPedido("Camiseta", 2, "João");
        lojaFacade.realizarPedido("Sapato", 3, "Maria");
    }
}
