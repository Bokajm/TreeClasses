package com.example.treeclasses.trees.treelimbs.trunks;

import com.example.treeclasses.trees.treelimbs.branches.ConiferBranch;
import com.example.treeclasses.trees.assistingclasses.GrowingSpot;

import java.util.logging.Logger;

public class ConiferTrunk extends AbstractTrunk {

    private static final Logger logger = Logger.getLogger(ConiferTrunk.class.getName());

    public ConiferTrunk(double maxBeginningRadius,
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
            logger.warning(String.format("Trunk %d - cannot add a branch on non-existing spot", System.identityHashCode(this)));
            return;
        }
        ConiferBranch toAdd = new ConiferBranch(radiusOnPosition(position.getFromBranchOrigin()), 0.4*maxLength, 0, 0.8, 0.15, 0.03);
        branches.put(position, toAdd);
        logger.info(String.format("New branch %d on trunk %d, position: %.2f, angle %.2f",
                                  System.identityHashCode(toAdd),
                                  System.identityHashCode(this),
                                  position.getFromBranchOrigin(),
                                  position.getAround()));
    }
}
