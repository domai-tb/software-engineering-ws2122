package HA3;

import java.util.ArrayList;

public class bathroom extends room{
    
    private Boolean shower_on;
    
    bathroom(String name, ArrayList<room> neighbours)
    {
        super(name, neighbours);
        shower_on = false;
    }

    public Boolean getShower_on()
    {
        return this.shower_on;
    }

    public void switchStove()
    {
        shower_on = !shower_on;

        if (stove)
        {
            //TODO print status of shower
        }else
            //TODO print status of shower
    }

    public void enter()
    {
        super.enter();
        //TODO do additional/ stuff for the Bathroom
        if (shower_on)
            System.out.print("The shower is on\n\n");
        else
            System.out.print("The shower is off\n\n");
    }
}
