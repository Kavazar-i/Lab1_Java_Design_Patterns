package com.kalosha.lab.shapes.creator;

import com.kalosha.lab.shapes.exeption.IncorrectOvalException;
import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.point.Point;

import java.util.List;

public interface OvalFactory {
    List<Oval> createOvals(List<Point> points) throws IncorrectOvalException;

    Oval createOval(List<Point> points) throws IncorrectOvalException;

    Oval createOvalBySides(double sideA, double sideB) throws IncorrectOvalException;

    List<Oval> createOvalsFromFile(String filePath) throws IncorrectOvalException;
}
