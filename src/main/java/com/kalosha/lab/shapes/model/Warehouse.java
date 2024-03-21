package com.kalosha.lab.shapes.model;

import java.util.HashMap;
import java.util.StringJoiner;

public class Warehouse {
    private static Warehouse instance = new Warehouse();
    private HashMap<Integer, Double> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public Double get(Integer key) {
        return map.get(key);
    }

    public Double put(Integer key, Double value) {
        return map.put(key, value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Warehouse.class.getSimpleName() + "[", "]")
                .add("map=" + map)
                .toString();
    }
}
