package com.kalosha.lab.shapes.creator.impl;

import com.kalosha.lab.shapes.creator.PointFactory;
import com.kalosha.lab.shapes.model.point.Point;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PointFactoryImpl implements PointFactory {
    Logger logger = Logger.getLogger(PointFactoryImpl.class.getName());

    @Override
    public List<Point> createPoints(List<Double> coordinates) {
        if (coordinates == null) {
            logger.error("Coordinates array must not be null");
            throw new IllegalArgumentException("Coordinates array must not be null");
        }

        if (coordinates.size() % 2 != 0) {
            logger.error("Coordinates array must contain even number of elements");
            throw new IllegalArgumentException("Coordinates array must contain even number of elements");
        }

        List<Point> newPoints = new ArrayList<>();

        for (int i = 1; i < coordinates.size(); i += 2) {
            newPoints.add(new Point(coordinates.get(i - 1), coordinates.get(i)));
        }

        return newPoints;
    }

    @Override
    public Point createPoint(List<Double> coordinates) {
        return null;
    }
}
