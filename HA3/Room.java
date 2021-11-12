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
    //private int optionnumber;

    Room(String name) 
    {
        this.neighbours = new ArrayList<Room>();
        this.name = name;
        this.light_on = false;
        //this.optionnumber = 0;
    }

    Room(String name, ArrayList<Room> neighbours)
    {
        this.neighbours = neighbours;
        this.name = name;
        this.light_on = false;
        //this.optionnumber = 0;
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
        return neighbours;
    }

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
    }

    public void addNeighbours(ArrayList<Room> neighbours_to_add)
    {
        for (Room r : neighbours_to_add) {
            if (!neighbours.contains(r))
                neighbours.add(r);
        }
    }
    
    public void enter()
    {
        // print informations about the room
        System.out.print("You are in the" + this.name + "\n\n");
        if (light_on)
            System.out.print("The light is on\n\n");
        else
            System.out.print("The light is off\n\n");
    }
}
