package com.example.DesignPatterns.Strategy.pattern;

public class Proibido implements Emprestimo{
    public void emprestar() {
        System.out.println("Emprestimo negado");
    }
}
