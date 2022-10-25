package janary;

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
    
    //coding here (next version)
    
    /*There is also an abreviation algorithm that only works for whole/counting numbers.
    
    Firstly, the names have all special characters and spaces removed.
    
    Then, each vowel besides within the first three characters (and the last character if it's a "Y") are removed.
    
    It then abbreviates the name (with at least three characters) in the first available way that does not conflict with a smaller abbreviation.
    */
    
    //coding method here (next version)
    
}
