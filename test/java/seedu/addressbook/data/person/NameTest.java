package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
    
    @Test
    public void isSimilar_differentAlphabetCase() throws IllegalValueException{
        Name existingName = new Name("Gerald Hubert Irvin");
        Name newName = new Name("gEralD hubErT iRviN");
        assertTrue(existingName.isSimilar(newName));
    }
    
    @Test
    public void isSimilar_differentOrder() throws IllegalValueException{
        Name existingName = new Name("Gerald Hubert Irvin");
        Name newName = new Name("Hubert Irvin Gerald");
        assertTrue(existingName.isSimilar(newName));
    }
    
    @Test
    public void isSimilar_containsPartOfName() throws IllegalValueException{
        Name existingName = new Name("Gerald Hubert Irvin");
        Name namePart1 = new Name("Gerald");
        assertTrue(existingName.isSimilar(namePart1));
        
        Name namePart2 = new Name("Hubert");
        assertTrue(existingName.isSimilar(namePart2));
        
        Name namePart3 = new Name("Irvin");
        assertTrue(existingName.isSimilar(namePart3));
    }
    
    @Test
    public void isSimilar_containsMoreThanName() throws IllegalValueException{
        Name existingName = new Name("Gerald Hubert Irvin");
        Name namePart1 = new Name("Gerald Hubert Irvin John Kenneth");
        assertTrue(existingName.isSimilar(namePart1));
    }
    
    @Test
    public void isSimilar_totallyDifferentName() throws IllegalValueException{
        Name existingName = new Name("Gerald Hubert Irvin");
        Name namePart1 = new Name("Xerxes Yancy");
        assertFalse(existingName.isSimilar(namePart1));
    }
    
    @Test
    public void isSimilar_nullName() throws IllegalValueException{
        Name existingName = new Name("Gerald Hubert Irvin");
        Name namePart1 = null;
        assertFalse(existingName.isSimilar(namePart1));
    }

}
