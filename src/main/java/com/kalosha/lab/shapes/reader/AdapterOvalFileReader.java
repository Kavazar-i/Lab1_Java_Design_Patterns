package com.kalosha.lab.shapes.reader;

import com.kalosha.lab.shapes.creator.PointFactory;
import com.kalosha.lab.shapes.creator.impl.PointFactoryImpl;
import com.kalosha.lab.shapes.model.point.Point;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class AdapterOvalFileReader {
    private static final Logger logger = Logger.getLogger(AdapterOvalFileReader.class.getName());

    private static final int NUMBER_OF_COORDINATES = 4;
    private static final int DIMENSION_OF_SPACE = 2;
    private static final String LINES_DELIMITER = ";";
    private static final String VALUES_DELIMITER = ", ";

    public static List<List<Point>> parseCoordinates(String filePath) {
        List<List<Point>> parsedCoordinates = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(Paths.get(Objects.requireNonNull(AdapterOvalFileReader.class.getResource(filePath)).toURI()).toUri()));
            lines.forEach(line -> {
                if (!line.isEmpty()) {
                    List<Point> coordinates = new ArrayList<>();

                    String[] xy = line.split(VALUES_DELIMITER);

                    for (int j = 0; j < DIMENSION_OF_SPACE; j++) {

                        if (xy.length == NUMBER_OF_COORDINATES) {
                            try {
                                double x = Double.parseDouble(xy[0 + 2 * j]);
                                double y = Double.parseDouble(xy[1 + 2 * j]);
                                PointFactory pointFactory = new PointFactoryImpl();
                                coordinates.add(pointFactory.createPoint(x, y));
                            } catch (NumberFormatException e) {
                                logger.warning("Error parsing coordinates: " + e.getMessage());
                            }
                        } else {
                            logger.warning("Incorrect number of values for coordinates.");
                        }
                    }

                    if (coordinates.get(0) != null && coordinates.get(1) != null) {
                        parsedCoordinates.add(coordinates);
                    }
                } else {
                    logger.warning("Incorrect number of coordinate sets in the line.");
                }
            });
        } catch (IOException e) {
            logger.severe("Error reading file: " + e);
        } catch (Exception e) {
            logger.severe("Error parsing coordinates: " + e);
        }

        return parsedCoordinates;
    }
}
