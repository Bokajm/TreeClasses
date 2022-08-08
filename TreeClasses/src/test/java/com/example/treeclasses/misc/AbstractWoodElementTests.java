package com.example.treeclasses.misc;

import com.example.treeclasses.trees.assistingclasses.GrowingSpot;
import com.example.treeclasses.trees.treelimbs.AbstractWoodElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AbstractWoodElementTests {

    @Test
    @DisplayName("Test if static method for random position works correctly")
    void getRandomPositionTest() throws Exception {
        for(int i=0; i<10000; i++){
            GrowingSpot position = AbstractWoodElement.getRandomPosition(5, 7);
            Assertions.assertTrue(position.getFromBranchOrigin() >= 5);
            Assertions.assertTrue(position.getFromBranchOrigin() <= 7);
            Assertions.assertTrue(position.getAround() >= 0);
            Assertions.assertTrue(position.getAround() <= 360);
        }
    }
}
