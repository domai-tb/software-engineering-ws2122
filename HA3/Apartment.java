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
    private ArrayList<Room> privious_rooms;
    private Room entrance_room;
    private Room current_room;

    Apartment(Room entrance)
    {
        this.rooms = new ArrayList<Room>();
        this.privious_rooms = new ArrayList<Room>();
        this.rooms.add(entrance);
        this.entrance_room = entrance;
        this.current_room = entrance;
    }

    /* getter */

    public Room get_currenRoom() { return this.current_room; }
    public Room get_entranceRoom() { return this.entrance_room; }
    public ArrayList<Room> get_rooms() { return this.rooms; }
    public ArrayList<Room> get_privious_rooms() { return this.privious_rooms; }

    /* setter */

    public void set_current_room(Room r) { this.current_room = r; }

    /* private methods */

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

    /* public nethods */

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

    public void push_privious_room(Room r) 
    {
        privious_rooms.add(r);
    }

    public Room pop_privious_room() 
    {
        Room privious_room = privious_rooms.get(privious_rooms.size()-1);
        privious_rooms.remove(privious_room);

        return privious_room;
    }

    public Boolean status_privious_rooms()
    {
        return privious_rooms.isEmpty();
    }

    public void enter()
    {
        // Idea: this.current_room = new_room;
    }
}
