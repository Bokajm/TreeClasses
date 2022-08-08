package com.example.treeclasses.trees.treelimbs.trunks;

import com.example.treeclasses.trees.treelimbs.branches.AbstractBranch;
import com.example.treeclasses.trees.treelimbs.AbstractWoodElement;
import com.example.treeclasses.trees.assistingclasses.GrowingSpot;

import java.util.Random;
import java.util.logging.Logger;

public abstract class AbstractTrunk extends AbstractWoodElement {

    public AbstractTrunk(Logger logger,
                         double maxBeginningRadius,
                         double maxLength,
                         double startingLength,
                         double steadyGrowThreshold,
                         double growPercentage,
                         double steadyPercentage) {

        super(logger, maxBeginningRadius, maxLength, startingLength, steadyGrowThreshold, growPercentage, steadyPercentage);
    }


    @Override
    public abstract void addBranch(GrowingSpot position);

    @Override
    public void grow() {
        if(steadyGrowThreshold < 0 || steadyGrowThreshold > 1) {
            throw new IllegalArgumentException("Steady grow threshold should be a number between 0 and 1!");
        }
        if(growPercentage < 0 || growPercentage > 1) {
            throw new IllegalArgumentException("Grow percentage should be a number between 0 and 1!");
        }
        if(steadyPercentage < 0 || steadyPercentage > 1) {
            throw new IllegalArgumentException("Steady percentage should be a number between 0 and 1!");
        }

        for (AbstractBranch branch : branches.values()) {
            branch.grow();
        }
        double preChangeLength = currentLength;
        if(currentLength <= steadyGrowThreshold*maxLength) {
            currentLength = currentLength + (maxLength - currentLength)*growPercentage;
            beginningRadius = beginningRadius + (maxBeginningRadius - beginningRadius) * growPercentage;
            logger.info(String.format("Trunk %d grows from %.2f to %.2f", System.identityHashCode(this), preChangeLength, currentLength));

            if(preChangeLength > 0.20*maxLength) {
                growBranches(preChangeLength);
            }
        } else {
            currentLength = currentLength + steadyPercentage*maxLength;
            beginningRadius = beginningRadius + steadyPercentage*maxBeginningRadius;
            if(currentLength > maxLength){
                currentLength = maxLength;
                logger.info(String.format("Trunk %d maximum length of %.2f was reached.", System.identityHashCode(this), currentLength));
            } else {
                logger.info(String.format("Trunk %d grows from %.2f to %.2f", System.identityHashCode(this), preChangeLength, currentLength));
            }
            growBranches(preChangeLength);
        }
    }

    public boolean gotBranches() {
        if(branches.values().size() != 0){
            return true;
        }
        return false;
    }

    public boolean gotLeaves() {
        for (AbstractBranch branch : branches.values()) {
            if(branch.gotLeaves()){
                return true;
            }
        }
        return false;
    }

    protected void growBranches(double preChangeLength) {
        Random r = new Random();
        double numberOfBranches = branchesPerLength(currentLength - preChangeLength);
        for(int i=0;i<numberOfBranches;i++) {
            GrowingSpot position = AbstractWoodElement.getRandomPosition(preChangeLength, currentLength);
            addBranch(position);
        }
    }

    //Assuming no more than 2 branches per 0.33m of branch
    private int branchesPerLength(double length) {
        Random r = new Random();
        return (int)((2*3*length) * r.nextDouble());
    }

    //Calculate max radius for a new branch growing from a given point
    //Assuming max 30% of possible parent branch radius in this point
    protected double radiusOnPosition(double distanceFromBeginning) {
        return 0.3 * maxBeginningRadius * (distanceFromBeginning / maxLength);
    }

}
