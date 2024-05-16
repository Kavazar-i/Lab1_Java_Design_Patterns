package com.kalosha.lab.shapes.model;

import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

public class Warehouse {
    private static Warehouse instance = new Warehouse();
    private HashMap<Integer, List<Double>> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public List<Double> get(Integer key) {
        return map.get(key);
    }

    public List<Double> put(Integer key, List<Double> values) {
        return map.put(key, values);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Warehouse.class.getSimpleName() + "[", "]")
                .add("map=" + map)
                .toString();
    }
}
