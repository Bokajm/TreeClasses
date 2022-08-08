package com.example.treeclasses.trees.trees.abstracts;

import com.example.treeclasses.trees.treelimbs.trunks.AbstractTrunk;

import java.util.logging.Logger;

public abstract class AbstractConifer extends AbstractTree {

    public AbstractConifer(Logger logger, String species, AbstractTrunk trunk) {
        super(logger, species, trunk);
    }

    @Override
    public abstract void grow();
}
