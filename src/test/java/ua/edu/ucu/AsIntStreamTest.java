package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.stream.*;
import static org.junit.Assert.*;

public class AsIntStreamTest{
    private IntStream IntStream;
    private IntStream emptyStream;

    @Before
    public void setUp(){
        IntStream = AsIntStream.of(0, 1, 2, 3,4);
        emptyStream = AsIntStream.of();
    }


    @Test
    public void average() {
        double expected = 2;
        double actual = IntStream.average();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testMax() {
        double expected = 4;
        double actual = IntStream.max();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testMin() {
        double expected = 0;
        double actual = IntStream.min();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testCount() {
        double expected = 5;
        double actual = IntStream.count();
        assertEquals(expected, actual, 0.0);
        double expected2 = 0;
        double actual2 = emptyStream.count();
        assertEquals(expected2, actual2, 0.0);
    }

    @Test
    public void testSum() {
        double expected = 10;
        double actual = IntStream.sum();
        assertEquals(expected, actual, 0.0);
        double expected2 = 0;
        double actual2 = emptyStream.sum();
        assertEquals(expected2, actual2, 0.0);
    }


    @Test
    public void testForEach() {
        String expected = "01234";
        String actual = StreamApp.streamForEach(IntStream);
        assertEquals(expected, actual);
        String expected2 = "";
        String actual2 = StreamApp.streamForEach(emptyStream);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testToArray() {
        int[] expected = {0, 1, 2, 3,4};
        int[] actual = StreamApp.streamToArray(IntStream);
        assertArrayEquals(expected, actual);
        int[] expected2 = {};
        int[] actual2 = StreamApp.streamToArray(emptyStream);
        assertArrayEquals(expected2, actual2);
    }
}