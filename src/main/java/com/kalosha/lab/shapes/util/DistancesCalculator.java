package com.kalosha.lab.shapes.util;

import com.kalosha.lab.shapes.model.point.Point;

public class DistancesCalculator {
    public static double distanceByXBetweenPoints(Point pointA, Point pointB) {
        double dx = pointA.getX() - pointB.getX();
        return Math.abs(dx);
    }

    public static double distanceByYBetweenPoints(Point pointA, Point pointB) {
        double dy = pointA.getY() - pointB.getY();
        return Math.abs(dy);
    }
}
