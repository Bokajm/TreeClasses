package com.example.treeclasses.tree;

import com.example.treeclasses.trees.assistingclasses.LeafColor;
import com.example.treeclasses.trees.trees.LeafyTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LeafyTreeTests {

    @Test
    @DisplayName("Test if leafy tree instantiates correctly")
    void createConiferTest() throws Exception {
        LeafyTree tree = new LeafyTree();
        Assertions.assertNotEquals(tree, null);
        Assertions.assertNotEquals(tree.getTrunk(), null);
        Assertions.assertEquals(tree.getAge(), 0);
        Assertions.assertEquals(tree.getSpecies(), "Leafy tree");
    }

    @Test
    @DisplayName("Test if leafy tree changes age correctly")
    void ageTest() throws Exception {
        LeafyTree tree = new LeafyTree();
        Assertions.assertEquals(tree.getAge(), 0);
        tree.grow();
        Assertions.assertEquals(tree.getAge(), 1);
    }

    @Test
    @DisplayName("Test if leafy tree drops leaves correctly")
    void dropLeavesTest() throws Exception {
        LeafyTree tree = new LeafyTree();
        while(!tree.gotLeaves()){
            tree.grow();
        }
        Assertions.assertTrue(tree.gotLeaves());
        tree.dropLeaves();
        Assertions.assertFalse(tree.gotLeaves());
    }

    @Test
    @DisplayName("Test if leafy tree changes leaf colors correctly")
    void changeLeafColorTest() throws Exception {
        LeafyTree tree = new LeafyTree();
        //Make sure there are leaves
        while(!tree.gotLeaves()){
            tree.grow();
        }
        Assertions.assertEquals(tree.checkLeafColor(), LeafColor.GREEN);
        tree.grow();
        Assertions.assertEquals(tree.checkLeafColor(), LeafColor.YELLOW);
        tree.grow();
        Assertions.assertEquals(tree.checkLeafColor(), LeafColor.RED);
        tree.grow();
        Assertions.assertEquals(tree.checkLeafColor(), LeafColor.BROWN);
    }

    @Test
    @DisplayName("Test validity of leafy tree full leaf life cycle")
    void treeLeafCycleTest() throws Exception {
        LeafyTree tree = new LeafyTree();
        while(!tree.gotLeaves()){
            tree.grow();
        }
        Assertions.assertEquals(tree.checkLeafColor(), LeafColor.GREEN);
        tree.grow();
        Assertions.assertEquals(tree.checkLeafColor(), LeafColor.YELLOW);
        tree.grow();
        Assertions.assertEquals(tree.checkLeafColor(), LeafColor.RED);
        tree.grow();
        Assertions.assertEquals(tree.checkLeafColor(), LeafColor.BROWN);
        tree.grow();
        Assertions.assertFalse(tree.gotLeaves());
        tree.grow();
        Assertions.assertTrue(tree.gotLeaves());
    }
}
