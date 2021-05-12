package Game;

import javax.swing.JOptionPane;

/**
 * This class is used for the actual game to work.
 * @author Cedric Christoph
 * @since 1.0.0
 * @version 1.0.0
 */
public class Game {
    /**
     * Final integers for turn values
     */
    private final int TURN_PLAYER_ONE = 1;
    private final int TURN_PLAYER_TWO = 2;
    
    /**
     * Playground variables for each player
     */
    private Playground playerOne, playerTwo;
    
    /**
     * Integer variable for saving the turn (use above given finals)
     */
    private int turn;
    
    /**
     * Boolean variable to save wether the actual turn ended or not
     */
    private boolean finished;
    
    /**
     * Constructor given two playgrounds for each player
     * @param one Playground for player one
     * @param two Playground for player two
     */
    public Game (Playground one, Playground two)
    {
        playerOne = one;
        playerTwo = two;
        turn = TURN_PLAYER_ONE;
        finished = false;
    }
    
    /**
     * Constructor given two playgrounds for each player, the turn and if has been finished
     * @param one Playground for player one
     * @param two Playground for player two
     * @param turn Integer actual turn (1 or 2)
     * @param finished Boolean if turn is completed or not
     */
    public Game (Playground one, Playground two, int turn, boolean finished)
    {
        playerOne = one;
        playerTwo = two;
        this.turn = turn;
        this.finished = finished;
    }
    
    /**
     * Constructor given an Game object
     * @param game 
     */
    public Game (Game game)
    {
        playerOne = game.getPlayerOne();
        playerTwo = game.getPlayerTwo();
        turn = game.getTurn();
        finished = game.getFinished();
    }
    
    /**
     * Method for switching turns
     */
    public void switchTurn()
    {
        if (turn == TURN_PLAYER_ONE)
            turn = TURN_PLAYER_TWO;
        else
            turn = TURN_PLAYER_ONE;
        finished = false;
    }
    
    /**
     * Function to shoot the playgrounds depending on who has the turn
     * @param x X to shoot
     * @param y Y to shoot
     * @return Boolean true if ship has been hit.
     */
    public boolean shoot(int x, int y) 
    {
        if (!(finished)) {
            finished = true;
            switch(turn) {
                case TURN_PLAYER_ONE:
                    return playerTwo.shoot(x, y);
                case TURN_PLAYER_TWO:
                    return playerOne.shoot(x, y);
                default:
                    return false;
            }
        }
        JOptionPane.showMessageDialog(null, "¡Tu turno ya acabó! Presiona \"Next\" para continuar");
        return false;
    }
    
    /**
     * Function to get the playground that is being attacked
     * @return Playground
     */
    public Playground getActivePlayground() 
    {
        if (turn == TURN_PLAYER_ONE)
            return playerTwo;
        else
            return playerOne;
    }

    /**
     * Function to get final integer TURN PLAYER ONE
     * @return Integer 1
     */
    public int TURN_PLAYER_ONE() 
    {
        return TURN_PLAYER_ONE;
    }

    /**
     * Funtion to get final integer TURN_PLAYER_TWO
     * @return Integer 2
     */
    public int TURN_PLAYER_TWO() 
    {
        return TURN_PLAYER_TWO;
    }

    /**
     * Function to get the boolean value of finished
     * @return Boolean finished
     */
    public boolean getFinished() 
    {
        return finished;
    }
    
    /**
     * Function to get playground of player one
     * @return Playground player one
     */
    public Playground getPlayerOne() 
    {
        return playerOne;
    }

    /**
     * Function to get playground of player two
     * @return Playground player two
     */
    public Playground getPlayerTwo() 
    {
        return playerTwo;
    }

    /**
     * Function to get the integer value of turn
     * @return Integer 1 or 2
     */
    public int getTurn() 
    {
        return turn;
    }
    
    /**
     * Method for setting player ones playground
     * @param playerOne Playground player one
     */
    public void setPlayerOne(Playground playerOne) 
    {
        this.playerOne = playerOne;
    }

    /**
     * Method for setting player twos playground
     * @param playerTwo Playground player two
     */
    public void setPlayerTwo(Playground playerTwo) 
    {
        this.playerTwo = playerTwo;
    }
    
    /**
     * Method for changing the value of finished
     * @param finished Boolean finished
     */
    public void setFinished(boolean finished) 
    {
        this.finished = finished;
    }
    
    /**
     * Method for changing the value of turn
     * @param turn Integer 1 or 2
     */
    public void setTurn(int turn) 
    {
        this.turn = turn;
    }
    
    /**
     * Depending on who has the turn, this function tells wether all ships have been destroyed or not
     * @return Boolean true if all ships have been destroyed
     */
    public boolean allShipsDestroyed()
    {
        switch (turn) {
            case TURN_PLAYER_ONE:
                return checkShips(playerTwo);
            case TURN_PLAYER_TWO:
                return checkShips(playerOne);
        }
        return false;
    }
    
    /**
     * Checks if all ships are destroyed on a playground
     * @param playground Playground to check
     * @return Boolean true if all ships are destroyed on the playground
     */
    private boolean checkShips(Playground playground)
    {
        int ships = 0;
        int hittedShips = 0;
        for (Field[] line : playground.getMap()) {
            for (Field f : line) {
                if (f.isOccupied())
                    ships += 1;
                if (f.isOccupied() && f.isHit())
                    hittedShips += 1;
                System.out.println(f.getX() + " " + f.getY() + " " + f.isOccupied() + " " + f.isHit() + " " + ships);
            }
            
        }
        System.out.println(ships + " " + hittedShips);
        return ships == hittedShips;
    } 
    
}
