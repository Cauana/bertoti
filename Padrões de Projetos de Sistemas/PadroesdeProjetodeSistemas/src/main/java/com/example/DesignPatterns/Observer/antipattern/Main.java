package com.example.DesignPatterns.Observer.antipattern;

public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        chatRoom.sendMessage("Hello, everyone!");
        chatRoom.sendMessage("How are you doing?");
    }
}