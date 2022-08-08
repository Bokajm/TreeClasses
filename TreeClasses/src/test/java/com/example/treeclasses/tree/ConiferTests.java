package com.example.treeclasses.tree;

import com.example.treeclasses.trees.trees.Conifer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConiferTests {

    @Test
    @DisplayName("Test if conifer instantiates correctly")
    void createConiferTest() throws Exception {
        Conifer conifer = new Conifer();
        Assertions.assertNotEquals(conifer, null);
        Assertions.assertNotEquals(conifer.getTrunk(), null);
        Assertions.assertEquals(conifer.getAge(), 0);
        Assertions.assertEquals(conifer.getSpecies(), "Conifer");
    }

    @Test
    @DisplayName("Test if conifer changes age correctly")
    void ageTest() throws Exception {
        Conifer conifer = new Conifer();
        Assertions.assertEquals(conifer.getAge(), 0);
        conifer.grow();
        Assertions.assertEquals(conifer.getAge(), 1);
    }

}
