package com.kalosha.lab.shapes.observer.impl;

import com.kalosha.lab.shapes.model.Warehouse;
import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.observer.OvalObserver;
import com.kalosha.lab.shapes.service.OvalService;

import java.util.ArrayList;

public class OvalObserverImpl implements OvalObserver {
    @Override
    public void update(Oval oval) {
        OvalService service = new OvalService();
        double perimeter = service.perimeter(oval);
        double surface = service.surface(oval);
        int key = oval.getOvalId();

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(
                key,
                new ArrayList<>(2) {
                    {
                        add(perimeter);
                        add(surface);
                    }
                }
        );
    }
}
