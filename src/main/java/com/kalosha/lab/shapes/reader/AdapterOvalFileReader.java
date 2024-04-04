package com.kalosha.lab.shapes.reader;

import com.kalosha.lab.shapes.model.point.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class AdapterOvalFileReader {
    private static final Logger logger = Logger.getLogger(AdapterOvalFileReader.class.getName());

    private static final int NUMBER_OF_COORDINATES = 2;
    private static final int DIMENSION_OF_SPACE = 2;
    private static final String LINES_DELIMITER = "; ";
    private static final String VALUES_DELIMITER = ",";

    public static List<Point[]> parseCoordinates(String filePath) {
        List<Point[]> parsedCoordinates = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                String[] stringCoordinates = line.split(LINES_DELIMITER);

                if (stringCoordinates.length == NUMBER_OF_COORDINATES) {
                    Point[] coordinates = new Point[NUMBER_OF_COORDINATES];

                    for (int j = 0; j < NUMBER_OF_COORDINATES; j++) {
                        String[] xy = stringCoordinates[j].split(VALUES_DELIMITER);

                        if (xy.length == DIMENSION_OF_SPACE) {
                            try {
                                double x = Double.parseDouble(xy[0]);
                                double y = Double.parseDouble(xy[1]);
                                coordinates[j] = new Point(x, y);
                            } catch (NumberFormatException e) {
                                logger.log(Level.WARNING, "Error parsing coordinates: " + e.getMessage());
                            }
                        } else {
                            logger.warning("Incorrect number of values for coordinates.");
                        }
                    }

                    if (coordinates[0] != null && coordinates[1] != null) {
                        parsedCoordinates.add(coordinates);
                    }
                } else {
                    logger.warning("Incorrect number of coordinate sets in the line.");
                }
            });
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading file: " + e.getMessage(), e);
        }

        return parsedCoordinates;
    }
}
