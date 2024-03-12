import java.util.ArrayList;
import java.util.List;

class ChatRoom {
    private List<Observer> observers = new ArrayList<>();
    private List<String> messages = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void addMessage(String message) {
        messages.add(message);
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(messages.get(messages.size() - 1)); // Notifica com a última mensagem
        }
    }
}
