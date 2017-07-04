
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
        int grid[][] = new int[20][20];
        
        //Create a scanner
        Scanner InputReader = new Scanner(System.in);
        
        int firstCoord = -11, secondCoord = -11;
        
        System.out.println("Please Input Coordinates:");
        String input = InputReader.nextLine();
        while(InputReader.hasNext())
         {
             if(InputReader.next())
             {
                 if(firstCoord != -11)
                 {
                     secondCoord = InputReader.nextInt();
                     break;
                 }
                 else
                 {
                     firstCoord = InputReader.nextInt();
                 }
             }
             else
             {
                 InputReader.next();
             }
         }
        
        //Testing
        System.out.println(randomGenerator.nextInt(10));
    }
    
}
