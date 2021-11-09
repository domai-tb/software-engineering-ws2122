/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */


package HA2;


public class Main 
{
    private static int get_random(int random) {
        int factor = 623;
        int increment = 525;
        int max = 1000;

        return ((factor*random)+increment) % max;
    }   

    public static void main(String args[])
    {
        int random = 42;

        System.out.println("Random seed the generator? (y/n) ");

        while (true) {
            if ( System.console().readLine().equals("y") ) {
                random = get_random(random);
                System.out.println(random);
                System.out.println("Another random number? (y/n) ");
            } else {
                System.out.println("Program ended with exit code: 0");
                System.exit(0);
            }
        }
    }
}