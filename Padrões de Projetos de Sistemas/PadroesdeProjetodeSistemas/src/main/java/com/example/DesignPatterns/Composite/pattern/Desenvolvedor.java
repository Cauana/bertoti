package com.example.DesignPatterns.Composite.pattern;

class Desenvolvedor implements Funcionario {
    private String nome;
    private String cargo;

    public Desenvolvedor(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome: " + nome + ", Cargo: " + cargo);
    }
}