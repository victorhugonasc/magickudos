package Model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Kudo {

    @Id
    private String id;

    private String sender;
    private String receiver;
    private String message;
    private Date date;
    private int layout;
    private String stored;


    public Kudo(String id, String sender, String receiver, String message, Date date, int layout) {
        super();
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.date = date;
        this.layout = layout;
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


    public int getLayout() {
        return layout;
    }


    public void setLayout(int layout) {
        this.layout = layout;
    }


    public String getStored() {
        return stored;
    }


    public void setStored(String stored) {
        this.stored = stored;
    }



}
