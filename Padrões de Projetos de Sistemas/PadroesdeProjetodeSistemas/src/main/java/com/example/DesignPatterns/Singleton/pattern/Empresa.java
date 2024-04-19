package com.example.DesignPatterns.Singleton.pattern;

public class Empresa {
    private String nome = "Banco do Brasil";
    private String representante = "Cauana";

    private static Empresa empresa;

    private Empresa() {
    }

    public static Empresa getEmpresa() {
        if (empresa == null) {
            empresa = new Empresa();
        }
        return empresa;
    }

    public String getNome() {
        return nome;
    }

    public String getRepresentante() {
        return representante;
    }
    
}