package main.java.com.example.DesignPatterns.Facade.Pattern;

class LojaOnline {
    private Estoque estoque;

    public LojaOnline() {
        this.estoque = new Estoque();
    }

    public void realizarPedido(String produto, int quantidade, String cliente) {
        if (estoque.verificarDisponibilidade(produto, quantidade)) {
            System.out.println("Pedido de " + quantidade + " unidades de " + produto + " para " + cliente + " realizado com sucesso.");
        } else {
            System.out.println("Pedido de " + quantidade + " unidades de " + produto + " para " + cliente + " não pôde ser realizado devido a estoque insuficiente.");
        }
    }
}
