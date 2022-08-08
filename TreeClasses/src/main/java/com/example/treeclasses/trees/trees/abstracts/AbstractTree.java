package com.example.treeclasses.trees.trees.abstracts;

import com.example.treeclasses.trees.treelimbs.trunks.AbstractTrunk;

import java.util.logging.Logger;

public abstract class AbstractTree {

    protected final Logger logger;

    protected String species;
    protected int age;
    protected AbstractTrunk trunk;

    public AbstractTree(Logger logger, String species, AbstractTrunk trunk) {
        this.logger = logger;
        this.species = species;
        this.age = 0;
        this.trunk = trunk;
    }

    public abstract void grow();

    public boolean gotBranches() {
        return trunk.gotBranches();
    }

    public boolean gotLeaves() {
        return trunk.gotLeaves();
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AbstractTrunk getTrunk() {
        return trunk;
    }
}
