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
    }//Not finished
    
    public static int drawOldSquares(){
        
        return 0;
    }//Not finished
    
    
    
    public static int drawRound(SimpleWindow gameboard, int sideLength){
        
        gameboard.setLineColor(Color.black);
        gameboard.moveTo(sideLength * 50 + 50, 50);
        gameboard.writeText("Round:");
        
        return 0;
    }
    
    public static int drawRoundNumber(SimpleWindow gameboard, int sideLength, int roundCounter){
        
        gameboard.setLineColor(Color.white);
        gameboard.square(sideLength * 50 + 100, 40, 10);
        
        gameboard.setLineColor(Color.black);
        gameboard.moveTo(sideLength * 50 + 100, 50);
        gameboard.writeText(roundCounter + " ");
        
        return 0;
    }
    
    
    
    public static int drawTurn(SimpleWindow gameboard, int sideLength){
        
        gameboard.setLineColor(Color.black);
        gameboard.moveTo(sideLength * 50 + 200, 50);
        gameboard.writeText("Turn:");
        
        gameboard.setLineWidth(1);
        
        for(int i = 0 ; i < 2 ; i++){
            //Draws bounduary of turn square
            
            gameboard.moveTo(sideLength * 50 + 250, 28 + i * 50);
            gameboard.lineTo(sideLength * 50 + 300, 28 + i * 50);
            
            gameboard.moveTo(sideLength * 50 + 250 + i * 50, 28);
            gameboard.lineTo(sideLength * 50 + 250 + i * 50, 78);
        }
        
        gameboard.moveTo(sideLength * 50 + 253, 23);
        gameboard.writeText("Player");
        
        return 0;
    }
    
    public static int drawTurnSquareAndNumber(SimpleWindow gameboard, int sideLength, int player){
        
        gameboard.setLineColor(Color.white);
        gameboard.square(sideLength * 50 + 293, 13, 10);
        //Draws a white square over the previous turn number
        
        gameboard.setLineColor(Color.black);
        gameboard.moveTo(sideLength * 50 + 293, 23);
        gameboard.writeText(player + " ");
        //Writes which players turn it is
        
        Color turnSquare;
        
        if(player == 1){
            
            turnSquare = new Color(255, 0, 0);
        }
        
        else if(player == 2){
            
            turnSquare = new Color(0, 0, 255);
        }
        
        else if(player == 3){
            
            turnSquare = new Color(0, 255, 0);
        }
        
        else{
            
            turnSquare = new Color(255, 255, 0);
        }
        
        gameboard.setLineColor(turnSquare);
        gameboard.square(sideLength * 50 + 251, 29, 49);
        //Draws which players turn it is
        
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
    
    public static int drawWeaponCounter(SimpleWindow gameboard, int sideLength, int numberOfPlayers, int weapons[][]){
        
        for(int i = 0 ; i < numberOfPlayers ; i++){
            
            for(int j = 0 ; j < 4 ; j++){
                
                gameboard.setLineColor(Color.white);
                gameboard.square(sideLength * 50 + 122 + j * 50,  156 + 20 * i, 9);
                //Draws over the old weapon numbers
                
                gameboard.setLineColor(Color.black);
                gameboard.moveTo(sideLength * 50 + 122 + j * 50, 150 + 15 + 20 * i);
                gameboard.writeText(weapons[i][j] + " ");
                //Draws the weapon numbers
            }
        }
        
        return 0;
    }
    
    
    
    public static int drawOverDeadPlayer(){
        
        //When a player dies, draw over their weapons with a black line to show that they are dead
        
        return 0;
    }//Not finished
}