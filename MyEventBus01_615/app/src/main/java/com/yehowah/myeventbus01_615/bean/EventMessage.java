package com.yehowah.myeventbus01_615.bean;

public class EventMessage {
    private String message;
    public EventMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
