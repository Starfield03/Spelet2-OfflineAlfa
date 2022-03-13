import java.awt.Color;
import java.util.Scanner;

public class InformationGathering {
    
    public static int numberOfPlayers(){ //Decides number of players
        
        Scanner sc=new Scanner(System.in); //Imports scanner
        
        int numberOfPlayers = 0; //Puts numberOfPlayers = 0 to initiate the while loop
        
        while(numberOfPlayers < 2 || numberOfPlayers > 4){ //While loop that forces the number of players to be between 2 and 4
            
            System.out.println("Number of players, between 2 and 4:");
            
            numberOfPlayers = sc.nextInt(); //Number of players
            
            System.out.println(" ");
        }
        
        return numberOfPlayers; //Sends back the number of players
    }
    
    public static int sideLength(){ //Decides side length of gameboard
        
        Scanner sc=new Scanner(System.in); //Imports scanner
        
        int sideLength = 0; //Puts sideLength = 0 to initiate the while loop
        
        while(sideLength < 6 || sideLength % 2 == 1 || sideLength > 12){ //While loop that forces the side length to be an even number between 6 and 12
            
            System.out.println("Side length of gameboard, even numbers between 6 and 12:");
            
            sideLength = sc.nextInt(); //Side length
            
            System.out.println(" ");
        }
        
        return sideLength; //Sends back the side length
    }
    
    public static int numberOfWeapons(){ //Decides number of weapons per player
        
        Scanner sc=new Scanner(System.in); //Imports scanner
        
        int numberOfWeapons = 0; //Puts numberOfWeapons = 0 to initiate the while loop
        
        while(numberOfWeapons < 1 || numberOfWeapons > 4){ //While loop that forces the number of weapons per player to be between 1 and 4
            
            System.out.println("Number of weapons per player, between 1 and 4:");
            
            numberOfWeapons = sc.nextInt(); //Number of weapons per player
            
            System.out.println(" ");
        }
        
        return numberOfWeapons; //Sends back the number of weapons per player
    }
    
    
    
    public static int[] getCoordinates(SimpleWindow gameboard, int sideLength){ //Gathers coordinates after mouseclick
        
        int nextCoordinates[] = {sideLength, sideLength}; //Creates array with coordinates, X and Y
        
        while(nextCoordinates[0] >= sideLength || nextCoordinates[1] >= sideLength){ //While coordinates are out of bounds new coordinates must be chosen
            
            gameboard.waitForMouseClick(); //Waits for mouseclick
            
            nextCoordinates[0] = (int) Math.floor(gameboard.getMouseX() / 50); //Coordinates X
            nextCoordinates[1] = (int) Math.floor(gameboard.getMouseY() / 50); //Coordinates Y
        }
        
        return nextCoordinates; //Returns coordinates
    }
}
