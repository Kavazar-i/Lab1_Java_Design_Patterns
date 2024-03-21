package com.kalosha.lab.shapes.service;

import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.point.Point;
import com.kalosha.lab.shapes.util.DistancesCalculator;

public class OvalService {
    public double perimeter(Oval oval) {
        Point pointA = oval.getPointA();
        Point pointB = oval.getPointB();
        double distanceByX = DistancesCalculator.distanceByXBetweenPoints(pointA, pointB);
        double distanceByY = DistancesCalculator.distanceByYBetweenPoints(pointA, pointB);
        double perimeter = 2 * Math.PI * Math.sqrt((Math.pow(distanceByX, 2) + Math.pow(distanceByY, 2)) / 8);
        return perimeter;
    }
}