/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */

package HA3;

import java.util.ArrayList;

public class apartment {

   private ArrayList<room> rooms;
   private room entranceRoom;

   private void updateNeighbours(room newroom) throws Exception
   {
        for (room r : newroom.getNeighbours()) {
            if (rooms.contains(r))
            {
                rooms.inde
                
            } else
                throw new Exception("Neighbour does not exist");

        }
   }

   apartment(String entranceName)
   {
        entranceRoom = new room(entranceName, new ArrayList<room>());
        rooms = new ArrayList<room>();
        rooms.add(entranceRoom);
   }

   public void extension(room newRoom)
   {
        rooms.add(newRoom);   
        try
        {
            updateNeighbours(newRoom);
        }catch(Exception e)
        {
           // TODO Exception Handling
        }       
   }

   public void enter()
   {
       
   }
}
