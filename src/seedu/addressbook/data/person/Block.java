package seedu.addressbook.data.person;

/**
 * Represents a Person's block number in the address book.
 * Guarantees: immutable.
 */
public class Block {
    public final String value;
    
    public Block(String block){
        this.value = block;
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
