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

}
