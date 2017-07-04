
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
        
        //Create a scanner
        Scanner InputReader = new Scanner(System.in);
        
        int xCoord = -11, yCoord = -11, seperator = -1;
        
        System.out.println("Please Input Coordinates:");
        String input = InputReader.nextLine();
        
        
        
        //Testing
        System.out.println(randomGenerator.nextInt(10));
    }
    
}
