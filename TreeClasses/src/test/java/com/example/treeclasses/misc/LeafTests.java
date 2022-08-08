package com.example.treeclasses.misc;

import com.example.treeclasses.trees.assistingclasses.LeafColor;
import com.example.treeclasses.trees.leaves.Leaf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class LeafTests {

    @Test
    @DisplayName("Test if a leaf advances colors correctly")
    void colorAdvanceTest() {
        Leaf leaf = new Leaf();
        Assertions.assertEquals(leaf.getColor(), LeafColor.GREEN);
        leaf.advanceColor();
        Assertions.assertEquals(leaf.getColor(), LeafColor.YELLOW);
        leaf.advanceColor();
        Assertions.assertEquals(leaf.getColor(), LeafColor.RED);
        leaf.advanceColor();
        Assertions.assertEquals(leaf.getColor(), LeafColor.BROWN);
        leaf.advanceColor();
        Assertions.assertEquals(leaf.getColor(), LeafColor.BROWN);
    }

    @Test
    @DisplayName("Test if manual color setting works correctly")
    void colorChangeTest() {
        Leaf leaf = new Leaf();
        Assertions.assertEquals(leaf.getColor(), LeafColor.GREEN);
        leaf.setColor(LeafColor.RED);
        Assertions.assertEquals(leaf.getColor(), LeafColor.RED);
        leaf.setColor(LeafColor.GREEN);
        Assertions.assertEquals(leaf.getColor(), LeafColor.GREEN);
    }
}
