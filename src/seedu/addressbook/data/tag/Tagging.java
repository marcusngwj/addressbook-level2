package seedu.addressbook.data.tag;

import java.util.*;

public class Tagging {
    public static final String ADD_PREFIX = "+";
    public static final String DELETE_PREFIX = "-";
    
    public static final String EXAMPLE = "+ Jake Woo [friend]";
    public static final String MESSAGE_SUCCESS = "%1$s %2$s [%3$s]";
    
    private ArrayList<String> tagChanges;
    
    public Tagging(){
        tagChanges = new ArrayList<String>();
    }
    
    public void updateTagAddition(String name, String newTag){
        tagChanges.add(String.format(MESSAGE_SUCCESS, ADD_PREFIX, name, newTag));
    }
    
    public void updateTagDeletion(String name, String tagRemoved){
        tagChanges.add(String.format(MESSAGE_SUCCESS, DELETE_PREFIX, name, tagRemoved));
    }
    
    @Override
    public String toString(){
        String result = "";
        for(String changes : tagChanges){
            result += changes + "\n";
        }
        return result;
    }
}
