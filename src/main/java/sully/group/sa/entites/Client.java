package sully.group.sa.entites;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Column(unique = true)
    private String email;
    private String phone;
    private Instant creation;

    @Column(name = "mis_a_jour")
    private Date misAJour;

    public Client() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Client(int id, String email, String phone, Instant creation, Date misAJour) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.creation = creation;
        this.misAJour = misAJour;
    }

    public Client(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getCreation() {
        return creation;
    }

    public void setCreation(Instant creation) {
        this.creation = creation;
    }

    public Date getMisAJour() {
        return misAJour;
    }

    public void setMisAJour(Date misAJour) {
        this.misAJour = misAJour;
    }
}
