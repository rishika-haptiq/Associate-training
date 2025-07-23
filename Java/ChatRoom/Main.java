package ChatRoom;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        Scanner scanner = new Scanner(System.in);

        User rishika = new User("Rishika");
        User aryan = new User("Aryan");
        User neha = new User("Neha");

        chatRoom.joinUser(rishika);
        chatRoom.joinUser(aryan);
        chatRoom.joinUser(neha);

        chatRoom.displayActiveUsers();

        List <User> participants = Arrays.asList(rishika,aryan,neha);

                while (true) {
            System.out.print("\nEnter username to send message (or type 'exit' to end): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) break;

            User sender = participants.stream()
                    .filter(u -> u.getUsername().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);

            if (sender == null || !chatRoom.isUserActive(sender)) {
                System.out.println("!! User not found or not active.");
                continue;
            }

            System.out.print("Enter message type (TEXT/IMAGE/VIDEO/FILE): ");
            MessageType type;
            try {
                type = MessageType.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("!! Invalid type. Try again.");
                continue;
            }

            System.out.print("Enter your message: ");
            String content = scanner.nextLine();
            chatRoom.sendMessage(sender, new Message<>(content, type));
        }
        
        chatRoom.displayMessages();
    }
}

