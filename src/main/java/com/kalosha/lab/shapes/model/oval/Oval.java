package com.kalosha.lab.shapes.model.oval;

import com.kalosha.lab.shapes.exeption.IncorrectPointException;
import com.kalosha.lab.shapes.model.point.Point;
import com.kalosha.lab.shapes.observer.Observable;
import com.kalosha.lab.shapes.observer.OvalObserver;
import com.kalosha.lab.shapes.observer.impl.OvalObserverImpl;
import com.kalosha.lab.shapes.util.IdGenerator;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.StringJoiner;


public class Oval implements Observable {
    private int ovalId;
    private Point pointA;
    private Point pointB;
    private OvalState state = OvalState.INVALID;

    private OvalObserver observer = new OvalObserverImpl();

    private static final Logger logger = Logger.getLogger(Oval.class.getName());

    public Oval() {
        this.ovalId = IdGenerator.increment();
        this.pointA = new Point(0, 0);
        this.pointB = new Point(0, 0);

        logger.info(String.format(
                "Created a Oval with id: %d, pointA: %s, pointB: %s",
                ovalId,
                pointA,
                pointB
        ));
    }

    public Oval(Point pointA, Point pointB) {
        if (pointA == null || pointB == null) {
            logger.error("Point cannot be null");
            throw new IllegalArgumentException("Point cannot be null");
        }

        this.ovalId = IdGenerator.increment();
        this.pointA = pointA;
        this.pointB = pointB;

        logger.info(String.format(
                "Created a Oval with id: %d, pointA: %s, pointB: %s",
                ovalId,
                pointA,
                pointB
        ));
    }

    public Oval(List<Double> coordinates) throws IncorrectPointException {
        if (coordinates.size() == 4) {
            ovalId = IdGenerator.increment();
            this.pointA = new Point(coordinates.get(0), coordinates.get(1));
            this.pointB = new Point(coordinates.get(2), coordinates.get(3));

            logger.info("Created an Oval from doubles");
        } else {
            logger.error("Incorrect number of coordinates");
            throw new IncorrectPointException("Incorrect number of coordinates");
        }
    }

    public int getOvalId() {
        return ovalId;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        if (pointA != null) {
            this.pointA = pointA;
        }

        notifyObservers();
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        if (pointB != null) {
            this.pointB = pointB;
        }

        notifyObservers();
    }

    public OvalState getState() {
        return state;
    }

    public void setState(OvalState state) {
        if (state != null) {
            this.state = state;
        }

        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Oval oval = (Oval) o;
        return ovalId == oval.ovalId && pointA.equals(oval.pointA) && pointB.equals(oval.pointB) && state == oval.state;
    }

    @Override
    public int hashCode() {
        int result = ovalId;
        result = 31 * result + pointA.hashCode();
        result = 31 * result + pointB.hashCode();
        result = 31 * result + state.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Oval.class.getSimpleName() + "[", "]")
                .add("id=" + ovalId)
                .add("pointA=" + pointA)
                .add("pointB=" + pointB)
                .add("state=" + state)
                .toString();
    }

    @Override
    public void attach() {
        observer = new OvalObserverImpl();
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }
}
