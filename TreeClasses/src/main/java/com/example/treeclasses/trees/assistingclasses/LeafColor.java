package com.example.treeclasses.trees.assistingclasses;

public enum LeafColor {
    GREEN,
    YELLOW,
    RED,
    BROWN;

    public static LeafColor nextColor(LeafColor color) {
        switch(color){
            case GREEN:
                return YELLOW;
            case YELLOW:
                return RED;
            case RED:
            case BROWN:
            default:
                return BROWN;
        }
    }
}
