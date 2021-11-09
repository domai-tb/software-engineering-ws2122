/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */

 package HA3;

 import java.util.ArrayList;

public class room {
    private String name;
    private ArrayList<room> neighbours;
    private Boolean light_on;
    private int optionnumber;

    room(String name, ArrayList<room> neighbours)
    {
        this.neighbours = neighbours;
        this.name = name;

        light_on = false;
        optionnumber = 0;
    }

    //Getter

    public String getName()
    {
        return this.name;
    }
    
    public Boolean getLightOn()
    {
        return this.light_on;
    }

    public ArrayList<room> getNeighbours() {
        return neighbours;
    }

    public void switchLight()
    {
        light_on = !light_on;
        if (light_on)
        {
            //TODO: print light turned on
        }else
            //TODO: print light turned off
    }

    public void addNeighbour(room neighbour)
    {
        if (!neighbours.contains(neighbour))
            neighbours.add(neighbour);
    }
    
    public void enter()
    {
        // TODO: print Currentinformations about the room (Name, Light on/off)
        System.out.print("You are in the" + this.name + "\n\n");
        if (light_on)
            System.out.print("The light is on\n\n");
        else
            System.out.print("The light is off\n\n");
    }
}
