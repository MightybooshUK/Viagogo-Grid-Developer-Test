
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
    private static ArrayList<Event> events = new ArrayList();
    //User inputed coordinates
    private static int xCoord = 0, yCoord = 0;

    public static void main(String[] args) 
    {
        //Generate the 'world' and all events
        GenerateSeed();         
        //Take the user's coordinates
        userInput();        
        //Calculate the distance from each event to the user
        for(int i = 0;i < events.size() ; i++)
        {           
            events.get(i).distance(xCoord, yCoord);
        }
        //Sort the events to shortest first
        Collections.sort(events);
        
        
        
        //Output five closest and their cheapest prices
        System.out.println("Event " + events.get(0).getId() + " - $" + events.get(0).getCheapest() + ", Distance " + events.get(0).getDistance());
        System.out.println("Event " + events.get(1).getId() + " - $" + events.get(1).getCheapest() + ", Distance " + events.get(1).getDistance());
        System.out.println("Event " + events.get(2).getId() + " - $" + events.get(2).getCheapest() + ", Distance " + events.get(2).getDistance());
        System.out.println("Event " + events.get(3).getId() + " - $" + events.get(3).getCheapest() + ", Distance " + events.get(3).getDistance());
        System.out.println("Event " + events.get(4).getId() + " - $" + events.get(4).getCheapest() + ", Distance " + events.get(4).getDistance());
           
    }
    
    public static void userInput()
    {
        //Create a scanner
        Scanner InputReader = new Scanner(System.in);
        //Declare variables
        int seperator = -1;
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
                try
                {   
                    xCoord = Integer.valueOf(input.substring(0,seperator)) + 10;
                    yCoord = (Integer.valueOf(input.substring(seperator+1)) + 10);
                }
                catch(Exception e)
                {
                    System.out.println("Please only use integer characters with no spaces!");
                }
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
        //This method loops through each value in the grid and may populate it with an event
        
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
        //This method creates the individual events and all tickets associated with it
        int ticketNo = 0;
        ArrayList<Ticket> ticketArray = new ArrayList();//
        ticketNo = randomGenerator.nextInt(50);
        
        for(int i = 0; i < ticketNo; i++)
        {
            //Generate a random price from a whole number between 99 and 0, add a random float between 1 and 0 then ensure it is nonzero by adding 1
            float temp = Math.round((randomGenerator.nextInt(100) + randomGenerator.nextFloat() + 1)*100);
            temp = temp/100;
            Ticket tempTicket = new Ticket(temp);
            ticketArray.add(tempTicket);
        }
        //Sort the tickets from cheapest to most expensive
        Collections.sort(ticketArray);       
        //Create the event and add it to the arraylist of events
        Event tempEvent = new Event(events.size(),x,y, ticketNo,ticketArray);
        events.add(tempEvent);        
        
    }
}


final class Event implements Comparable<Event>
{
    //The event class holds all associated tickets, the coordinates of the event and the event id
    private final int ticketNumber, eventId, xCoord, yCoord;
    private final ArrayList<Ticket> tickets;
    //Holds the distance to the user's location
    private int distanceTo;
    
    public Event( int eventId,int xCoord, int yCoord, int number, ArrayList<Ticket> tickets)
    {
        this.eventId = eventId;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.ticketNumber = number;
        this.tickets = tickets;
        
        
    }
    
     public int getNumber()
    {
        return ticketNumber;
    }
    
    public float getCheapest()
    {
        return tickets.get(0).getPrice();
    }
    
    public int getId()
    {
        return eventId;
    }  
    
    public int getDistance()
    {
        return distanceTo;
    }
    public void distance(int xCoord, int yCoord)
    {
        this.distanceTo = Math.abs(yCoord - this.yCoord) + Math.abs(xCoord - this.xCoord);        
    }

    //This method allows the Collections class to order an arraylist of this object by distance
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

final class Ticket implements Comparable<Ticket>
{
    private final float price;
    
    public Ticket(float price)
    {
        this.price = price;
    }
    
    public float getPrice()
    {
        return this.price;
    }

    //Again, allows for Collections to sort an ArrayList of this class
    @Override
    public int compareTo(Ticket t) 
    {
        if(this.price > t.price)
        {
            return 1;
        }
        else if(this.price ==  t.price)
        {
            return 0;
        }
        else 
        {
            return -1;
        }
    }
}