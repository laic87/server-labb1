package db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "MESSAGE")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "MESSAGECREATED", nullable = false)
    private LocalDate messageCreated;

    @Column(name = "MESSAGEREAD", nullable = false)
    private LocalDate messageRead;

    @Column(name = "SENDER", nullable = false)
    private String sender;

    @Column(name = "RECEIVER", nullable = false)
    private String receiver;

    public Message() { }

    public Message(int id, String content, LocalDate messageCreated, LocalDate messageRead, String sender, String receiver) {
        this.id = id;
        this.content = content;
        this.messageCreated = messageCreated;
        this.messageRead = messageRead;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Message(String content, LocalDate messageCreated, LocalDate messageRead, String sender, String receiver) {
        this.content = content;
        this.messageCreated = messageCreated;
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
