package com.example.treeclasses.trees.leaves;

import com.example.treeclasses.trees.assistingclasses.LeafType;

import java.util.logging.Logger;

public abstract class AbstractLeaf {

    protected final Logger logger;

    private final LeafType type;

    protected AbstractLeaf(Logger logger, LeafType type) {
        this.logger = logger;
        this.type = type;
    }

    public LeafType getType() {
        return type;
    }

}
