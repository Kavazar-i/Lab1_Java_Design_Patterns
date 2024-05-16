package com.kalosha.lab.shapes.main;

import com.kalosha.lab.shapes.creator.OvalFactory;
import com.kalosha.lab.shapes.creator.PointFactory;
import com.kalosha.lab.shapes.creator.impl.OvalFactoryImpl;
import com.kalosha.lab.shapes.creator.impl.PointFactoryImpl;
import com.kalosha.lab.shapes.exeption.IncorrectOvalException;
import com.kalosha.lab.shapes.model.Warehouse;
import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.point.Point;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IncorrectOvalException {
        logger.info("Application started");
        PointFactory pointFactory = new PointFactoryImpl();
        List<Point> params = new ArrayList<Point>() {
            {
                add(pointFactory.createPoint(1., 1.));
                add(pointFactory.createPoint(-2.7, 2.));
                add(pointFactory.createPoint(3.0, 6.));
                add(pointFactory.createPoint(4., 4.));
            }
        };

        OvalFactory factory = new OvalFactoryImpl();
        List<Oval> result = factory.createOvals(params);
        System.out.println(result);
        Warehouse warehouse = Warehouse.getInstance();
        Oval oval = result.get(0);
        oval.setPointA(pointFactory.createPoint(10.0, 0.0));
        System.out.println(warehouse);
        oval.setPointB(pointFactory.createPoint(0.0, 10.0));
        System.out.println(warehouse);

        List<Oval> ovalsCorrect = factory.createOvalsFromFile("/correct_ovals.txt");
        System.out.println(ovalsCorrect);
        List<Oval> ovalsMixed = factory.createOvalsFromFile("/mixed_ovals.txt");
        System.out.println(ovalsMixed);
    }
}
