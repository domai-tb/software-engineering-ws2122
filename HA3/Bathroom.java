/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */

 package HA3;


import java.util.ArrayList;


public class Bathroom extends Room
{    
    private Boolean shower_on;
    
    Bathroom(String name) 
    {
        super(name);
        shower_on = false;
    }

    Bathroom(String name, ArrayList<Room> neighbours)
    {
        super(name, neighbours);
        shower_on = false;
    }

    public Boolean getShower_on()
    {
        return this.shower_on;
    }

    public void switchShower()
    {
        shower_on = !shower_on;

        if (shower_on)
            System.out.print("The shower is on\n\n");
        else
            System.out.print("The shower is off\n\n");
    }
}
