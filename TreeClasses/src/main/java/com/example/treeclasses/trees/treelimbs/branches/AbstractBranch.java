package com.example.treeclasses.trees.treelimbs.branches;

import com.example.treeclasses.trees.leaves.AbstractLeaf;
import com.example.treeclasses.trees.treelimbs.AbstractWoodElement;
import com.example.treeclasses.trees.assistingclasses.GrowingSpot;

import java.util.*;
import java.util.logging.Logger;

public abstract class AbstractBranch extends AbstractWoodElement {

    protected Map<GrowingSpot, AbstractLeaf> leaves;

    public AbstractBranch(Logger logger,
                          double maxBeginningRadius,
                          double maxLength,
                          double startingLength,
                          double steadyGrowThreshold,
                          double growPercentage,
                          double steadyPercentage) {

        super(logger, maxBeginningRadius, maxLength, startingLength, steadyGrowThreshold, growPercentage, steadyPercentage);
        this.leaves = new HashMap<GrowingSpot,AbstractLeaf>();
    }

    @Override
    public abstract void addBranch(GrowingSpot position);

    public abstract void addLeaf(GrowingSpot position);

    @Override
    public void grow() {
        for (AbstractBranch branch : branches.values()) {
            branch.grow();
        }
        double preChangeLength = currentLength;
        if(currentLength <= steadyGrowThreshold*maxLength) {
            currentLength = currentLength + (maxLength - currentLength) * growPercentage;
            beginningRadius = beginningRadius + (maxBeginningRadius - beginningRadius) * growPercentage;
            logger.info(String.format("Branch %d grows from %.2f to %.2f", System.identityHashCode(this), preChangeLength, currentLength));

            growNewElements(preChangeLength);
        } else {
            currentLength = currentLength + steadyPercentage * maxLength;
            beginningRadius = beginningRadius + steadyPercentage * maxBeginningRadius;
            if(currentLength > maxLength){
                currentLength = maxLength;
                logger.info(String.format("Branch %d maximum length of %.2f was reached.", System.identityHashCode(this), currentLength));
            } else {
                logger.info(String.format("Branch %d grows from %.2f to %.2f", System.identityHashCode(this), preChangeLength, currentLength));
            }
            growNewElements(preChangeLength);
        }
    }

    public boolean gotBranches() {
        if(branches.values().size() != 0){
            return true;
        }
        return false;
    }

    public boolean gotLeaves() {
        if(leaves.values().size() != 0){
            return true;
        }
        for (AbstractBranch branch : branches.values()) {
            if(branch.gotLeaves()){
                return true;
            }
        }
        return false;
    }

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
        int numberOfLeaves = leavesPerLength(currentLength - preChangeLength);
        if(numberOfLeaves > 0) {
            logger.info(String.format("%d new leaves added on branch %d", numberOfLeaves, System.identityHashCode(this)));
        }
        for(int i=0;i<numberOfLeaves;i++) {
            GrowingSpot position = AbstractWoodElement.getRandomPosition(preChangeLength, currentLength);

            addLeaf(position);
        }
    }

    //Assuming no more than 2 branches per 0.33m of branch
    protected int branchesPerLength(double length) {
        if(length < 0) {
            throw new IllegalArgumentException("Length cannot not be lower than 0!");
        }
        Random r = new Random();
        return (int)(( 2 * 3 * length) * r.nextDouble());
    }

    //Assuming no more than 20 leaves per 1m of branch
    protected int leavesPerLength(double length) {
        if(length < 0) {
            throw new IllegalArgumentException("Length cannot not be lower than 0!");
        }
        Random r = new Random();
        return (int)((20 * length) * r.nextDouble());
    }

    //Calculate max radius for a new branch growing from a given point
    //Assuming max 60% of possible parent branch radius in this point
    protected double radiusOnPosition(double distanceFromBeginning) {
        return 0.6 * maxBeginningRadius * (distanceFromBeginning / maxLength);
    }

    public Map<GrowingSpot, AbstractLeaf> getLeaves() {
        return leaves;
    }
}
