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
    /**
     * Principle of top-down design:
     * 
     * - static void main is the system level:
     *      -> it has an apartment and you can walk thougth it
     * 
     * - static Apartment init_apartement is a subsystem:
     *      -> just create the given apartment and use the modules 
     *         Apartment, Room, Bathroom and Kitchen
     * 
     * - static void print_enter_room is another subsystem:
     *      -> it prints the output when the user enters a new room 
     * 
     * - static int read_and_check_user_input is also a subsystem:
     *      -> it reads and checks the user input 
     * 
     * - subsystem static void execute_user_input:
     *      -> execute users whish
     * 
     * - subsystem static void check_rooms:
     *      -> print room status
     */

    // some helper functions
    private static void print(String s) { System.out.print(s); }
    private static void println(String s) { System.out.println(s); }

    /* private methods */ 

    private static Apartment init_apartement() 
    {
        Room hallway = new Room("Hallway");
        Kitchen kitchen = new Kitchen("kitchen");
        Room bedroom = new Room("bedroom");
        Bathroom bathroom = new Bathroom("bathroom");
        Room workroom = new Room("workroom");
        List<Room> roomsList = Arrays.asList( kitchen,
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

    private static void print_enter_room(Apartment apartment)
    {
        println("You are in the " + apartment.get_currenRoom().getName());
        print("What do you want to do? \n\n 1) Switch light \n 2) Leave room \n 3) Enter neighbouring room \n");
        if ( apartment.get_currenRoom().getName().equals("kitchen") ) {
            println(" 4) Switch stove");
        } else if ( apartment.get_currenRoom().getName().equals("bathroom") ) {
            println(" 4) Switch shower");
        }
        print("\n");
    }

    private static int read_and_check_user_input(int range) throws NumberFormatException, Exception
    {
        String input = "";
        int number;
        
        input = System.console().readLine();

        try{
            number = Integer.parseInt(input);
        }
        catch (NumberFormatException ex){
            throw new NumberFormatException();
        }

        if ( !(0 < number && number <= range) )
            throw new Exception("Invalid Number");

        return number;
    }

    private static void check_rooms(Apartment apartment) 
    {
        ArrayList<Room> rooms = apartment.get_rooms();
        for (Room r : rooms) {
            if ( r.getLightOn() ) {
                println("Warning: Light in the " + r.getName() + " is still switched on.");
            }

            if ( r.getName().equals("kitchen") ) {
                if ( ((Kitchen)r).getStove_on()) {
                    println("Warning: Stove is still switched on.");
                }
            } else if ( r.getName().equals("bathroom") ) {
                if ( ((Bathroom)r).getShower_on()) {
                    println("Warning: Shower is still switched on.");
                }
            }
        }
    }

    private static void execute_user_input(int input, Apartment apartment) throws ArrayIndexOutOfBoundsException, Exception
    {
        /**
         *      1       =       Switch Ligth
         *      2       =       Leave room
         *      3       =       Enter neighbouring room
         *      4       =       Switch stove / shower
         */
        ArrayList<Room> neighbours = new ArrayList<Room>(); 
        int num = 0;

        Room room = apartment.get_currenRoom();

        if ( input != 4 ) {
            switch (input) {
                case 1:
                    room.switchLight();
                    break;

                case 2:
                    Boolean leave_apartment = apartment.status_privious_rooms();
                    if ( leave_apartment )
                    {
                        check_rooms(apartment);
                        throw new ArrayIndexOutOfBoundsException("Apartment left.");
                    }
                    else 
                    {
                        Room privious_room = apartment.pop_privious_room();
                        print("Returning to previous room.\n\n");
                        apartment.set_current_room(privious_room);
                    }
                    break;

                case 3:
                    neighbours = room.getNeighbours();
                    int i = 1;
                    print("Which room? \n\n");
                    for (Room r : neighbours) {
                        println(" " + i + ") " + r.getName());
                        i += 1;
                    }
                    print("\n\n");

                    try {
                        num = read_and_check_user_input(i-1);   
                    } catch (NumberFormatException num_format) {
                        println("Please enter a number!\n\n");
                        break;
                    } catch (Exception inv_num) {   
                        println("A hidden room? Hmm ...\n\n");
                        break;
                    }

                    // store this room as a privious room
                    apartment.push_privious_room(room);
                    // walk into the new room
                    apartment.set_current_room(neighbours.get(num-1));
                    break;
                
                default:
                    throw new Exception("Internal Error.");
            }
        } else {
            if ( room.getName().equals("kitchen") ) {
                ((Kitchen)room).switchStove();
            } else {
                ((Bathroom)room).switchShower();
            }
        }
    }

    /* public method main */

    public static void main(String[] args) 
    {
        int input = -1, num_options;

        Apartment a = init_apartement();
        while(true) 
        {
            print_enter_room(a);

            // how much options?
            if ( a.get_currenRoom().getName().equals("kitchen") || 
                 a.get_currenRoom().getName().equals("bathroom"))
            {
                num_options = 4;
            } else {
                num_options = 3;
            }

            // read input
            try {
                input = read_and_check_user_input(num_options);   
            } catch (NumberFormatException num_format) {
                println("Please enter a number!\n\n");
                continue;
            } catch (Exception inv_num) {   
                println("This option does not exist ...\n\n");
                continue;
            }
    
            // execute input
            try {
                execute_user_input(input, a);   
            } catch (ArrayIndexOutOfBoundsException left_apa) {
                println("Leaving apartment.\n");
                break;
            } catch (Exception e) {
                e.printStackTrace();
                println("An internal / unexpected error occured.\n\n");
            }
        }
    }
}
