package com.example.treeclasses.trees.leaves;

import com.example.treeclasses.trees.assistingclasses.LeafColor;

import java.util.logging.Logger;

import static com.example.treeclasses.trees.assistingclasses.LeafColor.GREEN;
import static com.example.treeclasses.trees.assistingclasses.LeafType.LEAF;

public class Leaf extends AbstractLeaf {

    private static final Logger logger = Logger.getLogger(Leaf.class.getName());

    private LeafColor color;

    public Leaf()  {
        super(logger, LEAF);
        this.color = GREEN;
    }

    public void advanceColor() {
        this.color = LeafColor.nextColor(color);
    }

    public LeafColor getColor() {
        return color;
    }

    public void setColor(LeafColor color) {
        this.color = color;
    }

}
