package codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class WeightSortTest {

    String initArr = "56 65 74 100 99 68 86 180 90";
    String sortedArr = "100 180 90 56 65 74 68 86 99";

    @Test
    public void testSomething() {
        assertEquals(WeightSort.orderWeight(initArr), sortedArr);
        assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

}