package main.java.com.example.DesignPatterns.Facade.Pattern;

class LojaOnline {
    private Estoque estoque;
    private Fatura fatura;

    public LojaOnline() {
        this.estoque = new Estoque();
        this.fatura = new Fatura();
    }

    public void gerarFatura(String produto, int quantidade, String cliente) {
        fatura = new Fatura();
        fatura.gerarFatura(produto, quantidade, cliente);
    }

    public void realizarPedido(String produto, int quantidade, String cliente) {
        if (estoque.verificarDisponibilidade(produto, quantidade)) {
            System.out.println("Pedido de " + quantidade + " unidades de " + produto + " para " + cliente + " realizado com sucesso.");
            gerarFatura(produto, quantidade, cliente);
        } else {
            System.out.println("Pedido de " + quantidade + " unidades de " + produto + " para " + cliente + " não pôde ser realizado devido a estoque insuficiente.");
        }
    }
}
