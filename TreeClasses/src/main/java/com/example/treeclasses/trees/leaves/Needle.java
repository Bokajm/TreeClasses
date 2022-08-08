package com.example.treeclasses.trees.leaves;

import java.util.logging.Logger;

import static com.example.treeclasses.trees.assistingclasses.LeafType.NEEDLE;

public class Needle extends AbstractLeaf {

    private static final Logger logger = Logger.getLogger(Needle.class.getName());

    public Needle() {
        super(logger, NEEDLE);
    }
}
