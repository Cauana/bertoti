package com.example.DesignPatterns.Facade.antipattern;

class LojaOnline{
    public void realizarPedido(String produto, int quantidade, String cliente) {
        EstoqueAntiPattern estoque = new EstoqueAntiPattern();
        boolean disponivel = estoque.verificarDisponibilidade(produto, quantidade);
        if (disponivel) {
            System.out.println("Pedido de " + quantidade + " unidades de " + produto + " para " + cliente + " realizado com sucesso.");
            FaturaAntiPattern fatura = new FaturaAntiPattern();
            fatura.gerarFatura(produto, quantidade, cliente);
        } else {
            System.out.println("Pedido de " + quantidade + " unidades de " + produto + " para " + cliente + " não pôde ser realizado devido a estoque insuficiente.");
        }
    }
}