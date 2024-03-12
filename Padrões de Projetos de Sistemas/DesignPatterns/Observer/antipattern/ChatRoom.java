import java.util.ArrayList;
import java.util.List;

class ChatRoom {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void sendMessage(String message) {
        for (User user : users) {
            user.receiveMessage(message); // Notifica cada usuário individualmente
        }
    }
}