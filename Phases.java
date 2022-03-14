import java.awt.Color;

public class Phases {

    public static void main(String[] args) {
        
        informationPhase();
    }
    
    public static void informationPhase(){
        
        int numberOfPlayers = InformationGathering.numberOfPlayers();
        
        int sideLength = InformationGathering.sideLength();
        
        int numberOfWeapons = InformationGathering.numberOfWeapons();
                    
        int weapons[][] = InformationGathering.chooseWeapons(numberOfPlayers, numberOfWeapons);
        
        preGamePhase(numberOfPlayers, sideLength, numberOfWeapons, weapons);
    }
    
    
    
    public static void preGamePhase(int numberOfPlayers, int sideLength, int numberOfWeapons, int weapons[][]){
        
        boolean positions[][] = Positions.playerStartPositions(Positions.boundaryPositions(sideLength), sideLength, numberOfPlayers);
        
        SimpleWindow gameboard = new SimpleWindow(sideLength * 50 + 100, sideLength * 50 + 1, "Gameboard");
        
        Drawing.drawGrid(gameboard, sideLength);
        
        
    }
    
    
    
    public static void gamePhase(){
        
        
    }
    
    
    
    public static void endPhase(){
        
        
    }
}