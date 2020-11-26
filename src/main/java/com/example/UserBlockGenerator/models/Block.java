package com.example.UserBlockGenerator.models;

import java.util.Date;

public class Block {
    private String hash = "";
    private long height;
    private final User body;
    private Date time;

    public Block(String hash, long height, User body, Date time) {
        this.hash = hash;
        this.height = height;
        this.body = body;
        this.time = time;
    }

    public Block(User body) {
        this.body = body;
    }

    public String getHash() {
        return hash;
    }

    public long getHeight() {
        return height;
    }

    public User getBody() {
        return body;
    }

    public Date getTime() {
        return time;
    }
}
