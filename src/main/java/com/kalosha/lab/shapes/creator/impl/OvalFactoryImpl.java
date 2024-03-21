package com.kalosha.lab.shapes.creator.impl;

import com.kalosha.lab.shapes.creator.OvalFactory;
import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.oval.OvalState;
import com.kalosha.lab.shapes.model.point.Point;

import java.util.ArrayList;
import java.util.List;

public class OvalFactoryImpl implements OvalFactory {
    @Override
    public List<Oval> createOvals(int[][] sides) {
        List<Oval> newOvals = new ArrayList<>();
        for (int[] current : sides) {
            Point pointA = new Point(current[0], current[1]);
            Point pointB = new Point(current[2], current[3]);
            Oval oval = new Oval(pointA, pointB);
            OvalState currentState = OvalState.detect(oval);
            oval.setState(currentState);
            newOvals.add(oval);
        }
        return newOvals;
    }
}