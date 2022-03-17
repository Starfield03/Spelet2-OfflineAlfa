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
        
        int activePositions[] = Positions.activeStartPositions(numberOfPlayers, sideLength);
        
        int players[] = new int[numberOfPlayers];
        
        for(int i = 0 ; i < numberOfPlayers ; i++){
            
            players[i] = i + 1;
        }
        
        SimpleWindow gameboard = new SimpleWindow(sideLength * 50 + 350, sideLength * 50 + 1, "Gameboard");
        
        Drawing.drawGrid(gameboard, sideLength);
        Drawing.drawWeaponIcons(gameboard, sideLength, numberOfPlayers);
        Drawing.drawRound(gameboard, sideLength);
        Drawing.drawTurn(gameboard, sideLength);
        Drawing.drawWeaponMarkOutline(gameboard, sideLength);
        
        for(int i = 0 ; i < numberOfPlayers ; i++){
            
            Drawing.drawNewSquares(gameboard, (i + 1), activePositions[(i + 1) * 2 - 2], activePositions[(i + 1) * 2 - 1]);
        }
        
        gamePhase(gameboard, sideLength, numberOfPlayers, 1, 1, weapons, positions, players, activePositions);
    }
    
    
    
    public static void gamePhase(SimpleWindow gameboard, int sideLength, int numberOfPlayers, int turnCounter, int roundCounter, int weapons[][], boolean positions[][], int players[], int activePositions[]){
        
        int player = players[(turnCounter + numberOfPlayers - 1) % numberOfPlayers];
        
        int counter = 0;
        
        for(int i = 0 ; i < numberOfPlayers; i++){
            //Counts how many players are dead
            
            if(players[i] == 0){
                
                counter++;
            }
        }
        
        if(player == 0){
            //If the player is dead, their turn gets skipped
            
            if((turnCounter + numberOfPlayers - 1) % numberOfPlayers + 1 == numberOfPlayers){
                //If the player is the last in the turn order the next round begins
                
                roundCounter++;
            }
            
            turnCounter++;
            
            Drawing.drawOverDeadPlayer(gameboard, (turnCounter + numberOfPlayers - 1) % numberOfPlayers, sideLength);
            //Draw over the players name and weapons to show that they are dead
            
            gamePhase(gameboard, sideLength, numberOfPlayers, turnCounter, roundCounter, weapons, positions, players, activePositions);
        }
        
        else if(counter == numberOfPlayers - 1){ 
            //If only one player lives the end phase gets initiated
            
            boolean canPlayerMove = Positions.canPlayerMove(positions, sideLength, activePositions[player * 2 - 2], activePositions[player * 2 - 1], weapons[player - 1][1], weapons[player - 1][3]);
            
            if(canPlayerMove == true){ 
                //If the last player alive can move next round, that player wins
                
                endPhase(gameboard, sideLength, players, numberOfPlayers, false);
            }
            
            else{ 
                //If the last player alive can't move next round, the game becomes a tie
                
                endPhase(gameboard, sideLength, players, numberOfPlayers, true);
            }
        }
        
        else{
            //If several players are alive
            
            boolean canPlayerMove = Positions.canPlayerMove(positions, sideLength, activePositions[player * 2 - 2], activePositions[player * 2 - 1], weapons[player - 1][1], weapons[player - 1][3]);
            
            if(canPlayerMove == false){
                //If the player cannot move they die
                
                if((turnCounter + numberOfPlayers - 1) % numberOfPlayers + 1 == numberOfPlayers){ 
                    //If it is the last players turn
                    
                    roundCounter++;
                }
                
                players[(turnCounter + numberOfPlayers - 1) % numberOfPlayers] = 0; //Player dies
        
                gamePhase(gameboard, sideLength, numberOfPlayers, turnCounter, roundCounter, weapons, positions, players, activePositions);
            }
            
            else{
                //If the player can move, either with or without the help of a weapon
                
                Drawing.drawWeaponCounter(gameboard, sideLength, numberOfPlayers, weapons);
                Drawing.drawRoundNumber(gameboard, sideLength, player);
                Drawing.drawTurnSquareAndNumber(gameboard, sideLength, player);
                
                for(int i = 0 ; i < numberOfPlayers ; i++){
                    
                    if(players[i] == 0){
                        
                        Drawing.drawOverDeadPlayer(gameboard, i + 1, sideLength);
                        //Draw over the dead players name and weapons to show that they are dead
                    }
                }
                
                int coordinates[] = InformationGathering.getCoordinates(gameboard, sideLength, player, weapons); //Need player counter
                
                int nextPositionX = coordinates[0];
                int nextPositionY = coordinates[1];
                int weapon = coordinates[2];
                int activePositionX = activePositions[player * 2 - 2];
                int activePositionY = activePositions[player * 2 - 1];
                
                boolean legalityOfMove = Positions.legalityOfMove(positions, sideLength, numberOfPlayers, players, activePositions, activePositionX, activePositionY, nextPositionX, nextPositionY, weapon);
                
                if(legalityOfMove == true){
                    //If the players move is legal, it gets executed
                    
                    Drawing.drawNewSquares(gameboard, player, nextPositionX, nextPositionY);
                    Drawing.drawOldSquares(gameboard, player, activePositionX, activePositionY);
                
                    activePositions[player * 2 - 2] = nextPositionX;
                    activePositions[player * 2 - 1] = nextPositionY;
                
                    positions = Positions.nextPosition(positions, sideLength, nextPositionX, nextPositionY);
                    
                    if((turnCounter + numberOfPlayers - 1) % numberOfPlayers + 1 == numberOfPlayers){ 
                        //If it is the last players turn the round counter goes up
                    
                        roundCounter++;
                    }
                    
                    if(weapon == 0){
                        //If the player does not use any weapons
                        
                        turnCounter++;
                        //Turn goes to the next player
                    }
                    
                    if(weapon == 1){
                        //If the player uses the bomb weapon
                        
                        //Write more code, not finished
                        
                        weapons[player - 1][0]--;
                        //Decreases the amount of this weapon in the players arsenal by one
                        
                        turnCounter++;
                        //Turn goes to the next player
                    }
                    
                    else if(weapon == 2){
                        //If the player uses the laser weapon
                        
                        //Write more code, not finished
                        
                        Drawing.eraseSquaresLaser(gameboard, sideLength, numberOfPlayers, activePositionX, activePositionY, nextPositionX, nextPositionY, activePositions);
                        
                        positions = Positions.erasePositionLaser(positions, sideLength, numberOfPlayers, activePositionX, activePositionY, nextPositionX, nextPositionY, activePositions);
                        
                        weapons[player - 1][1]--;
                        //Decreases the amount of this weapon in the players arsenal by one
                        
                        turnCounter++;
                        //Turn goes to the next player
                    }
                    
                    else if(weapon == 3){
                        //If the player uses the dash weapon
                        
                        //Write more code, not finished
                        
                        weapons[player - 1][2]--;
                        //Decreases the amount of this weapon in the players arsenal by one
                        
                        //Possible exploit of playing several dashes to cover much ground, evaluate if restriction is necessary
                    }
                    
                    else if(weapon == 4){
                        //If the player uses the phase weapon
                        
                        //Write more code, not finished
                        
                        weapons[player - 1][3]--;
                        //Decreases the amount of this weapon in the players arsenal by one
                        
                        turnCounter++;
                        //Turn goes to the next player
                    }
                    
                    gamePhase(gameboard, sideLength, numberOfPlayers, turnCounter, roundCounter, weapons, positions, players, activePositions);
                }
                
                else{
                    //The players move is illegal, they get to try again
                    
                    gamePhase(gameboard, sideLength, numberOfPlayers, turnCounter, roundCounter, weapons, positions, players, activePositions);
                }
            }
        }
    }//Not finished
    
    
    
    public static void endPhase(SimpleWindow gameboard, int sideLength, int players[], int numberOfPlayers, boolean tie){
        
        gameboard.setLineColor(Color.black);
        
        if(tie == true){ 
            //If game ends in a tie
            
            gameboard.moveTo(sideLength * 50 + 50, 250);
            gameboard.writeText("Game ended in a tie.");
        }
        
        else{ 
            //If game doesn't end in a tie
            
            int winningPlayer = 0;
        
            for(int i = 0 ; i < numberOfPlayers ; i++){
            
                if(players[i] != 0){
                
                    winningPlayer = players[i];
                }
            }
        
            String colour;
        
            if(winningPlayer == 1){
            
                colour = "(Red)";
            }
        
            else if(winningPlayer == 2){
            
                colour = "(Blue)";
            }
        
            else if(winningPlayer == 3){
            
                colour = "(Green)";
            }
        
            else{
            
                colour = "(Yellow)";
            }
            
            gameboard.moveTo(sideLength * 50 + 50, 250);
            gameboard.writeText("Player " + winningPlayer + " " + colour + " won.");
        }
    }
}