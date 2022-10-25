package janary;

import java.util.List; import java.util.ArrayList;

public class Janary {
    
    /*There is a short list of pre-defined names for bases
       Example: base 8 is specified as "Octal", not base 2^3 -> "tribinary"
    
      If a base is prime, it's name will be the same as the previous base but with "un-" as a prefix prepended.
    
      Next, bases are named after their prime factorizations and named similar to organic nomanclature
       Example: base 14 is base (2*7), 14 is twice seven which is concatonated as "biseptimal"
       Note: 2 becomes "bi"- which is the multiplicative prefix for 2 (there is a seperate list of these
      
      Next, attempt to find the factorizations with the minumum amount of roots, these are the only valid ones for the next step.
      
      However, if a system has many means for factorization, the set of minumum factorizations
                                                             with the closest in average quantity are prioritized (smallest first)
       Example: base 18 is base (2*2*3) which can be (2*3*3)||(3*2*3)||(3*3*2)||(2*9)||(3*6)||(9*2)||(6*3)
                of the listed, two have only 4 have only two factors: (2*9)||(3*6)||(9*2)||(6*3)
                and their differences are: {7,3,7,3}, making (3*6)||(6*3) the closest
                smallest numbers are first, so (3*6) is the chosen convention, "triseximal"
    
      However (again), if any of the roots happens to be "decimal" (using 10 as a factor, it becomes "gesimal";
       similarly "baker's dozenal" is shortened to "ker's dozenal".
       Also, for conventions with more than two roots, -"sna"- is injected between the two. (this is always valid even for less than two roots)
    
      Additionally, in cases where two consecuative roots would concatonate vowels, there is a set of rules for changing the adjacent vowels:
          |-o|-e|-i|-u|
        --+--+--+--+--+-
        i-|io|ie|i |i |
        --+--+--+--+--+-
        a-|o |e |i |u |
        --+--+--+--+--+-
        o-|o |e |i |u |
     
     Bases with a total negative value have the prefix "nega"-.
      Similarly, "vot"- (or "vöt"-) is used to invert (-1 power) a root section
     
     For all un-suffixed conventions, -ary (base%10<=6) and -imal (6<base%6) are postpended.
    */
    
    /*There is also an abreviation algorithm that only works for whole/counting numbers.
    
    Firstly, the names have all special characters and spaces removed.
    
    Then, each vowel besides within the first three characters (and the last character if it's a "Y") are removed.
    
    It then abbreviates the name (with at least three characters) in the first available way that does not conflict with a smaller abbreviation.
    */
    
    //coding method here (next version)
    public static String name(int input) {
        
        //Check if in pre-defined base names
            //define initial Conventions table
            Convention Jcon = janaryConvention();
            //check if in table
            for(int i = 0; i < Jcon.bases.length; i++) { if(Jcon.bases[i] == input) { return Jcon.names[i]; } }
            //also, if it is one greater than a pre-defined base, "un" is added as a prefix
            for(int i = 0; i < Jcon.bases.length; i++) { if(Jcon.bases[i] == input-1) { return "un"+Jcon.names[i]; } }
            
        //Check if it is a prime base
            //if prime, return "un"+name(input-1)
            List<Integer> factors = new ArrayList<>(), powers = new ArrayList<>();
            if( primeCheck(input, factors, powers) ) { return "un"+name(input-1); }
            
        //find prime factorization ( done in line above )
            //create lists of prime factors involved and their powers
            System.out.print("Factors: "); for(int i = 0; i < factors.size()-2; i++) { System.out.print(factors.get(i)+"^"+powers.get(i)+"&"); } System.out.print("\b,"+factors.get(factors.size()-2)+"^1&"+factors.get(factors.size()-1)+"^1\n");
            
        //find (arbitrary) optimal root path for naming
            //find all possible multiplicitive pathways
            //only keep paths in smallest to largest order
            //only keep the smallest (in quantity of factors) paths
            //find all current possible paths root counts
            //only keep the smallest (in quantity of roots) paths
            //only keep paths with smallest average difference between multiplicitive factors
            //keep first available path
            
        //name chosen pathway: String[]
            //name each individual multiplicitive factor: String[] (seperate)
            //interject "sna" between each named multiplitive factor
            //itterate through each element of the second String[], finding concecuative vowels in the end and starts between elements; in this case, refer the the chart from lines 30-36
            //verify suffix is the last element of second String[], if not add appropriate suffix (line 41)
            
        //Note: need nega- and vot- implementation

            
            
        return "";
    }
    
    private static Convention janaryConvention() {
        
        //define system basic information
        Convention JanMisali = new Convention("Janary");
        JanMisali.setConvention(new int[]    { 0,         1,       2,        3,
                                               4,         5,         6,         7,
                                               8,       9,        10,        11,
                                               12,        13,                16,    17,
                                               20,          36,         100 },
                                new String[] { "nullary", "unary", "binary", "trinary",
                                               "quanary", "pentary", "seximal", "septimal",
                                               "octal", "nonary", "decimal", "elevenary",
                                               "dozenal", "baker's dozenal", "hex", "suboptimal",
                                               "vegesimal", "niftimal", "centesimal"},
                                new String[] { "",        "hen",   "bi",     "tri",
                                               "tetra",   "penta",    "hexa",   "hepta",
                                               "octo",  "ennea",  "deca",    "leva",
                                               "doza",    "baker",            "tesser", "mal",
                                               "icosi",     "feta",     "hecto"});
        //return object
        return JanMisali;
        
    }
    
    private static boolean primeCheck(int n) {
       //check each whole number between 0 and 1+sqrt(n), if n/i has r0, n mustn't be prime.
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) { return false; }
        }
        //if it was never proven not prime in the check, it is prime.
        return true;
    }
    
    /**
    * Checks prime for arrays (not used)
    *
    * @deprecated use {@link #primeCheck( int, List<Integer>, List<Integer> )} instead.  
    */
    @Deprecated
    private static boolean primeCheck(int n, int[] f, int[] p) { //Note: arrays are passed by refrence, so the original array can be modified
       int factor_accumulator = 0;
       //check each whole number between 0 and 1+sqrt(n), if n/i has r0, n mustn't be prime.
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                f[factor_accumulator] = i;
                p[factor_accumulator++] = 1;
                return false;
            } //end if-statement
        } //end for-loop
        
        //now, I'll fix the factors and powers array to be accurate.
            //ensure all numbers in factors are primes themselves.
                for(int i = 0; i < f.length; i++) {
                    if( !primeCheck( f[i] ) ) { /*remove item from array*/ removeValue( f[i], f, p ); }
                } //end for-loop
                
            //check how large a power of each factor is inside the input "n"
            for(int i = 0; i < f.length; i++) {
                for(;;) { //until-continue loop
                    int temp_power = 1;
                    if( n < Math.pow( f[i], temp_power++ ) ) { p[i] = temp_power-1; }
                } //end until-continue loop
            } //end for-loop
        
        //if it was never proven not prime in the check, it is prime.
        return true;
    }
    
    private static boolean primeCheck(int n, List<Integer> f, List<Integer> p) { //Note: arrays are passed by refrence, so the original array can be modified
       int factor_accumulator = 0;
       //check each whole number between 0 and 1+sqrt(n), if n/i has r0, n mustn't be prime.
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                f.add(factor_accumulator, i); f.add(factor_accumulator+1, n/i);
                p.add(factor_accumulator, 0); p.add(factor_accumulator+1, 0);
                factor_accumulator += 2;
            } //end if-statement
        } //end for-loop
        
        //now, I'll fix the factors and powers array to be accurate.
            //ensure all numbers in factors are primes themselves.
                for(int i = 0; i < f.size(); i++) {
                    if( !primeCheck( f.get(i) ) ) { /*remove item from array*/ f.remove(i); p.remove(i); i--; }
                } //end for-loop
                
            //divide by each factor, checking how many time it perfectly divides into "n"
            for(int i = 0; i < f.size(); i++) {
                int temp_n = n;
                for(;;) { //until-continue loop
                    if( temp_n % f.get(i) == 0 ) { temp_n /= f.get(i); p.set( i, 1+p.get(i) ); } else { break; }
                } //end until-continue loop
            } //end for-loop
            
        //include 1 (assumed) and "n" as factors
        f.add(1); p.add(1); f.add(n); p.add(1);
            
        //if factors or powers has length (other than {1,n}.length = 2), then it is not prime.
        if( f.size() != 2 ) { return false; }
        
        //if it was never proven not prime in the check, it is prime.
        return true;
    }
    
    /**
    * Removes element of array (not used)
    *
    * @deprecated use {@link #ArrayList<>().remove(e E)} instead.  
    */
    @Deprecated
    private static void removeValue(int value, int[] array, int[] secondary) { //Note: in this use-case, two arrays are passed since both need be modified
        
        int iterator = 0;
        int[] temp_array = new int[] {}, temp_secondary = new int[] {};
        
        //iterate through array, and do not include array with value
        for(int i = 0; i < array.length /*assume both arrays are the same length*/; i++) {
            if( array[i] != value ) { temp_array[iterator] = array[i]; temp_secondary[iterator++] = secondary[i]; }
        } //end for-loop
        
        //once completed, change the original arrays
        array = temp_array;
        secondary = temp_secondary;
    }
    
}
