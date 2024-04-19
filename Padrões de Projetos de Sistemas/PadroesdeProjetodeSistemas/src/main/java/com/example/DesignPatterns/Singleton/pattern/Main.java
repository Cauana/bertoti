package com.example.DesignPatterns.Singleton.pattern;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = Empresa.getEmpresa();
        System.out.println(empresa.getNome());
        System.out.println(empresa.getRepresentante());
    }
}