package janary;

//Note: bases may be negative, imaginary, or irrational (not only whole/counting numbers)

public class Convention {
    
    //instance variables
    String name = null;
    
    int[] bases = new int[] {}; String[] names = new String[] {};
    String[] prefixes = new String[] {};
    
    //constructors
    public Convention(String instance_name) { this.name = instance_name; }
    public Convention() {} //empty constructor
    
    //setters
    public void setName(String new_name) { this.name = new_name; }
    public void setConvention(int[] bases, String[] names, String[] prefixes) { this.bases = bases; this.names = names; this.prefixes = prefixes; }
    
    //getters
    public String getName() { return (name != null) ? name : ""; }  //String temp = (name != null) ? name : "";
    public void getConvention(int[] bases, String[] names, String[] prefixes) { bases = this.bases; names = this.names; prefixes = this.prefixes; } //arrays are passed by refrence
    
    //other functions
    public void sort() { //this is an inefficient implementation (bubble sort), will be updated later
        //initialize biggest as smallest possible number
        String temp_str;
        int biggest = -2147483648, index = 0, temp_int;
        //for each element from the largest (right) to the smallest (left)
        for(int i = bases.length-1; 0 <= i; i--) {
            //iterate through all indexes smaller (and including it) and substitute it with the biggest of those
            for(int j = 0; j < i+1; j++) {
                if(biggest < bases[j]) { biggest = bases[j]; index = j; }
            }
            //swap biggest and right-most values
            temp_int = bases[i];
            bases[i] = bases[index];
            bases[index] = temp_int;
            
            temp_str = names[i];
            names[i] = names[index];
            names[index] = temp_str;
            
        //reset biggest
        biggest = -2147483648;
        } //end for loop
    } //end sort() method
    
}