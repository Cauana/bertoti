package com.example.DesignPatterns.Strategy.antipattern;

public class Main {
    public static void main(String[] args) {
        Cliente clienteComEmprestimo = new Cliente(true);
        clienteComEmprestimo.solicitarEmprestimo();

        Cliente clienteSemEmprestimo = new Cliente(false);
        clienteSemEmprestimo.solicitarEmprestimo();
    }
}
