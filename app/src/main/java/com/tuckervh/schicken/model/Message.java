package com.tuckervh.schicken.model;

/**
 * Created by will on 1/28/18.
 */

public class Message {

    private String text;

    public Message(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
