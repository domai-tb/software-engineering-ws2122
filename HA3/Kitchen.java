/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */

package HA3;


import java.util.ArrayList;


public class Kitchen extends Room{
    
    private Boolean stove_on;
    
    Kitchen(String name) 
    {
        super(name);
        stove_on = false;
    }

    Kitchen(String name, ArrayList<Room> neighbours)
    {
        super(name, neighbours);
        stove_on = false;
    }

    public Boolean getStove_on()
    {
        return this.stove_on;
    }

    public void switchStove()
    {
        stove_on = !stove_on;

        if (stove_on)
            System.out.print("The stove is open.\n\n");
        else
            System.out.print("The stove is close.\n\n");
    }
}
