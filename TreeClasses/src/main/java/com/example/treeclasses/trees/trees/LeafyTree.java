package com.example.treeclasses.trees.trees;

import com.example.treeclasses.trees.trees.abstracts.AbstractLeafyTree;
import com.example.treeclasses.trees.treelimbs.trunks.LeafyTreeTrunk;

import java.util.logging.Logger;

public class LeafyTree extends AbstractLeafyTree {

    private static final Logger logger = Logger.getLogger(LeafyTree.class.getName());

    public LeafyTree() {
        //Grow by 5% of remaining possible length until reaching 60%, after that grow by 2% of max
        super(logger,"Leafy tree", new LeafyTreeTrunk(5, 20, 0, 0.6, 0.05, 0.02));
        logger.info(String.format("New Leafy tree %d created", System.identityHashCode(this)));
    }

    @Override
    public void grow() {
        logger.info(String.format("Leafy tree %d grows", System.identityHashCode(this)));
        trunk.grow();
        age += 1;
        switch(age%5){
            case 0:
            case 1:
            case 2:
                if(trunk.gotLeaves()){
                    changeLeafColor();
                }
                break;
            case 3:
                if(trunk.gotLeaves()){
                    dropLeaves();
                }
                break;
            case 4:
                if(trunk.gotBranches()){
                    growLeaves();
                }
                break;
            default:
                logger.warning("Something went wrong with tree age cycle");
                break;
        }
    }
}
