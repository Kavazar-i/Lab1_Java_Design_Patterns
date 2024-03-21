package com.kalosha.lab.shapes.model.oval;

import com.kalosha.lab.shapes.model.point.Point;
import com.kalosha.lab.shapes.util.DistancesCalculator;


public enum OvalState {
    INVALID,
    REGULAR,
    CIRCULAR;

    public static OvalState detect(Oval oval) {
        Point pointA = oval.getPointA();
        Point pointB = oval.getPointB();
        if (pointA == null || pointB == null) {
            throw new IllegalArgumentException("All points must be provided");
        }

        double distanceByX = DistancesCalculator.distanceByXBetweenPoints(pointA, pointB);
        double distanceByY = DistancesCalculator.distanceByYBetweenPoints(pointA, pointB);

        if (distanceByX == 0 || distanceByY == 0) {
            return INVALID;
        } else if (distanceByX != distanceByY) {
            return REGULAR;
        } else {
            return CIRCULAR;
        }
    }

//    private static double distanceByXBetweenPoints(Point pointA, Point pointB) {
//        double dx = pointA.getX() - pointB.getX();
//        return Math.abs(dx);
//    }
//
//    private static double distanceByYBetweenPoints(Point pointA, Point pointB) {
//        double dy = pointA.getY() - pointB.getY();
//        return Math.abs(dy);
//    }
}
