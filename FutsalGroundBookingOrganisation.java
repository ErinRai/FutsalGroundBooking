/**
 * class FutsalGroundBookingOrganisation is declared
 * it simulate adding object of FutsalGround
 * removing object from list of objects
 * book/hire records for the customer
 * making available for book/hire 
 * listing all objects of the currently available futsal ground
 * searching specific record
 * @author Erin Rai
 * ID 15043008
 */
import java.util.ArrayList;
public class FutsalGroundBookingOrganisation
{
    /* array list of object of type FutsalGround is created*/
    private ArrayList <FutsalGround> list = new ArrayList<FutsalGround>();
    /**
     * method addFutsalGround is declared
     * it takes 3 parameters
     * it adds a new object of FutsalGround to the list
     */
    public void addFutsalGround(String nameOfFutsalGroundBookingOrganisation, String nameOfFutsalGround, double oneHourRate)
    {
        FutsalGround futsal = new FutsalGround(nameOfFutsalGroundBookingOrganisation, nameOfFutsalGround, oneHourRate);
        list.add(futsal);
    }
    
    /**
     * method removeFutsalGround is declared
     * takes one parameter, the index no, 
     * which is the position in the array list of the object to be removed
     * provides suitable error message if any error occurs
     */
    public void removeFutsalGround(int indexNo)
    {   
        int i = indexNo;
        if(i>=0 && i<list.size())
        {
            list.remove(i);
        }
        else
        {
            System.out.print("Invalid index number. Please give valid index number");
        }
    }
    
    /**
     * method bookingRecord is declared
     * takes 5 parameters
     * calls the method in FutsalGround class to book futsal ground for the client
     * it stores the record in the index no of the array list
     * provides suitable error message if index number is not valid
     */
    public void bookingRecord(int indexNo, String clientName, String clientNo, String bookingDate, String clientType, int durationTime)
    {
        
        int i = indexNo;
        if(i>=0 && i<list.size())
        {
            FutsalGround futsal = list.get(i);
            futsal.groundBooking(clientName, clientNo, bookingDate, clientType, durationTime);
            list.set(i,futsal);
            
        }
        else
        {
            System.out.print("Invalid index number. Please give valid index number.");
        }
    }
    
    /**
     * method freeFutsalGround is declared
     * takes index number as parameter
     * it calls the method in the FutsalGround class which makes futsal ground free
     * it makes ground free in the index number of the array list provided by user
     * provides suitable error message if the index number is invalid
     */
    public void freeFutsalGround(int indexNo)
    {
       int i = indexNo;
        if(i>=0 && i<list.size())
        {
            FutsalGround futsal = list.get(i);
            futsal.freeGroundAvailableStatus();
        }
        else
        {
            System.out.print("Invalid index number. Please give valid index number");
        }
    }
    
    /**
     * method listAvailableForBooking is declared
     * list all futsal ground in the array list
     * that are currently available for booking 
     * method from FutsalGround is called which displays the information of futsal ground
     */
    public void listAvailableForBooking()
    {   
        for(int i = 0; i<list.size(); i++)
        {
            FutsalGround futsal = list.get(i);
            boolean availableStatus = futsal.getAvailableStatus();
            if(availableStatus == true)
            {
                System.out.println("Index number :" + i);
                futsal.displayInformation();
            }
            
        }
    }
   
    /**
     *method searchList is declared
     *takes 3 parameters
     *search the futsal ground which are currently available
     *if the condition matches with search term then
     *it calls the method of FutsalGround which displays the description of futsal ground
     *then ends the search
     *display suitable message if any record does not match with the search term
     */
    public void searchList(double maxHourlyRate, String nameOfFutsalGround)
    {
        boolean find = false;
        for(int i = 0; i < list.size(); i++)
        {
          FutsalGround futsal = list.get(i);
          boolean availableStatus = futsal.getAvailableStatus();
          double hourlyRate = futsal.getHourlyRate();
          String futsalGroundName = futsal.getFutsalGroundName();
          if(availableStatus == true && hourlyRate <= maxHourlyRate && futsalGroundName == nameOfFutsalGround )
          {
              find = true;
              System.out.println("Search Found");
              System.out.println("Index number :" + i);
              futsal.displayInformation();
              break;
          } 
        }
        if(!find)
          {
              System.out.println("Search not found");
          }    
            
    }
}
