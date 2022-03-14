import java.awt.Color;

public class Drawing {
    
    public static int drawGrid(SimpleWindow gameboard, int sideLength){
        
        gameboard.setLineColor(Color.black);
        gameboard.setLineWidth(1);
        
        for(int i = 0 ; i < sideLength + 1 ; i++){
            
            gameboard.moveTo(0, i * 50);
            gameboard.lineTo(sideLength * 50, i * 50);
            //Draws horizontal lines
            
            gameboard.moveTo(i * 50, 0);
            gameboard.lineTo(i * 50, sideLength * 50);
            //Draws vertical lines
        }
        
        return 0;
    }
    
    
    
    public static int drawNewSquares(){
        
        return 0;
    }
    
    public static int drawOldSquares(){
        
        return 0;
    }
    
    
    
    public static int drawRound(){
        
        return 0;
    }
    
    public static int drawRoundNumber(){
        
        return 0;
    }
    
    
    
    public static int drawTurn(){
        
        return 0;
    }
    
    public static int drawTurnCircle(){
        
        return 0;
    }
    
    
    
    public static int drawWeaponIcons(SimpleWindow gameboard, int sideLength, int numberOfPlayers){
        
        gameboard.setLineColor(Color.black);
        gameboard.setLineWidth(1);
        
        for(int i = 0 ; i < 2 ; i++){
            //Draws horizontal lines
            
            gameboard.moveTo(sideLength * 50 + 100, 100 + i * 50);
            gameboard.lineTo(sideLength * 50 + 300, 100 + i * 50);
        }
        
        for(int j = 0 ; j < 5 ; j++){
            //Draws vertical lines
            
            gameboard.moveTo(sideLength * 50 + 100 + 50 * j, 100);
            gameboard.lineTo(sideLength * 50 + 100 + 50 * j, 150);
        }
        
        gameboard.moveTo(sideLength * 50 + 109, 130);
        gameboard.writeText("BOMB");
        
        gameboard.moveTo(sideLength * 50 + 156, 130);
        gameboard.writeText("LASER");
        
        gameboard.moveTo(sideLength * 50 + 209, 130);
        gameboard.writeText("DASH");
        
        gameboard.moveTo(sideLength * 50 + 256, 130);
        gameboard.writeText("PHASE");
        
        for(int i = 0 ; i < numberOfPlayers ; i++){
            
            gameboard.moveTo(sideLength * 50 + 50, 150 + 15 + 20 * i);
            gameboard.writeText("Player " + (i + 1) + ":");
        }
        
        return 0;
    }
}