public class Positions {
    
    public static boolean[][] boundaryPositions(int sideLength){
        
        boolean positions[][] = new boolean[sideLength + 2][sideLength + 2];
        
        for(int i = 0 ; i < sideLength + 2 ; i++){
            
            for(int j = 0 ; j < sideLength + 2 ; j++){
                
                if(i == 0 || j == 0 || i == sideLength + 1 || j == sideLength + 1){
                    
                    positions[i][j] = true;
                }
                
                else{
                    
                    positions[i][j] = false;
                }
            }
        }
        
        return positions;
    }
    
    public static boolean[][] playerStartPositions(boolean positions[][], int sideLength, int numberOfPlayers){
        
        positions[2][2] = true;
        
        positions[sideLength - 1][2] = true;
        
        if(numberOfPlayers > 2){
            
            positions[sideLength - 1][sideLength - 1] = true;
            
            if(numberOfPlayers == 4){
                
                positions[2][sideLength - 1] = true;
            }
        }
        
        return positions;
    }
    
    
    
    public static boolean[][] nextPosition(boolean positions[][], int sideLength, int nextX, int nextY){
        
        positions[nextX + 1][nextY + 1] = true;
        
        return positions;
    }
    
    
    
    public static boolean[][] erasePositionBomb(){
        
        boolean positions[][] = new boolean[4][4];
        
        return positions;
    }//Not finished
    
    public static boolean[][] erasePositionLaser(){
        
        boolean positions[][] = new boolean[4][4];
        
        return positions;
    }//Not finished
    
    
    
    public static int visualRepresentation(boolean positions[][], int sideLength){
        
        System.out.print("  ");
        
        for(int i = 0 ; i < sideLength + 2 ; i++){
            
            for(int j = 0 ; j < sideLength + 2 ; j++){
                
                if((j + 1) % (sideLength + 2) == 0){
                    
                    System.out.println(positions[j][i]);
                    
                    if(positions[j][i] == true){
                        
                        System.out.print("  ");
                    }
                    
                    else{
                        
                        System.out.print(" ");
                    }
                }
                
                else{
                    
                    System.out.print(positions[j][i]);
                    
                    if(positions[j][i] == true){
                        
                        System.out.print("  ");
                    }
                    
                    else{
                        
                        System.out.print(" ");
                    }
                }
            }
        }
        
        return 0;
    }
    
    
    
    public static boolean legalityOfMove(boolean positions[][], int sideLength, int activePositionX, int activePositionY, int nextPositionX, int nextPositionY, int weapon){
        
        if(nextPositionX == activePositionX && nextPositionY == activePositionY){
            //The player cannot move to the same square they are standing on
            
            return false;
        }
        
        else if(nextPositionX < activePositionX - 1 || nextPositionX > activePositionX + 1 || nextPositionY < activePositionY - 1 || nextPositionY > activePositionY + 1){
            //The player cannot move more than one square in each direction
            
            return false;
        }
        
        else if(positions[nextPositionX + 1][nextPositionY + 1] == true){
            //The player cannot move to a taken spot unless they use the laser or phase weapon
            
            if(weapon != 2 && weapon != 4){
                //They choose not to use the weapon which makes them unable to move to the taken position
                
                return false;
            }
            
            else{
                //They choose to use the weapon which makes them able to mote to the taken position
                
                return true;
            }
        }
        
        else{
            //The player moves
            
            return true;
        }
    }//Not finished
    
    public static boolean canPlayerMove(boolean positions[][], int sideLength, int activePositionX, int activePositionY, int weaponStatusLaser, int weaponStatusPhase){
        
        if(weaponStatusLaser > 0 || weaponStatusPhase > 0){
            
            return true;
        }
        
        else{
            
            boolean positionsAroundPlayer[] = new boolean[8];
        
            positionsAroundPlayer[0] = positions[activePositionX][activePositionY];
            //Left corner over player
            positionsAroundPlayer[1] = positions[activePositionX + 1][activePositionY];
            //Over player
            positionsAroundPlayer[2] = positions[activePositionX + 2][activePositionY];
            //Right corner over player
            positionsAroundPlayer[3] = positions[activePositionX][activePositionY + 1];
            //Left of player
            positionsAroundPlayer[4] = positions[activePositionX + 2][activePositionY + 1];
            //Right of player
            positionsAroundPlayer[5] = positions[activePositionX][activePositionY + 2];
            //Left corner below player
            positionsAroundPlayer[6] = positions[activePositionX + 1][activePositionY + 2];
            //Below player
            positionsAroundPlayer[7] = positions[activePositionX + 2][activePositionY + 2];
            //Right corner below player
            
            int counter = 0;
            
            for(int i = 0 ; i < 8 ; i++){
                
                if(positionsAroundPlayer[i] == true){
                    counter++;
                }
            }
            
            if(counter == 8){
                
                return false;
            }
            
            else{
                
                return true;
            }
        }
    }//Not finished
    
    
    
    public static int[] activeStartPositions(int numberOfPlayers, int sideLength){
        int activePositions[] = new int[numberOfPlayers * 2];
        
        activePositions[0] = 1;
        activePositions[1] = 1;
        //Player 1 X & Y
            
        activePositions[2] = sideLength - 2;
        activePositions[3] = 1;
        //Player 2 X & Y
        
        if(numberOfPlayers > 2){
            
            activePositions[4] = sideLength - 2;
            activePositions[5] = sideLength - 2;
            //Player 3 X & Y
            
            if(numberOfPlayers == 4){
                
                activePositions[6] = 1;
                activePositions[7] = sideLength - 2;
                //Player 4 X & Y
            }
        }
        
        return activePositions;
    }
}
