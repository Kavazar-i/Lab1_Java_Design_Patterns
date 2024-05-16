package tests.java;

import com.kalosha.lab.shapes.creator.impl.OvalFactoryImpl;
import com.kalosha.lab.shapes.exeption.IncorrectOvalException;
import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.point.Point;
import com.kalosha.lab.shapes.reader.AdapterOvalFileReader;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OvalFactoryImplTest {
    @Test
    public void testCreateOvalsFromPoints() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(3, 4));
        points.add(new Point(5, 6)); // Ignored, as there should be an even number of points

        OvalFactoryImpl factory = new OvalFactoryImpl();
        List<Oval> ovals = factory.createOvals(points);

        Assertions.assertEquals(1, ovals.size());
        // Add more assertions if needed to check the properties of the created ovals
    }

    @Test
    public void testCreateOvalFromSides() throws IncorrectOvalException {
        double sideA = 3;
        double sideB = 4;

        OvalFactoryImpl factory = new OvalFactoryImpl();
        Oval oval = factory.createOvalBySides(sideA, sideB);

        Assertions.assertNotNull(oval);
        // Add assertions to check oval properties based on side values
    }

    @Test
    public void testCreateOvalsFromFile() throws IncorrectOvalException, URISyntaxException, IOException {
        String filePath = "path/to/your/file.txt"; // Provide a valid file path
        List<String> lines = Files.readAllLines(Paths.get(Paths.get(Objects.requireNonNull(AdapterOvalFileReader.class.getResource(filePath)).toURI()).toUri()));
        OvalFactoryImpl factory = new OvalFactoryImpl();
        List<Oval> ovals = factory.createOvalsFromFile(filePath);

        // Add assertions to check the number and properties of ovals created from the file
    }

    @Test
    public void testCreateOvalWithInvalidPoints() {
        List<Point> points = new ArrayList<>();
        // Add less than 2 points

        OvalFactoryImpl factory = new OvalFactoryImpl();

        Assertions.assertThrows(IncorrectOvalException.class, () -> {
            factory.createOval(points);
        });
    }
}
