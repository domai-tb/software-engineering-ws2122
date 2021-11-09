/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */

package HA2;

public class Rndm_3 {

    private static int factor = 623;
    private static int increment = 525;
    private static int max = 1000;
    private static int start = 157 ;
    private static int random = ((factor*start)+increment) % max;

    public static int Random() {
        random = ((factor*random)+increment) % max;
        return random;
    }
}
