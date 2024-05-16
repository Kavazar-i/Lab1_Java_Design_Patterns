package com.kalosha.lab.shapes.creator.impl;

import com.kalosha.lab.shapes.creator.OvalFactory;
import com.kalosha.lab.shapes.creator.PointFactory;
import com.kalosha.lab.shapes.exeption.IncorrectOvalException;
import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.oval.OvalState;
import com.kalosha.lab.shapes.model.point.Point;
import com.kalosha.lab.shapes.reader.AdapterOvalFileReader;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OvalFactoryImpl implements OvalFactory {
    Logger logger = Logger.getLogger(OvalFactoryImpl.class.getName());

    @Override
    public List<Oval> createOvals(List<Point> points) {
        List<Oval> ovals = new ArrayList<>();

        if (points.size() % 2 != 0) {
            logger.warn("Coordinates array must contain even number of elements, last point will be ignored");
            points.remove(points.size() - 1);
        }

        for (int i = 0; i < points.size(); i += 2) {
            Oval oval = new Oval();
            oval.setPointA(points.get(i));
            oval.setPointB(points.get(i + 1));
            oval.setState(OvalState.detect(oval));

            if (OvalState.detect(oval) != OvalState.INVALID) {
                ovals.add(oval);
            } else {
                logger.error(String.format("Incorrect oval ignored: %s", oval));
            }
        }
        logger.info(String.format("Ovals created: %s", ovals));
        return ovals;
    }

    @Override
    public Oval createOval(List<Point> points) throws IncorrectOvalException {
        if (points.size() < 2) {
            logger.error("Coordinates array must contain at least 2 elements");
            throw new IncorrectOvalException("Coordinates array must contain at least 2 elements");
        }

        if (points.size() > 2) {
            logger.warn("Coordinates array must contain 2 elements,others will be ignored");
        }

        Oval oval = new Oval();
        oval.setPointA(points.get(0));
        oval.setPointB(points.get(1));
        oval.setState(OvalState.detect(oval));

        if (OvalState.detect(oval) == OvalState.INVALID) {
            logger.error(String.format("Incorrect oval ignored: %s", oval));
            throw new IncorrectOvalException("Incorrect oval ignored");
        }

        logger.info(String.format("Oval created: %s", oval));
        return oval;
    }

    @Override
    public Oval createOvalBySides(double sideA, double sideB) throws IncorrectOvalException {
        if (sideA <= 0 || sideB <= 0) {
            logger.error("Sides must be positive");
            throw new IncorrectOvalException("Sides must be positive");
        }

        PointFactory pointFactory = new PointFactoryImpl();
        Oval oval = new Oval(pointFactory.createPoint(0., 0.), pointFactory.createPoint(sideA, sideB));
        oval.setState(OvalState.detect(oval));

        logger.info(String.format("Created oval by sides: %s", oval));
        return oval;
    }

    @Override
    public List<Oval> createOvalsFromFile(String filePath) throws IncorrectOvalException {
        List<Oval> ovals = new ArrayList<>();
        List<List<Point>> coordinates = AdapterOvalFileReader.parseCoordinates(filePath);

        for (List<Point> coordinateCube : coordinates) {
            Oval oval = createOval(coordinateCube);

            if (OvalState.detect(oval) != OvalState.INVALID) {
                ovals.add(oval);
            } else {
                logger.error(String.format("Incorrect oval ignored: %s", oval));
                throw new IncorrectOvalException("Incorrect oval ignored");
            }
        }

        logger.info(String.format("Ovals created from file: %s", ovals));
        return ovals;
    }
}