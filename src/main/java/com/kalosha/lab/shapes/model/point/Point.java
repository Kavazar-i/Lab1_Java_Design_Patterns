package com.kalosha.lab.shapes.model.point;

import com.kalosha.lab.shapes.util.IdGenerator;

public class Point {
    private int pointId;
    private double x;
    private double y;

    public Point(double x, double y) {
        pointId = IdGenerator.increment();
        this.x = x;
        this.y = y;
    }

    public int getPointId() {
        return pointId;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;
        return pointId == point.pointId && Double.compare(x, point.x) == 0 && Double.compare(y, point.y) == 0;
    }

    @Override
    public int hashCode() {
        int result = pointId;
        result = 31 * result + Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);

        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "pointId=" + pointId +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
