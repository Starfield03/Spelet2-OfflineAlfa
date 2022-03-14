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
    
    public static boolean[][] nextPosition(){
        
        boolean startPositions[][] = new boolean[4][4];
        
        return startPositions;
    }
    
    
    
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
    
    
    
    public static int legalityOfMove(){
        
        return 0;
    }
    
    public static boolean canPlayerMove(){
        
        return true;
    }
    
    
    
    public static int[] activeStartPositions(){
        int i[] = {1,2};
        return i;
    }
}
