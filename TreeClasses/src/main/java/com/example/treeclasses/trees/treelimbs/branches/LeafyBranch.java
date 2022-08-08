package com.example.treeclasses.trees.treelimbs.branches;

import com.example.treeclasses.trees.leaves.AbstractLeaf;
import com.example.treeclasses.trees.leaves.Leaf;
import com.example.treeclasses.trees.assistingclasses.GrowingSpot;
import com.example.treeclasses.trees.treelimbs.AbstractWoodElement;

import java.util.*;
import java.util.logging.Logger;

public class LeafyBranch extends AbstractBranch {

    private static final Logger logger = Logger.getLogger(LeafyBranch.class.getName());

    public LeafyBranch(double maxBeginningRadius,
                       double maxLength,
                       double startingLength,
                       double steadyGrowThreshold,
                       double growPercentage,
                       double steadyPercentage) {

        super(logger, maxBeginningRadius, maxLength, startingLength, steadyGrowThreshold, growPercentage, steadyPercentage);
    }

    //Leafy tree should grow all leaves at once
    @Override
    protected void growNewElements(double preChangeLength) {
        if(preChangeLength < 0) {
            throw new IllegalArgumentException("Point before grow should not be lower than 0!");
        }
        if(preChangeLength > currentLength) {
            throw new IllegalArgumentException("Point before grow should not be higher than current!");
        }

        if(maxLength > 0.5){
            int numberOfBranches = branchesPerLength(currentLength - preChangeLength);
            for(int i=0;i<numberOfBranches;i++) {
                GrowingSpot position = AbstractWoodElement.getRandomPosition(preChangeLength, currentLength);

                addBranch(position);
            }
        }
    }

    @Override
    public void addBranch(GrowingSpot position) {
        if(position.getFromBranchOrigin() > currentLength){
            logger.warning(String.format("Branch %d - cannot add a branch on non-existing spot", System.identityHashCode(this)));
            return;
        }
        LeafyBranch toAdd = new LeafyBranch(radiusOnPosition(position.getFromBranchOrigin()), 0.4*maxLength, 0, steadyGrowThreshold, growPercentage, steadyPercentage);
        branches.put(position, toAdd);
        logger.info(String.format("New branch %d on branch %d, position: %.2f, angle %.2f",
                                  System.identityHashCode(toAdd),
                                  System.identityHashCode(this),
                                  position.getFromBranchOrigin(),
                                  position.getAround()));
    }

    @Override
    public void addLeaf(GrowingSpot position) {
        if(position.getFromBranchOrigin() > currentLength){
            logger.warning(String.format("Branch %d - cannot add a leaf on non-existing spot", System.identityHashCode(this)));
            return;
        }
        Leaf toAdd = new Leaf();
        leaves.put(position, toAdd);
    }

    public void changeLeafColor() {
        for (AbstractLeaf leaf : leaves.values()) {
            ((Leaf)leaf).advanceColor();
        }
        for (AbstractBranch branch : branches.values()) {
            ((LeafyBranch)branch).changeLeafColor();
        }
    }

    public void dropLeaves() {
        leaves = new HashMap<GrowingSpot, AbstractLeaf>();
        for (AbstractBranch branch : branches.values()) {
            ((LeafyBranch)branch).dropLeaves();
        }
    }

    public void growLeaves() {
        int numberOfLeaves = leavesPerLength(currentLength);
        if(numberOfLeaves > 0) {
            logger.info(String.format("%d new leaves added on branch %d", numberOfLeaves, System.identityHashCode(this)));
        }
        for(int i=0;i<numberOfLeaves;i++) {
            GrowingSpot position = AbstractWoodElement.getRandomPosition(0, currentLength);

            addLeaf(position);
        }
        for (AbstractBranch branch : branches.values()) {
            ((LeafyBranch)branch).growLeaves();
        }
    }
}
