package seedu.addressbook.data.person;

/**
 * Represents a Person's street number in the address book.
 * Guarantees: immutable.
 */
public class Street {
    public final String value;
    
    public Street(String street){
        this.value = street;
    }

    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
