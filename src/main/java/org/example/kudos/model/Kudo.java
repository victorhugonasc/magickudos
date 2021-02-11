package org.example.kudos.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Kudo {

    @Id
    private String id;

    @NotBlank()
    private String sender;

    @NotBlank(message = "Receiver is mandatory")
    private String receiver;

    @NotBlank(message = "Message is mandatory")
    private String message;

    @NotBlank(message = "Layout is mandatory")
    private String layout;

    private Date date;
    private String olderKudo;
    private boolean assigned;

    public Kudo(String id, String sender, String receiver, String message, String layout) {
        super();
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.layout = layout;
        this.olderKudo = "no";
        this.assigned = false;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
    public String getReceiver() { return receiver; }
    public void setReceiver(String receiver) { this.receiver = receiver; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getLayout() { return layout; }
    public void setLayout(String layout) { this.layout = layout; }
    public String getOlderKudo() { return olderKudo; }
    public void setOlderKudo(String olderKudo) { this.olderKudo = olderKudo; }
    public boolean isAssigned() { return assigned; }
    public void setAssigned(boolean assigned) { this.assigned = assigned; }
}
