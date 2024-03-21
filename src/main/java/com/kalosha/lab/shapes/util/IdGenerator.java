package com.kalosha.lab.shapes.util;

import com.kalosha.lab.shapes.model.point.Point;

public class IdGenerator {
    private static int currentId = 0;

    public static int increment() {
        return ++currentId;
    }
}
