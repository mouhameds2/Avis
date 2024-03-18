package sully.group.sa.entites;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import sully.group.sa.entites.enums.SentimentType;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "sentiment")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    private SentimentType type;
@ManyToOne(cascade = {PERSIST, MERGE})
@JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String message, SentimentType type, Client client) {
        this.id = id;
        this.message = message;
        this.type = type;
        this.client = client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(SentimentType type) {
        this.type = type;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public SentimentType getType() {
        return type;
    }

    public Client getClient() {
        return client;
    }

}
