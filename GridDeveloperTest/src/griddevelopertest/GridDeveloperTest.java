
package griddevelopertest;
import java.util.*;


/** 
 * @author Oliver
 */



public class GridDeveloperTest {

    public static void main(String[] args) {

        //Create a random number generator
        Random randomGenerator = new Random();

        //Make the grid
        int grid[][] = new int[21][21];
        
        
        
        //Testing
        System.out.println(randomGenerator.nextInt(10));
    }
    
    Coordinates userInput()
    {
        //Create a scanner
        Scanner InputReader = new Scanner(System.in);
        //Declare variables
        int xCoord = -11, yCoord = -11, seperator = -1;
        //Get coordinates from user
        System.out.println("Please Input Coordinates:");
        String input = InputReader.nextLine();
        
        seperator = input.indexOf(',');
        if(seperator == -1)
        {
            System.out.println("Please enter Coordinates in the formate X,Y ");            
        }
        else
        {
            xCoord = Integer.valueOf(input.substring(0,seperator));
            yCoord = Integer.valueOf(input.substring(seperator+1));
        }
      return new Coordinates(xCoord, yCoord);  
    }
}

final class Coordinates 
{
    private final int xCoord;
    private final int yCoord;
    
    public Coordinates(int x, int y)
    {
        this.xCoord = x;
        this.yCoord = y;
    }
    
    public int getX()
    {
        return xCoord;
    }
    
    public int getY()
    {
        return yCoord;
    }
}

final class Event
{
    private final int ticketNumber;
    private final float ticketPrice;
    
    public Event(int number, float price)
    {
        this.ticketNumber = number;
        this.ticketPrice = price;
    }
    
     public int getNumber()
    {
        return ticketNumber;
    }
    
    public float getPrice()
    {
        return ticketPrice;
    }
}