package com.example.treeclasses.trees.trees.abstracts;

import com.example.treeclasses.trees.assistingclasses.LeafColor;
import com.example.treeclasses.trees.leaves.AbstractLeaf;
import com.example.treeclasses.trees.leaves.Leaf;
import com.example.treeclasses.trees.treelimbs.branches.AbstractBranch;
import com.example.treeclasses.trees.treelimbs.branches.LeafyBranch;
import com.example.treeclasses.trees.treelimbs.trunks.AbstractTrunk;

import java.util.logging.Logger;

public abstract class AbstractLeafyTree extends AbstractTree {

    public AbstractLeafyTree(Logger logger, String species, AbstractTrunk trunk) {
        super(logger, species, trunk);
    }

    @Override
    public abstract void grow();

    public void dropLeaves() {
        logger.info(String.format("Tree %d dropping leaves", System.identityHashCode(this)));
        for (AbstractBranch branch : this.trunk.getBranches().values()) {
            ((LeafyBranch)branch).dropLeaves();
        }
    }

    public void growLeaves() {
        logger.info(String.format("Tree %d growing leaves", System.identityHashCode(this)));
        for (AbstractBranch branch : this.trunk.getBranches().values()) {
            ((LeafyBranch)branch).growLeaves();
        }
    }

    public LeafColor checkLeafColor() {
        LeafColor color = null;
        for(AbstractBranch branch : trunk.getBranches().values()) {
            for (AbstractLeaf leaf : branch.getLeaves().values()) {
                color = ((Leaf)leaf).getColor();
            }
        }
        return color;
    }

    public void changeLeafColor() {
        for (AbstractBranch branch : this.trunk.getBranches().values()) {
            ((LeafyBranch)branch).changeLeafColor();
        }
        if(checkLeafColor() != null){
            logger.info(String.format("Tree %d changing leaf color to %s", System.identityHashCode(this), checkLeafColor().toString()));
        }
    }
}
