package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull_NoNull(){
        ArrayList<String> testArrayList = new ArrayList<String>();
        testArrayList.add("Hi");
        testArrayList.add("How are you?");
        assertFalse(Utils.isAnyNull(testArrayList));
    }
    
    @Test
    public void isAnyNull_ContainsNull(){
        ArrayList<Object> testArrayList = null;
        assertTrue(Utils.isAnyNull(testArrayList));
    }
    
    @Test
    public void elementsAreUnique(){
        ArrayList<String> testArrayList = new ArrayList<String>();
        testArrayList.add("A");
        testArrayList.add("B");
        testArrayList.add("C");
        testArrayList.add("D");
        testArrayList.add("E");
        assertTrue(Utils.elementsAreUnique(testArrayList));
    }
    
    @Test
    public void elementsAreNotUnique(){
        ArrayList<String> testArrayList = new ArrayList<String>();
        testArrayList.add("A");
        testArrayList.add("B");
        testArrayList.add("C");
        testArrayList.add("D");
        testArrayList.add("A");
        assertFalse(Utils.elementsAreUnique(testArrayList));
    }
}
