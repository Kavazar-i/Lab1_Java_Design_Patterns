package com.kalosha.lab.shapes.creator.impl;

import com.kalosha.lab.shapes.creator.PointFactory;
import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.oval.OvalState;
import com.kalosha.lab.shapes.model.point.Point;

import java.util.ArrayList;
import java.util.List;

public class PointFactoryImpl implements PointFactory {

    @Override
    public List<Point> createPoints(int[][] coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Coordinates array must not be null");
        }
        if (coordinates.length % 2 != 0) {
            throw new IllegalArgumentException("Coordinates array must contain even number of elements");
        }
        List<Point> newPoints = new ArrayList<>();
        for (int[] current : coordinates) {
            Point point = new Point(current[0], current[1]);
            newPoints.add(point);
        }
        return newPoints;
    }
}
