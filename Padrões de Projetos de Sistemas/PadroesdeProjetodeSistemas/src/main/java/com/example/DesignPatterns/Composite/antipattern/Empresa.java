package com.example.DesignPatterns.Composite.antipattern;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Departamento> departamentos = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }
    public void adicionarFuncionarios(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void mostrarDetalhesDepartamentos() {
        System.out.println("Departamentos:");
        for (Departamento departamento : departamentos) {
            System.out.println("Nome do Departamento: " + departamento.getNome());
        }
    }
}
