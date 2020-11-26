package com.example.UserBlockGenerator.controllers;

import com.example.UserBlockGenerator.models.Block;
import com.example.UserBlockGenerator.models.User;
import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BlockController {
    private List<Block> blocks = new ArrayList<>();

    @PostMapping("/block")
    public List<Block> postBlock(@RequestBody User user) {
        setBlock(user);
        return blocks;
    }

    private void setBlock(User user) {
        Block blockAux = new Block(user);
        if (blocks.size() > 0)
            blockAux.height = blocks.size();

        blockAux.hash = Hashing.sha256().hashObject(user, PersonFunnel.INSTANCE).toString();
        blocks.add(blockAux);
    }
}

enum PersonFunnel implements Funnel<User> {
    INSTANCE;
    public void funnel(User user, PrimitiveSink into) {
        into.putLong(user.getId())
                .putUnencodedChars(user.getName());
    }
}
