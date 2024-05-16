package tests.java;

import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.point.Point;
import com.kalosha.lab.shapes.service.OvalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OvalServiceTest {
    private OvalService ovalService;

    @BeforeEach
    public void setUp() {
        ovalService = new OvalService();
    }

    @Test
    public void testPerimeter() {
        // Create an oval for testing
        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 4);
        Oval oval = new Oval(pointA, pointB);

        // Calculate expected perimeter manually
        double expectedPerimeter = 2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(4, 2)) / 8);

        // Calculate perimeter using OvalService
        double actualPerimeter = ovalService.perimeter(oval);

        // Assert equality
        Assertions.assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    public void testSurface() {
        // Create an oval for testing
        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 4);
        Oval oval = new Oval(pointA, pointB);

        // Calculate expected surface manually
        double expectedSurface = Math.PI * 3 * 4;

        // Calculate surface using OvalService
        double actualSurface = ovalService.surface(oval);

        // Assert equality
        Assertions.assertEquals(expectedSurface, actualSurface);
    }
}

