package seedu.addressbook.data.person;

/**
 * Represents a Person's postal code in the address book. Guarantees: immutable.
 */
public class PostalCode {
    public final String value;

    public PostalCode(String postalCode){
        this.value = postalCode;
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
