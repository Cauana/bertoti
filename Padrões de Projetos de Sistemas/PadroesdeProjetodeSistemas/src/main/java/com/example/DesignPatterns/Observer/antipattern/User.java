package com.example.DesignPatterns.Observer.antipattern;

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received a new message: " + message);
    }
}