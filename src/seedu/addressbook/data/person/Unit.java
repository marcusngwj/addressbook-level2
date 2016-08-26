package seedu.addressbook.data.person;

/**
 * Represents a Person's unit number in the address book.
 * Guarantees: immutable.
 */
public class Unit {
    public final String value;

    public Unit(String unit){
        this.value = unit;
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
