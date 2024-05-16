package tests.java;

import com.kalosha.lab.shapes.model.oval.Oval;
import com.kalosha.lab.shapes.model.oval.OvalState;
import com.kalosha.lab.shapes.model.point.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OvalTest {

    @Test
    public void testOvalState() {
        // Test for INVALID state
        Point invalidPointA = new Point(0, 0);
        Point invalidPointB = new Point(0, 0);
        Oval invalidOval = new Oval(invalidPointA, invalidPointB);
        Assertions.assertEquals(OvalState.INVALID, OvalState.detect(invalidOval));

        // Test for REGULAR state
        Point regularPointA = new Point(0, 0);
        Point regularPointB = new Point(2, 3); // Distances by X and Y are different
        Oval regularOval = new Oval(regularPointA, regularPointB);
        Assertions.assertEquals(OvalState.REGULAR, OvalState.detect(regularOval));

        // Test for CIRCULAR state
        Point circularPointA = new Point(0, 0);
        Point circularPointB = new Point(3, 3); // Distances by X and Y are equal
        Oval circularOval = new Oval(circularPointA, circularPointB);
        Assertions.assertEquals(OvalState.CIRCULAR, OvalState.detect(circularOval));
    }

    @Test
    public void testEquals() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 4);
        Oval oval1 = new Oval(pointA, pointB);
        Oval oval2 = new Oval(pointA, pointB);
        Oval oval3 = new Oval(pointB, pointA); // Different order of points, but still equal

        Assertions.assertEquals(oval1, oval2);
        Assertions.assertEquals(oval1, oval3);
    }

    @Test
    public void testNotEquals() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 4);
        Oval oval1 = new Oval(pointA, pointB);
        Oval oval2 = new Oval(pointA, new Point(1, 1)); // Different pointB

        Assertions.assertNotEquals(oval1, oval2);
    }
}

