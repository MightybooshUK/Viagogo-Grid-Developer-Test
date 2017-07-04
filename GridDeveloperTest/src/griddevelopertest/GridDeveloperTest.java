
package griddevelopertest;
import java.util.*;


/** 
 * @author Oliver
 */



public class GridDeveloperTest {
    
    //Create a random number generator
    private static Random randomGenerator = new Random();
    //Store the 'world' grid
    private static int grid[][] = new int[21][21];
    //Create a list of events
    private static ArrayList<Event> events = new ArrayList<Event>();
    //User inputed coordinates
    private static int xCoord = 0, yCoord = 0;

    public static void main(String[] args) 
    {
        GenerateSeed();
         System.out.println(grid);
        userInput();
        
        for(int i = 0;i < events.size() ; i++)
        {
            events.get(i).distance(xCoord, yCoord);
        }
        
        Collections.sort(events);
        
        
        
        //Testing
        System.out.println(events.get(0).getId());
    }
    
    public static void userInput()
    {
        //Create a scanner
        Scanner InputReader = new Scanner(System.in);
        //Declare variables
        int xCoord = -11, yCoord = -11, seperator = -1;
        boolean validCoordinates = false;
        
        while(!validCoordinates)
        {
            //Get coordinates from user
            System.out.println("Please Input Coordinates:");
            String input = InputReader.nextLine();
            
            //find the comma in the user's answer
            seperator = input.indexOf(',');
            if(seperator == -1)
            {
                //if there isn't a comma the input format is invalid
                System.out.println("Please enter Coordinates in the format X,Y ");            
            }
            else
            {
                //if there is then take the integer value of the two strings either side of the comma
                xCoord = Integer.valueOf(input.substring(0,seperator)) + 10;
                System.out.println(xCoord);
                yCoord = Integer.valueOf(input.substring(seperator+1)) + 10;
                System.out.println(yCoord);
            } 
            
            if(xCoord < 21 && xCoord > -1)
            {
                 if(yCoord < 21 && xCoord > -1)
                 {
                     validCoordinates = true;
                 } 
            }                        
        }
    }
    
    public static void GenerateSeed()
    {
        int counter = 0;
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                if(randomGenerator.nextInt(10) <= 1)
                {
                    grid[i][j] = counter;
                    GenerateEvent(i, j);
                    counter++;
                }
            }
        }
    }
    public static void GenerateEvent(int x, int y)
    {
        Event tempEvent = new Event(events.size(),x,y, randomGenerator.nextInt(101),randomGenerator.nextInt(100) + 1 + randomGenerator.nextFloat());
        events.add(tempEvent);        
        
    }
}

final class Event implements Comparable<Event>
{
    private final int ticketNumber, eventId, xCoord, yCoord;
    private final float ticketPrice;
    
    private int distanceTo;
    
    public Event( int eventId,int xCoord, int yCoord, int number, float price)
    {
        this.eventId = eventId;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
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
    
    public int getId()
    {
        return eventId;
    }  
    
    public void distance(int xCoord, int yCoord)
    {
        this.distanceTo = Math.abs(yCoord - this.yCoord) + Math.abs(xCoord - this.xCoord);        
    }

    @Override
    public int compareTo(Event ev) 
    {
        if(this.distanceTo > ev.distanceTo)
        {
            return 1;
        }
        else if(this.distanceTo == ev.distanceTo)
        {
            return 0;
        }
        else 
        {
            return -1;
        }
        
    }
}