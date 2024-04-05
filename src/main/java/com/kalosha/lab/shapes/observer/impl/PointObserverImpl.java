package com.kalosha.lab.shapes.observer.impl;

import com.kalosha.lab.shapes.model.Warehouse;
import com.kalosha.lab.shapes.model.point.Point;
import com.kalosha.lab.shapes.observer.PointObserver;

import java.util.ArrayList;

public class PointObserverImpl implements PointObserver {
    @Override
    public void update(Point point) {
        double pointX = point.getX();
        double pointY = point.getY();
        int key = point.getPointId();

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(
                key,
                new ArrayList<>(2) {
                    {
                        add(pointX);
                        add(pointY);
                    }
                });
    }
}
