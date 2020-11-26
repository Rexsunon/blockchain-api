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

    /**
     * Create block request, Accepts the user's credencals as user body
     *
     * @param user Takes user model as request body
     * @return an array of blocks (the block chain)
     */
    @PostMapping("/block")
    public List<Block> postBlock(@RequestBody User user) {
        setBlock(user); // Pass the request body (user model) to the setBlock method
        return blocks;
    }

    /**
     * A method that accepts a user model and creates a block
     *
     * @param user accepts a user model
     */
    private void setBlock(User user) {
        Block blockAux = new Block(user); // Create new block
        if (blocks.size() > 0) { // Check if the length of the block chain is greater than zero
            blockAux.height = blocks.size(); // Add the size of the block as the new height of the block
            blockAux.previousBlockHash = blocks.get(blocks.size() - 1).hash; // Set the previous hash
        }
        blockAux.hash = Hashing.sha256().hashObject(user, UserFunnel.INSTANCE).toString(); // Hash the user model
        blocks.add(blockAux); // Add block to block chain
    }
}

enum UserFunnel implements Funnel<User> {
    INSTANCE;

    public void funnel(User user, PrimitiveSink into) {
        into.putLong(user.getId())
                .putUnencodedChars(user.getName());
    }
}
