package codewars;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;



public class FindOutlierTest {

    @Test
    public void testExample() {
        int[] exampleTest1 = {2, 6, 8, -10, 3};
        int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        assertEquals(3, FindOutlier.find(exampleTest1));
        assertEquals(206847684, FindOutlier.find(exampleTest2));
        assertEquals(0, FindOutlier.find(exampleTest3));
    }

    @Test
    public void ArrayTest1() {
        Iterator<Integer> iterator;
        ArrayList<Integer> arrInt = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        iterator = arrInt.iterator();
        arrInt.size();

    }

}