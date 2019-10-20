package bo.model;

import java.time.LocalDate;

public class Message {

    private int id;
    private String content;
    private LocalDate messageCreated;
    private LocalDate messageRead;
    private String sender;
    private String receiver;

    public Message(int id, String content, LocalDate messageRead, String sender, String receiver) {
        this.id = id;
        this.content = content;
        this.messageCreated = LocalDate.now();
        this.messageRead = messageRead;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Message(String content, LocalDate messageRead, String sender, String receiver) {
        this.content = content;
        this.messageCreated = LocalDate.now();
        this.messageRead = messageRead;
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getMessageCreated() {
        return messageCreated;
    }

    public void setMessageCreated(LocalDate messageCreated) {
        this.messageCreated = messageCreated;
    }

    public LocalDate getMessageRead() {
        return messageRead;
    }

    public void setMessageRead(LocalDate messageRead) {
        this.messageRead = messageRead;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
