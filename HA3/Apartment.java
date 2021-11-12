/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */

package HA3;


import java.util.ArrayList;


public class Apartment {

    private ArrayList<Room> rooms;
    private Room entranceRoom;
    private Room current_room;

    Apartment(Room entrance)
    {
        this.rooms = new ArrayList<Room>();
        this.rooms.add(entrance);
        this.entranceRoom = entrance;
        this.current_room = entrance;
    }

    public void extension(ArrayList<Room> rooms_to_add)
    {
        for (Room r : rooms_to_add) {
            rooms.add(r);   
            try {
                updateNeighbours(r);
            } catch(Exception e) {
                // TODO Exception Handling
            }      
        }    
    }

    private void updateNeighbours(Room new_room) throws Exception
    {
        int index;
        
        for (Room r : new_room.getNeighbours()) {
            if (rooms.contains(r))
            {
                index = rooms.indexOf(r);
                rooms.get(index).addNeighbour(new_room);               
            } else
                throw new Exception("Neighbour does not exist");
        }
    }

    public void enter()
    {
        // Idea: this.current_room = new_room;
    }
}
