package com.example.DesignPatterns.Composite.pattern;

public class Main {
    public static void main(String[] args) {
        Desenvolvedor dev1 = new Desenvolvedor("Alice", "Desenvolvedor Sênior");
        Desenvolvedor dev2 = new Desenvolvedor("Bob", "Desenvolvedor Júnior");

        Departamento departamentoDesenvolvimento = new Departamento("Departamento de Desenvolvimento");
        departamentoDesenvolvimento.adicionarEmpregado(dev1);
        departamentoDesenvolvimento.adicionarEmpregado(dev2);

        Desenvolvedor dev3 = new Desenvolvedor("Charlie", "Estagiário de Desenvolvimento");
        Desenvolvedor dev4 = new Desenvolvedor("David", "Desenvolvedor Pleno");

        Departamento departamentoQA = new Departamento("Departamento de QA");
        departamentoQA.adicionarEmpregado(dev3);
        departamentoQA.adicionarEmpregado(dev4);

        Departamento departamentoPrincipal = new Departamento("Departamento Principal");
        departamentoPrincipal.adicionarEmpregado(departamentoDesenvolvimento);
        departamentoPrincipal.adicionarEmpregado(departamentoQA);

        departamentoPrincipal.mostrarDetalhes();
    }
}
