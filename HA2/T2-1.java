/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */


package HA2;


public class Main 
{
    public static void main(String args[])
    {
        int random = 42;
        int factor = 623;
        int increment = 525;
        int max = 1000;

        System.out.println("Random seed the generator? (y/n) ");

        askagain:{
            if ( System.console().readLine().equals("y") ) {
                random = ((factor*random)+increment) % max;
                System.out.println(random);
                System.out.println("Another random number? (y/n) ");
                goto askagain;      // goto doesn't exist in java anymore
            } 
        }  
    }
    
}
