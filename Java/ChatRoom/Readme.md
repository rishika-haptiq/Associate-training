# ChatRoom Simulation App

A real-time chat room simulation in Java that allows users to join, send messages of various types, and stores message history.

## Features

- Users can join the chat room.
- Supports multiple message types: TEXT, IMAGE, VIDEO, FILE.
- Stores active users using a `Set`.
- Maintains message history using a `Map<User, List<Message>>`.
- Messages are sorted by timestamp.
- Users are displayed in alphabetical order.
- Uses a generic `Message<T>` class for message content.

## How to Run

1. **Compile all Java files:**
   ```sh
   javac ChatRoom/*.java
   ```

2. **Run the application:**
   ```sh
   java ChatRoom.Main
   ```

3. **Follow the prompts** to send messages as different users.

## Code Structure

- `User.java` — Represents a user in the chat room.
- `Message.java` — Generic class for