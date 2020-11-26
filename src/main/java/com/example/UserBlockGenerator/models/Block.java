package com.example.UserBlockGenerator.models;

import java.util.Date;

public class Block {
    public String hash = "";
    public long height;
    private final User body;
    private long time = new Date().getTime();
    public String previousBlockHash = "";

    public Block(String hash, long height, User body, long time, String previousBlockHash) {
        this.hash = hash;
        this.height = height;
        this.body = body;
        this.time = time;
        this.previousBlockHash = previousBlockHash;
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

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }
}
