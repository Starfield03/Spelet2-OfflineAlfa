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
        
        SimpleWindow gameboard = new SimpleWindow(sideLength * 50 + 350, sideLength * 50 + 1, "Gameboard");
        
        Drawing.drawGrid(gameboard, sideLength);
        
        Drawing.drawWeaponIcons(gameboard, sideLength, numberOfPlayers);
        Drawing.drawWeaponCounter(gameboard, sideLength, numberOfPlayers, weapons); //Temporary
        
        Drawing.drawRound(gameboard, sideLength);
        Drawing.drawRoundNumber(gameboard, sideLength, 1); //Temporary
        
        Drawing.drawTurn(gameboard, sideLength);
        Drawing.drawTurnSquareAndNumber(gameboard, sideLength, 1); //Temporary
        
        Drawing.drawWeaponMarkOutline(gameboard, sideLength);
        
        gamePhase(gameboard, sideLength, weapons);
    }//Not finished
    
    
    
    public static void gamePhase(SimpleWindow gameboard, int sideLength, int weapons[][]){
        
        int coordinates[] = InformationGathering.getCoordinates(gameboard, sideLength, 1, weapons); //Need player counter
        
        System.out.println(coordinates[0] + " " + coordinates[1] + " " + coordinates[2]);
        
        gamePhase(gameboard, sideLength, weapons);
        
        //Needs turn and player counter
    }//Not finished
    
    
    
    public static void endPhase(){
        
        
    }//Not finished
}