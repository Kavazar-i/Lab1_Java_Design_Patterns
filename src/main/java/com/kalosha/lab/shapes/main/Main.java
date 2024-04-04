package com.kalosha.lab.shapes.main;

import com.kalosha.lab.shapes.creator.OvalFactory;
import com.kalosha.lab.shapes.creator.impl.OvalFactoryImpl;
import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.Warehouse;
import com.kalosha.lab.shapes.model.point.Point;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Пример сообщения для логирования.");
//        TODO: Read the input from file
        int[][] params = {
                {4, 5, 6, 7},
                {1, 1, 7,7},
                {8, 9, 9, 15},
                {7, 5, 4, 0},
        };
        OvalFactory factory = new OvalFactoryImpl();
        List<Oval> result = factory.createOvals(params);
        System.out.println(result);
        Warehouse warehouse = Warehouse.getInstance();
        Oval ob = result.get(0);
        ob.setPointA(new Point(1, 1));
        System.out.println(warehouse);
        ob.setPointB(new Point(2, 2));
        System.out.println(warehouse);
    }
}
