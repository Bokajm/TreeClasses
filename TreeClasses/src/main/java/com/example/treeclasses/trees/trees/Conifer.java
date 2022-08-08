package com.example.treeclasses.trees.trees;

import com.example.treeclasses.trees.trees.abstracts.AbstractConifer;
import com.example.treeclasses.trees.treelimbs.trunks.ConiferTrunk;

import java.util.logging.Logger;

public class Conifer extends AbstractConifer {

    private static final Logger logger = Logger.getLogger(Conifer.class.getName());

    public Conifer() {
        //Grow by 5% of remaining possible length until reaching 60%, after that grow by 2% of max
        super(logger,"Conifer", new ConiferTrunk(3, 12, 0, 0.6, 0.05, 0.02));
        logger.info(String.format("New Conifer %d created", System.identityHashCode(this)));
    }

    @Override
    public void grow() {
        logger.info(String.format("Conifer %d grows", System.identityHashCode(this)));
        trunk.grow();
        age += 1;
    }
}
