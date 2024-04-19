package com.example.DesignPatterns.Strategy.antipattern;

public class Cliente {
    private boolean emprestimoPermitido;

    public Cliente(boolean emprestimoPermitido) {
        this.emprestimoPermitido = emprestimoPermitido;
    }

    public void solicitarEmprestimo() {
        if (emprestimoPermitido) {
            System.out.println("Empréstimo permitido");
        } else {
            System.out.println("Empréstimo negado");
        }
    }
}
