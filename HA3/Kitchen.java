package HA3;

import java.util.ArrayList;

public class Kitchen extends room{
    
    private Boolean stove_on;
    
    Kitchen(String name, ArrayList<room> neighbours)
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
        {
            //TODO print status of Stove
        }else
            //TODO print status of Stove
    }

    public void enter()
    {
        super.enter();
        //TODO do additional/ stuff for the Kitchen
        if (stove_on)
            System.out.print("The stove is on\n\n");
        else
            System.out.print("The stove is off\n\n");
    }
}
