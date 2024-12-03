package cz.wz.marysidy.spring_crypto.controller.dto;

import java.sql.Timestamp;

public class IdError {
    private String text;
    private Timestamp timestamp;

    public IdError(String text, Timestamp timestamp) {
        this.text = text;
        this.timestamp = timestamp;
    }

    public IdError() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
