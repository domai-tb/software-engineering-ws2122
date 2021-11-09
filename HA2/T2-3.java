/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */


package HA2;


import HA2.Rndm_3;

public class Main 
{
    public static void main(String args[])
    {
        System.out.println("Random seed the generator? (y/n) ");

        while (true) {
            if ( System.console().readLine().equals("y") ) {
                System.out.println(Rndm_3.Random());
                System.out.println("Another random number? (y/n) ");
            } else {
                System.out.println("Program ended with exit code: 0");
                System.exit(0);
            }
        }
    }
}
