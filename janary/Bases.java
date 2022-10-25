package janary;

public class Bases {

    public static void main(String[] args) {
        
        //create convetions here
        System.out.println( Janary.name(22) );
        
    }
    
    public static void Conventions() {
        
        Convention Standard = new Convention("Decimal");
        Standard.setConvention(new int[] { 2, 3, 4, 5,
                                           6, 7, 8, 9,
                                           10, 11, 12 }, 
                              new String[] { "binary", "ternary", "quaternary", "quinary",
                                             "senary", "septenary", "octal", "nonary",
                                             "decimal", "undecimal", "duodecimal" },
                              new String[] {});
        
        
        Convention JanMisali = new Convention("Janary");
        JanMisali.setConvention(new int[]   { 0,         1,       2,        3,
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
        
        Convention WheelerShigley = new Convention("Matima");
        WheelerShigley.setConvention(new int[] { 0, 1, 2, 3,
                                                 4, 5, 6, 7,
                                                 8, 9, 10, 11,
                                                 12, 13, 17, 19,
                                                 27, 29, 31, 33}, 
                                     new String[] { "nullary", "unary", "binary", "trinary",
                                                    "quadary", "pentary", "seximal", "heptimal",
                                                    "octal", "nonary", "decimal", "undecimal",
                                                    "dozenal", "bozenal", "", "", },
                                     new String[] {});
        
    }
    
}
