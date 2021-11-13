/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */

package HA3;


import java.util.ArrayList;


public class Room 
{
    private String name;
    private ArrayList<Room> neighbours;
    private Boolean light_on;

    Room(String name) 
    {
        this.neighbours = new ArrayList<Room>();
        this.name = name;
        this.light_on = false;
    }

    Room(String name, ArrayList<Room> neighbours)
    {
        this.neighbours = neighbours;
        this.name = name;
        this.light_on = false;
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

    public ArrayList<Room> getNeighbours() {
        return this.neighbours;
    }

    /* public methods */

    public void switchLight()
    {
        light_on = !light_on;
        if (light_on)
        {
            System.out.print("The light is on\n\n");
        }else
            System.out.print("The light is off\n\n");
    }

    public void addNeighbour(Room neighbour)
    {
        if (!neighbours.contains(neighbour))
            neighbours.add(neighbour);
        if (!neighbour.neighbours.contains(this))
            neighbour.neighbours.add(this);
    }

    public void addNeighbours(ArrayList<Room> neighbours_to_add)
    {
        for (Room r : neighbours_to_add) {
            addNeighbour(r);
        }
    }
}
