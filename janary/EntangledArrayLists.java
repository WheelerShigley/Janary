package janary;

import java.util.List; import java.util.ArrayList;

public class EntangledArrayLists {
    
    //instance variables
    List<Integer> positive = new ArrayList<>(), negative = new ArrayList<>();
    
    //constructors
    public EntangledArrayLists() {} //empty constructor
    
    //setters
    public void setPositive(List<Integer> input) { this.positive = input; }
    public void setNegative(List<Integer> input) { this.positive = input; }
    
    //getters
    public List<Integer> getPositive() { return this.positive; }
    public List<Integer> getNegative() { return this.negative; }
    
    //other functions
    public void sort() { //this is an inefficient implementation (bubble sort), will be updated later
        /*dummy method for now*/
    } //end sort() method
    
}
