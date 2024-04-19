package com.example.DesignPatterns.Observer.pattern;

public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        // Criando usuários
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        // Adicionando usuários como observadores da sala de bate-papo
        chatRoom.addObserver(user1);
        chatRoom.addObserver(user2);
        chatRoom.addObserver(user3);

        // Simulando o envio de mensagens
        chatRoom.addMessage("Hello, everyone!");
        chatRoom.addMessage("How are you doing?");
    }
}
