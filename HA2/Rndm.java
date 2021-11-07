/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */


package HA2;


public class Rndm implements RndmInf
{   
    private int random;
    private int max;
    private int factor;
    private int start;
    private int increment;

    public int Random() {
        this.random = ((factor*random)+increment) % max;
        return random;
    }

    public void RandomSeed(int seed) {
        this.start = seed;
    }

    public final void Initialize() {
        this.factor = 623;
        this.increment = 525;
        this.max = 1000;
        this.start = 157;
        this.random = ((factor*start)+increment) % max;
    }
}