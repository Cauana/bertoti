public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        // Criando usuários
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        // Adicionando usuários à sala de bate-papo
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        // Simulando o envio de mensagens
        chatRoom.sendMessage("Hello, everyone!");
        chatRoom.sendMessage("How are you doing?");
    }
}