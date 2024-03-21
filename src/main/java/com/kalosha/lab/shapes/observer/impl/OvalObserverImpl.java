package com.kalosha.lab.shapes.observer.impl;

import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.Warehouse;
import com.kalosha.lab.shapes.observer.OvalObserver;
import com.kalosha.lab.shapes.service.OvalService;

public class OvalObserverImpl implements OvalObserver {
    @Override
    public void update(Oval oval) {
        OvalService service = new OvalService();
        double perimeter = service.perimeter(oval);
        int key = oval.getOvalId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, perimeter);
    }
}
