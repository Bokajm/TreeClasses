package com.example.treeclasses.branch;

import com.example.treeclasses.trees.assistingclasses.GrowingSpot;
import com.example.treeclasses.trees.assistingclasses.LeafColor;
import com.example.treeclasses.trees.leaves.Leaf;
import com.example.treeclasses.trees.treelimbs.branches.LeafyBranch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LeafyBranchTests {

    @Test
    @DisplayName("Test if leafy branch instantiates correctly")
    void createBranchTest() throws Exception {
        LeafyBranch branch = new LeafyBranch(2, 10, 0, 0.8, 0.15, 0.03);
        Assertions.assertNotEquals(branch, null);
        Assertions.assertEquals(branch.getMaxBeginningRadius(), 2);
        Assertions.assertEquals(branch.getMaxLength(), 10);
        Assertions.assertEquals(branch.getCurrentLength(), 0);
        Assertions.assertEquals(branch.getBeginningRadius(), 0.2);
        Assertions.assertEquals(branch.getBranches().values().size(), 0);
        Assertions.assertEquals(branch.getLeaves().values().size(), 0);
    }

    @Test
    @DisplayName("Test if adding branch to leafy branch works correctly")
    void addBranchTest() throws Exception {
        LeafyBranch branch = new LeafyBranch(2, 10, 0, 0.8, 0.15, 0.03);
        Assertions.assertEquals(branch.getBranches().values().size(), 0);
        branch.addBranch(new GrowingSpot(5, 0));
        Assertions.assertEquals(branch.getBranches().values().size(), 0);
        branch.addBranch(new GrowingSpot(0, 0));
        Assertions.assertEquals(branch.getBranches().values().size(), 1);
    }

    @Test
    @DisplayName("Test if adding leaf to leafy branch works correctly")
    void addNeedleTest() throws Exception {
        LeafyBranch branch = new LeafyBranch(2, 10, 0, 0.8, 0.15, 0.03);
        Assertions.assertEquals(branch.getLeaves().values().size(), 0);
        branch.addLeaf(new GrowingSpot(5, 0));
        Assertions.assertEquals(branch.getLeaves().values().size(), 0);
        branch.addLeaf(new GrowingSpot(0, 0));
        Assertions.assertEquals(branch.getLeaves().values().size(), 1);
    }

    @Test
    @DisplayName("Test if leafy branch grows")
    void growTest() throws Exception {
        LeafyBranch branch = new LeafyBranch(2, 10, 0, 0.8, 0.15, 0.03);
        branch.grow();
        Assertions.assertEquals(branch.getCurrentLength(), 10 * 0.15);
        Assertions.assertEquals(branch.getBeginningRadius(), 0.2  + (1.8 * 0.15));
    }

    @Test
    @DisplayName("Test if leafy branch grows leaves correctly")
    void growLeavesTest() throws Exception {
        LeafyBranch branch = new LeafyBranch(2, 10, 0, 0.8, 0.15, 0.03);
        //make sure enough space to grow leaves (almost) certainly
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        Assertions.assertFalse(branch.gotLeaves());
        branch.growLeaves();
        Assertions.assertTrue(branch.gotLeaves());
    }

    @Test
    @DisplayName("Test if leafy branch drops leaves correctly")
    void dropLeavesTest() throws Exception {
        LeafyBranch branch = new LeafyBranch(2, 10, 0, 0.8, 0.15, 0.03);
        //make sure enough space to grow leaves (almost) certainly
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        Assertions.assertFalse(branch.gotLeaves());
        branch.growLeaves();
        Assertions.assertTrue(branch.gotLeaves());
        branch.dropLeaves();
        Assertions.assertFalse(branch.gotLeaves());
    }

    @Test
    @DisplayName("Test if leafy branch changes color of the leaves correctly")
    void leafColorTest() throws Exception {
        LeafyBranch branch = new LeafyBranch(2, 10, 0, 0.8, 0.15, 0.03);
        //make sure enough space to grow leaves (almost) certainly
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        branch.grow();
        Assertions.assertFalse(branch.gotLeaves());
        branch.growLeaves();
        Assertions.assertTrue(branch.gotLeaves());
        Assertions.assertEquals(((Leaf)(branch.getLeaves().values().iterator().next())).getColor(), LeafColor.GREEN);
        branch.changeLeafColor();
        Assertions.assertNotEquals(((Leaf)(branch.getLeaves().values().iterator().next())).getColor(), LeafColor.GREEN);
    }


}
