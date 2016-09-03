package seedu.addressbook.commands;

import java.util.*;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.tag.UniqueTagList.DuplicateTagException;

public class AddTagCommand extends Command {
    public static final String COMMAND_WORD = "addTag";
    public static final String EXAMPLE = "John Doe t/friends t/owesMoney";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Add tags to a person in the address book. "
            + "Parameters: NAME [t/TAG]...\n"
            + "Example: " + COMMAND_WORD + " " + EXAMPLE;

    public static final String MESSAGE_SUCCESS = "New tag added: %1$s";
    
    Set<String> tagSet;
    
    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public AddTagCommand(int targetVisibleIndex, Set<String> tagSet) {
        super(targetVisibleIndex);
        this.tagSet = tagSet;
    }
    
    @Override
    public CommandResult execute() {
        try {
            ReadOnlyPerson target = getTargetPerson();
            if (!addressBook.containsPerson(target)) {
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
            String name = target.getName().toString();
            UniqueTagList newTagList = target.getTags();
            for(String tagString : tagSet){
                Tag tag = new Tag(tagString);
                newTagList.add(tag);
                addressBook.addTag(tag);
                tagging.updateTagAddition(name, tagString);
            }
            Person person = (Person)target;
            person.setTags(newTagList);
            
            return new CommandResult(String.format(MESSAGE_SUCCESS, target.getAsTextHidePrivate()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (DuplicateTagException dte) {
            return new CommandResult(dte.getMessage());
        } catch (IllegalValueException ive) {
            return new CommandResult(ive.getMessage());
        }
    }

}
