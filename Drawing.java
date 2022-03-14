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
    
    
    
    public static int bomb(){
        
        return 0;
    }
    
    public static int laser(){
        
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
}