package codewars;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexpStringTest {

    @Test
    public void isIsogram() {
        assertTrue(RegexpString.isIsogram("Dermatoglyphics"));
        assertTrue(RegexpString.isIsogram("isogram"));
        assertFalse(RegexpString.isIsogram("moose"));
        assertFalse(RegexpString.isIsogram("isIsogram"));
        assertFalse(RegexpString.isIsogram("aba"));
        assertFalse(RegexpString.isIsogram("moOse"));
        assertTrue(RegexpString.isIsogram("thumbscrewjapingly"));
        assertTrue(RegexpString.isIsogram(""));
    }
}