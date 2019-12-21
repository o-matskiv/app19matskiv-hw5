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
        this.IntStream = AsIntStream.of(0, 1, 2, 3,4);
        this.emptyStream = AsIntStream.of();
    }


    @Test
    public void average() {
        double expected = 2;
        double actual = IntStream.average();
        assertEquals(expected, actual, 0.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyAverage(){
        double actual = emptyStream.average();
    }

    @Test
    public void testMax() {
        double expected = 4;
        double actual = IntStream.max();
        assertEquals(expected, actual, 0.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMax(){
        double actual = emptyStream.max();
    }

    @Test
    public void testMin() {
        double expected = 0;
        double actual = IntStream.min();
        assertEquals(expected, actual, 0.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMin(){
        double actual = emptyStream.min();
    }

    @Test
    public void testCount() {
        double expected = 5;
        double actual = IntStream.count();
        assertEquals(expected, actual, 0.0);
    }
    @Test
    public void testEmptyCount() {
        double expected = 0;
        double actual = emptyStream.count();
        assertEquals(expected, actual, 0.0);
    }


    @Test
    public void testSum() {
        double expected = 10;
        double actual = IntStream.sum();
        assertEquals(expected, actual, 0.0);
    }
    @Test
    public void testEmptySum() {
        double expected = 0;
        double actual = emptyStream.sum();
        assertEquals(expected, actual, 0.0);
    }


    @Test
    public void testForEach() {
        String expected = "01234";
        String actual = StreamApp.streamForEach(IntStream);
        assertEquals(expected, actual);
    }
    @Test
    public void testEmptyForEach() {
        String expected = "";
        String actual = StreamApp.streamForEach(emptyStream);
        assertEquals(expected, actual);
    }

    @Test
    public void testToArray() {
        int[] expected = {0, 1, 2, 3,4};
        int[] actual = StreamApp.streamToArray(IntStream);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testEmptyToArray() {
        int[] expected = {};
        int[] actual = StreamApp.streamToArray(emptyStream);
        assertArrayEquals(expected, actual);
    }
}