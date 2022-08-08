package com.example.treeclasses.branch;

import com.example.treeclasses.trees.assistingclasses.GrowingSpot;
import com.example.treeclasses.trees.treelimbs.branches.ConiferBranch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ConiferBranchTests {

    @Test
    @DisplayName("Test if conifer branch instantiates correctly")
    void createBranchTest() throws Exception {
        ConiferBranch branch = new ConiferBranch(2, 10, 0, 0.8, 0.15, 0.03);
        Assertions.assertNotEquals(branch, null);
        Assertions.assertEquals(branch.getMaxBeginningRadius(), 2);
        Assertions.assertEquals(branch.getMaxLength(), 10);
        Assertions.assertEquals(branch.getCurrentLength(), 0);
        Assertions.assertEquals(branch.getBeginningRadius(), 0.2);
        Assertions.assertEquals(branch.getBranches().values().size(), 0);
        Assertions.assertEquals(branch.getLeaves().values().size(), 0);
    }

    @Test
    @DisplayName("Test if adding branch to conifer branch works correctly")
    void addBranchTest() throws Exception {
        ConiferBranch branch = new ConiferBranch(2, 10, 0, 0.8, 0.15, 0.03);
        Assertions.assertEquals(branch.getBranches().values().size(), 0);
        branch.addBranch(new GrowingSpot(5, 0));
        Assertions.assertEquals(branch.getBranches().values().size(), 0);
        branch.addBranch(new GrowingSpot(0, 0));
        Assertions.assertEquals(branch.getBranches().values().size(), 1);
    }

    @Test
    @DisplayName("Test if adding needle to conifer branch works correctly")
    void addNeedleTest() throws Exception {
        ConiferBranch branch = new ConiferBranch(2, 10, 0, 0.8, 0.15, 0.03);
        Assertions.assertEquals(branch.getLeaves().values().size(), 0);
        branch.addLeaf(new GrowingSpot(5, 0));
        Assertions.assertEquals(branch.getLeaves().values().size(), 0);
        branch.addLeaf(new GrowingSpot(0, 0));
        Assertions.assertEquals(branch.getLeaves().values().size(), 1);
    }

    @Test
    @DisplayName("Test if conifer branch grows correctly")
    void growTest() throws Exception {
        ConiferBranch branch = new ConiferBranch(2, 10, 0, 0.8, 0.15, 0.03);
        branch.grow();
        Assertions.assertEquals(branch.getCurrentLength(), 10 * 0.15);
        Assertions.assertEquals(branch.getBeginningRadius(), 0.2  + (1.8 * 0.15));
    }

}
