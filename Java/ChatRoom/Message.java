package ChatRoom;

import java.time.LocalDateTime;

public class Message<T> {
    private T content;
    private LocalDateTime timestamp;
    private MessageType type;

    public Message(T content, MessageType type) {
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.type = type;
    }

    public T getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public MessageType getType() { return type; }

    @Override
    public String toString() {
        return "[" + timestamp + "] (" + type + "): " + content;
    }
}
