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

        logger.info(String.format("Points created: %s", newPoints));
        return newPoints;
    }

    @Override
    public Point createPoint(List<Double> coordinates) {
        if (coordinates.size() != 2) {
            logger.error("Coordinates array must contain 2 elements");
            throw new IllegalArgumentException("Coordinates array must contain even number of elements");
        }

        Point point = new Point(coordinates.get(0), coordinates.get(1));
        logger.info(String.format("Point created: %s", point));
        return point;
    }

    public Point createPoint(Double x, Double y) {
        if (x == null || y == null) {
            logger.error("Coordinates must not be null");
            throw new IllegalArgumentException("Coordinates must not be null");
        }

        Point point = new Point(x, y);
        logger.info(String.format("Point created: %s", point));
        return point;
    }
}
