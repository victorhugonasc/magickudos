package org.example.kudos.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

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
    private String stored;


    public Kudo(String id, String sender, String receiver, String message, String layout) {
        super();
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.layout = layout;
        this.date = new Date();
        this.stored = "no";
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
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


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public String getLayout() {
        return layout;
    }


    public void setLayout(String layout) {
        this.layout = layout;
    }


    public String getStored() {
        return stored;
    }


    public void setStored(String stored) {
        this.stored = stored;
    }



}
