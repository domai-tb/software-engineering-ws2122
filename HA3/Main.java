/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */

package HA3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main 
{
    private static Apartment init_apartement() 
    {
        Room hallway = new Room("Hallway");
        Room kitchen = new Room("kitchen");
        Room bedroom = new Room("bedroom");
        Room bathroom = new Room("bathroom");
        Room workroom = new Room("workroom");
        List<Room> roomsList = Arrays.asList( hallway,
                                              kitchen,
                                              bedroom, 
                                              bathroom,
                                              workroom);
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.addAll(roomsList);

        hallway.addNeighbours(rooms);
        bedroom.addNeighbour(workroom);

        Apartment apartment = new Apartment(hallway);
        apartment.extension(rooms);

        return apartment;
    } 

    private static void input_loop(Apartment apartment) throws Exception
    {
        /**
         * 
         * Read user input and do apartment tour
         * 
         */
    }    

    public static void main(String[] args) 
    {
        Apartment a = init_apartement();
        try {
            input_loop(a);   
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
