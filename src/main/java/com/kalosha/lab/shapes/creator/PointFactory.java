package com.kalosha.lab.shapes.creator;

import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.point.Point;

import java.util.List;

public interface PointFactory {
    List<Point> createPoints(int[][] sides);
}
