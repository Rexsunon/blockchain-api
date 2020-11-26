package com.example.UserBlockGenerator.models;

import java.util.Date;

public class Block {
    public String hash = "";
    public long height;
    private final User body;
    private long time = new Date().getTime();

    public Block(String hash, long height, User body, long time) {
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

    public long getTime() {
        return time;
    }
}
