package com.example.treeclasses.trunk;

import com.example.treeclasses.trees.assistingclasses.GrowingSpot;
import com.example.treeclasses.trees.treelimbs.trunks.ConiferTrunk;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConiferTrunkTests {

    @Test
    @DisplayName("Test if conifer trunk instantiates correctly")
    void createTrunkTest() throws Exception {
        ConiferTrunk trunk = new ConiferTrunk(2, 10, 0, 0.6, 0.05, 0.02);
        Assertions.assertNotEquals(trunk, null);
        Assertions.assertEquals(trunk.getMaxBeginningRadius(), 2);
        Assertions.assertEquals(trunk.getMaxLength(), 10);
        Assertions.assertEquals(trunk.getCurrentLength(), 0);
        Assertions.assertEquals(trunk.getBeginningRadius(), 0.2);
        Assertions.assertEquals(trunk.getBranches().values().size(), 0);
    }

    @Test
    @DisplayName("Test if adding branch to conifer trunk works correctly")
    void addBranchTest() throws Exception {
        ConiferTrunk trunk = new ConiferTrunk(2, 10, 0, 0.6, 0.05, 0.02);
        Assertions.assertEquals(trunk.getBranches().values().size(), 0);
        trunk.addBranch(new GrowingSpot(5, 0));
        Assertions.assertEquals(trunk.getBranches().values().size(), 0);
        trunk.addBranch(new GrowingSpot(0, 0));
        Assertions.assertEquals(trunk.getBranches().values().size(), 1);
    }

    @Test
    @DisplayName("Test if conifer trunk grows correctly")
    void growTest() throws Exception {
        ConiferTrunk trunk = new ConiferTrunk(2, 10, 0, 0.6, 0.05, 0.02);
        trunk.grow();
        Assertions.assertEquals(trunk.getCurrentLength(), 10 * 0.05);
        Assertions.assertEquals(trunk.getBeginningRadius(), 0.2  + (2.0 - 0.2) * 0.05);
    }
}
