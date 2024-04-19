package com.example.DesignPatterns.Strategy.pattern;

public class Permitido implements Emprestimo {
    public void emprestar() {
        System.out.println("Emprestimo permitido");
    }  
}
