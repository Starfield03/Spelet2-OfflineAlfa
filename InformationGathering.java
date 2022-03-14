import java.awt.Color;
import java.util.Scanner;

public class InformationGathering {
    
    public static int numberOfPlayers(){
        
        Scanner sc=new Scanner(System.in);
        
        int numberOfPlayers = 0;
        
        while(numberOfPlayers < 2 || numberOfPlayers > 4){
            
            System.out.println("Number of players, between 2 and 4:");
            
            numberOfPlayers = sc.nextInt();
            
            System.out.println(" ");
        }
        
        return numberOfPlayers;
    }
    
    public static int sideLength(){
        
        Scanner sc=new Scanner(System.in);
        
        int sideLength = 0;
        
        while(sideLength < 6 || sideLength % 2 == 1 || sideLength > 12){
            
            System.out.println("Side length of gameboard, even numbers between 6 and 12:");
            
            sideLength = sc.nextInt();
            
            System.out.println(" ");
        }
        
        return sideLength;
    }
    
    public static int numberOfWeapons(){
        
        Scanner sc=new Scanner(System.in);
        
        int numberOfWeapons = 0;
        
        while(numberOfWeapons < 1 || numberOfWeapons > 4){
            
            System.out.println("Number of weapons per player, between 1 and 4:");
            
            numberOfWeapons = sc.nextInt();
            
            System.out.println(" ");
        }
        
        return numberOfWeapons;
    }
    
    
    
    public static int[][] chooseWeapons(int numberOfPlayers, int numberOfWeapons){
        
        Scanner sc=new Scanner(System.in);
        
        int weapons[][] = new int[numberOfPlayers][numberOfWeapons];
        
        for(int i = 0 ; i < numberOfPlayers ; i++){
            
            if(numberOfWeapons == 1){
                
                System.out.println("Player " + (i + 1) + ", choose 1 weapon by entering a number (bomb = 1, laser = 2, dash = 3, phase = 4):");
            }
            
            else{
                
                System.out.println("Player " + (i + 1) + ", choose " + numberOfWeapons + " weapons by entering numbers seperated by spaces (bomb = 1, laser = 2, dash = 3, phase = 4):");
            }
            
            for(int j = 0 ; j < numberOfWeapons ; j++){
                
                weapons[i][j] = 0;
                
                while(weapons[i][j] < 1 || weapons[i][j] > 4){
                    
                    weapons[i][j] = sc.nextInt();
                }
            }
            
            System.out.println(" ");
        }
        
        return weapons;
    }
    
    
    
    public static int visualRepresentationOfWeapons(int numberOfPlayers, int numberOfWeapons, int weapons[][]){
        
        for(int i = 0 ; i < numberOfPlayers ; i++){
            
            System.out.print((i + 1) + ": ");
            
            for(int j = 0 ; j < numberOfWeapons ; j++){
                
                if(j + 1 == numberOfWeapons){
                    
                    System.out.println(weapons[i][j]);
                }
                
                else{
                    
                    System.out.print(weapons[i][j] + " ");
                }
            }
        }
        
        return 0;
    }
            
            
    
    public static int[] getCoordinates(SimpleWindow gameboard, int sideLength){
        
        int nextCoordinates[] = {sideLength, sideLength};
        
        while(nextCoordinates[0] >= sideLength || nextCoordinates[1] >= sideLength){
            
            gameboard.waitForMouseClick();
            
            nextCoordinates[0] = (int) Math.floor(gameboard.getMouseX() / 50);
            nextCoordinates[1] = (int) Math.floor(gameboard.getMouseY() / 50);
        }
        
        return nextCoordinates;
    }
}
