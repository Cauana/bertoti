package main.java.com.example.DesignPatterns.Facade.Pattern;

public class Main {
    public static void main(String[] args) {
        LojaOnlineFacade lojaFacade = new LojaOnlineFacade();
        lojaFacade.realizarPedido("Camiseta", 2, "João");
        lojaFacade.realizarPedido("Sapato", 3, "Maria");
    }
}