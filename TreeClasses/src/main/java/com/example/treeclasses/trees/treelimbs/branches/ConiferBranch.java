package com.example.treeclasses.trees.treelimbs.branches;

import com.example.treeclasses.trees.leaves.Needle;
import com.example.treeclasses.trees.assistingclasses.GrowingSpot;

import java.util.logging.Logger;

public class ConiferBranch extends AbstractBranch {

    private static final Logger logger = Logger.getLogger(ConiferBranch.class.getName());

    public ConiferBranch(double maxBeginningRadius,
                         double maxLength,
                         double startingLength,
                         double steadyGrowThreshold,
                         double growPercentage,
                         double steadyPercentage) {

        super(logger, maxBeginningRadius, maxLength, startingLength, steadyGrowThreshold, growPercentage, steadyPercentage);
    }

    @Override
    public void addBranch(GrowingSpot position) {
        if(position.getFromBranchOrigin() > currentLength){
            logger.warning(String.format("Branch %d - cannot add a branch on non-existing spot", System.identityHashCode(this)));
            return;
        }
        ConiferBranch toAdd = new ConiferBranch(radiusOnPosition(position.getFromBranchOrigin()), 0.4 * maxLength, 0, steadyGrowThreshold, growPercentage, steadyPercentage);
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
            logger.warning(String.format("Branch %d - cannot add a needle on non-existing spot", System.identityHashCode(this)));
            return;
        }
        Needle toAdd = new Needle();
        leaves.put(position, toAdd);
    }
}
