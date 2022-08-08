package com.example.treeclasses.trees.treelimbs;

import com.example.treeclasses.trees.treelimbs.branches.AbstractBranch;
import com.example.treeclasses.trees.assistingclasses.GrowingSpot;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

public abstract class AbstractWoodElement {

    protected final Logger logger;
    protected final double maxLength;
    protected double currentLength;

    protected final double maxBeginningRadius;
    protected double beginningRadius;
    protected double endRadius;

    protected double steadyGrowThreshold;
    protected double growPercentage;
    protected double steadyPercentage;

    protected Map<GrowingSpot, AbstractBranch> branches;

    public AbstractWoodElement(Logger logger,
                               double maxBeginningRadius,
                               double maxLength,
                               double startingLength,
                               double steadyGrowThreshold,
                               double growPercentage,
                               double steadyPercentage) {

        if(maxBeginningRadius < 0) {
            throw new IllegalArgumentException("Radius of an element cannot be less than 0!");
        }
        if(maxLength < 0) {
            throw new IllegalArgumentException("Maximum length of element cannot be less than 0!");
        }
        if(startingLength < 0) {
            throw new IllegalArgumentException("Starting length of element cannot be less than 0!");
        }
        if(startingLength > maxLength) {
            throw new IllegalArgumentException("Maximum length of element cannot be less its starting length!");
        }
        if(steadyGrowThreshold < 0 || steadyGrowThreshold > 1) {
            throw new IllegalArgumentException("Steady grow threshold should be a number between 0 and 1!");
        }
        if(growPercentage < 0 || growPercentage > 1) {
            throw new IllegalArgumentException("Grow percentage should be a number between 0 and 1!");
        }
        if(steadyPercentage < 0 || steadyPercentage > 1) {
            throw new IllegalArgumentException("Steady percentage should be a number between 0 and 1!");
        }

        this.logger = logger;
        this.maxBeginningRadius = maxBeginningRadius;
        this.maxLength = maxLength;
        this.currentLength = startingLength;

        this.beginningRadius = maxBeginningRadius * 0.1;
        this.endRadius = maxBeginningRadius * 0.05;

        this.steadyGrowThreshold = steadyGrowThreshold;
        this.growPercentage = growPercentage;
        this.steadyPercentage = steadyPercentage;

        this.branches = new HashMap<GrowingSpot, AbstractBranch>();
    }

    public abstract void grow();

    public abstract void addBranch(GrowingSpot position);

    protected abstract double radiusOnPosition(double distanceFromBeginning);

    public static GrowingSpot getRandomPosition(double beginning, double end) {
        if(beginning > end) {
            throw new IllegalArgumentException("Ending of interval cannot be less than beginning!");
        }
        if(beginning < 0 || end < 0) {
            throw new IllegalArgumentException("Beginning and end of interval should not be less than 0!");
        }

        Random r = new Random();

        double lengthPosition = beginning + (end - beginning) * r.nextDouble();
        double anglePosition = 360 * r.nextDouble();

        return new GrowingSpot(lengthPosition, anglePosition);
    }

    public double getMaxLength() {
        return maxLength;
    }

    public double getMaxBeginningRadius() {
        return maxBeginningRadius;
    }

    public Map<GrowingSpot, AbstractBranch> getBranches() {
        return branches;
    }

    public double getCurrentLength() {
        return currentLength;
    }

    public void setCurrentLength(double currentLength) {
        this.currentLength = currentLength;
    }

    public double getBeginningRadius() {
        return beginningRadius;
    }

    public void setBeginningRadius(double beginningRadius) {
        this.beginningRadius = beginningRadius;
    }

    public double getEndRadius() {
        return endRadius;
    }

    public void setEndRadius(double endRadius) {
        this.endRadius = endRadius;
    }
}
