package com.mahendracandi.spring5mvcrestservicehelloworld.domain;

public class Message {
    private String message;
    private String text;

    public Message(String message, String text) {
        this.message = message;
        this.text = text;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
