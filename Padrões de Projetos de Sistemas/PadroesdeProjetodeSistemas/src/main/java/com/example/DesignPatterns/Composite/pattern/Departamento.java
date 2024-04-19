package com.example.DesignPatterns.Composite.pattern;
import java.util.ArrayList;
import java.util.List;

class Departamento implements Funcionario {
    private String nome;
    private List<Funcionario> empregados = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public void adicionarEmpregado(Funcionario empregado) {
        empregados.add(empregado);
    }

    public void removerEmpregado(Funcionario empregado) {
        empregados.remove(empregado);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Departamento: " + nome);
        for (Funcionario empregado : empregados) {
            empregado.mostrarDetalhes();
        }
    }
}
