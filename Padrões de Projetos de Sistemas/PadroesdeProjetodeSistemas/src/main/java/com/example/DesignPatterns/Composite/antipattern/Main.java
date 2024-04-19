package com.example.DesignPatterns.Composite.antipattern;

public class Main {
    public static void main(String[] args) {
        Empresa minhaEmpresa = new Empresa();

        minhaEmpresa.adicionarDepartamento(new Departamento("Desenvolvimento"));
        minhaEmpresa.adicionarDepartamento(new Departamento("Recursos Humanos"));

        minhaEmpresa.mostrarDetalhesDepartamentos();
    }
}
