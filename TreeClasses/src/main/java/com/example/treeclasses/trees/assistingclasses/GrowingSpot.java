package com.example.treeclasses.trees.assistingclasses;

public class GrowingSpot {
    double fromBranchOrigin;
    double around;

    public GrowingSpot(double fromBranchOrigin, double around) {
        if(fromBranchOrigin < 0) {
            throw new IllegalArgumentException("Distance from origin cannot be less than 0!");
        }
        if(around < 0 || around > 360) {
            throw new IllegalArgumentException("Placement around the element can only be an angle between 0 and 360");
        }
        this.fromBranchOrigin = fromBranchOrigin;
        this.around = around;
    }

    public double getFromBranchOrigin() {
        return fromBranchOrigin;
    }

    public void setFromBranchOrigin(double fromBranchOrigin) {
        this.fromBranchOrigin = fromBranchOrigin;
    }

    public double getAround() {
        return around;
    }

    public void setAround(double around) {
        this.around = around;
    }
}
