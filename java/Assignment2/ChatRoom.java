package ChatRoom;

import java.util.*;

public class ChatRoom {
    private Set<User> activeUsers = new HashSet<>();
    private Map<User, List<Message<?>>> messageHistory = new HashMap<>();

    public void joinUser(User user) {
        activeUsers.add(user);
        messageHistory.putIfAbsent(user, new ArrayList<>());
        System.out.println(user.getUsername() + " joined the chat.");
    }

    public boolean isUserActive( User user){
        return activeUsers.contains(user);
    }

    public void sendMessage(User user, Message<?> message) {
        if (!activeUsers.contains(user)) {
            System.out.println("User not active: " + user.getUsername());
            return;
        }
        messageHistory.get(user).add(message);
        System.out.println(user.getUsername() + ": " + message.getContent());
    }

    public void displayActiveUsers() {
        List<User> sorted = new ArrayList<>(activeUsers);
        Collections.sort(sorted);
        System.out.println("----- Active Users ------");
        for (User user : sorted) {
            System.out.println("• " + user.getUsername());
        }
        System.out.println("====================");
    }

    public void displayMessages() {
        System.out.println("----- Message History -----");
        messageHistory.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                User user = entry.getKey();
                List<Message<?>> messages = entry.getValue();
                messages.stream()
                        .sorted(Comparator.comparing(Message::getTimestamp))
                        .forEach(msg -> System.out.println(user.getUsername() + ": " + msg));
            });
        System.out.println("========================");
    }
}
