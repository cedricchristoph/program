
package Game;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Logger class. This class is used to properly save and load game files.
 * @author Cedric Christoph
 * @since 1.0.0
 * @version 1.0.0
 */
public class Logger {
    
    /**
     * Necessary File variables to save and load a game.
     */
    private File gameFolder, playgroundOneFile, playgroundTwoFile, gameStatusFile;
    
    /**
     * Scanner used for loading game files.
     */
    private Scanner scan;
    
    /**
     * FileWriter used for saving game files.
     */
    private FileWriter writer;
    
    /**
     * Interpretor variable used for properly understand game files.
     * @see Game.Interpretor
     */
    private Interpretor converter;
    
    /**
     * Constructor given a gameFolder File
     * @param gameFolder File
     */
    public Logger (File gameFolder) {
        this.gameFolder = gameFolder;
        playgroundOneFile = new File(gameFolder + "/playerOne.txt");
        playgroundTwoFile = new File(gameFolder + "/playerTwo.txt");
        gameStatusFile = new File (gameFolder + "/status.txt");
    }

    /**
     * Function to get game folder
     * @return File gameFolder
     */
    public File getGameFolder() {
        return gameFolder;
    }

    /**
     * Function to get File of player one's playground
     * @return File playgroundOne
     */
    public File getPlaygroundOne() {
        return playgroundOneFile;
    }

    /**
     * Function to get File of player two's playground
     * @return File playgroundTwo
     */
    public File getPlaygroundTwo() {
        return playgroundTwoFile;
    }

    /**
     * Function to get File of game status
     * @return File gameStatus
     */
    public File getGameStatus() {
        return gameStatusFile;
    }

    /**
     * Method for changing the game folder
     * @param gameFolder File gameFolder
     */
    public void changeGameFolder(File gameFolder) {
        this.gameFolder = gameFolder;
    }

    /**
     * Method for changing the player one's playground file
     * @param playgroundOne File playgroundOne
     */
    public void setPlaygroundOne(File playgroundOne) {
        this.playgroundOneFile = playgroundOne;
    }

    /**
     * Method for changing the player two's playground file
     * @param playgroundTwo File playgroundOne
     */
    public void setPlaygroundTwo(File playgroundTwo) {
        this.playgroundTwoFile = playgroundTwo;
    }

    /**
     * Method for changing the game status file
     * @param gameStatus File gameStatus
     */
    public void setGameStatus(File gameStatus) {
        this.gameStatusFile = gameStatus;
    }

    /**
     * Function that returns a fully loaded game
     * @return Game
     */
    public Game load (){
        try {
            Playground one = loadPlayerOne();
            Playground two = loadPlayerTwo();
            Integer turn = loadTurn();
            boolean finished = loadFinished();
            Game game = new Game(one, two, turn, finished);
            return game;
        } catch (FileNotFoundException fnf) {
            JOptionPane.showMessageDialog(null, "The game files could not be loaded. Files not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error ocurred.\n" + ex.toString() + "\n" + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } 
    }
    
    /**
     * Function that returns saved game status (turn)
     * @return Turn value
     * @throws FileNotFoundException 
     */
    private Integer loadTurn() throws FileNotFoundException {
        scan = new Scanner(gameStatusFile);
        int lineCount = 0;
        String[] line = {"", ""};
        while(!(line[0].equals("turn"))) {
            if (lineCount > 10) {
                JOptionPane.showMessageDialog(null, "Status file corrupted", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            }
            line = scan.nextLine().split(":");
            lineCount++;
        }
        try {
            return Integer.parseInt(line[1]);
        } catch (NumberFormatException ex) {
            return null;
        } catch (Exception ex) {
            return null;
        }
    }
    
    /**
     * Function that returns the finished value
     * @return Boolean finished
     * @throws FileNotFoundException 
     */
    private boolean loadFinished() throws FileNotFoundException {
        scan = new Scanner(gameStatusFile);
        int lineCount = 0;
        String[] line = {"", ""};
        while(!(line[0].equals("finished"))) {
            if (lineCount > 10) {
                JOptionPane.showMessageDialog(null, "Status file damaged", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            }
            line = scan.nextLine().split(":");
            lineCount++;
        }
        try {
            return Boolean.parseBoolean(line[1]);            
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }

    }
    
    /**
     * Function that return playground for player 1
     * @return Playground
     * @throws FileNotFoundException 
     */
    private Playground loadPlayerOne () throws FileNotFoundException {
        Field[][] map = loadPlayer(playgroundOneFile);
        return new Playground("Player One", map);
    }
    
    /**
     * Function that return playground for player 2
     * @return Playground
     * @throws FileNotFoundException 
     */
    private Playground loadPlayerTwo() throws FileNotFoundException {
        Field[][] map = loadPlayer(playgroundTwoFile);
        return new Playground("Player Two", map);
    }
    
    /**
     * Function that return a playground
     * @return Playground
     * @throws FileNotFoundException 
     */
    private Field[][] loadPlayer(File file) throws FileNotFoundException {
        scan = new Scanner(file);
        converter = new Interpretor();
        String playgroundAsString = "";
        int count = 0;
        do {
            count++;
            playgroundAsString += scan.nextLine();
            if (!(count==8))
                playgroundAsString += "\n";
        } while (scan.hasNextLine());
        //JOptionPane.showMessageDialog(null, playgroundAsString);
        return converter.convert(playgroundAsString);
    }
    
    /**
     * Function to save the game
     * @param game Game to save
     * @return Boolean true if game has been saved succesfully. 
     */
    public boolean save(Game game) {
        try {
            saveStatus(game.getTurn(), game.getFinished());
            savePlayerOne(game.getPlayerOne());
            savePlayerTwo(game.getPlayerTwo());
            return true;
        } catch (IOException iox) {
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
    
    /**
     * Method to save the game status value
     * @param turn Integer turn value
     * @param finished Boolean finished value
     * @throws IOException 
     */
    private void saveStatus(int turn, boolean finished) throws IOException {
        writer = new FileWriter(gameStatusFile);
        writer.write("turn:" + String.valueOf(turn) + "\n");
        writer.write("finished:" + String.valueOf(finished));
        writer.close();
    }
    
    /**
     * Method to save player one's playground
     * @param playground Player one's playground
     * @throws IOException 
     */
    private void savePlayerOne(Playground playground) throws IOException {
        savePlayground(playground, playgroundOneFile);
    }
    
    /**
     * Method to save player two's playground
     * @param playground Player two's playground
     * @throws IOException 
     */
    private void savePlayerTwo(Playground playground) throws IOException {
        savePlayground(playground, playgroundTwoFile);
    }
    
    /**
     * Method to save a given playground into a given File
     * @param playground Playground to save
     * @param file File to save the playground
     * @throws IOException 
     */
    private void savePlayground(Playground playground, File file) throws IOException {
        writer = new FileWriter(file);
        String playgroundAsString = "";
        for (Field[] line : playground.getMap()) {
            for (Field f : line) {
                if (f.isOccupied() && f.isHit()) 
                    playgroundAsString += "H | ";
                else if (f.isOccupied() && !(f.isHit()))
                    playgroundAsString += "S | ";
                else if (!(f.isOccupied()) && f.isHit())
                    playgroundAsString += "W | ";
                else
                    playgroundAsString += "  | ";
            }
            playgroundAsString += "\n";
        }
        writer.write(playgroundAsString);
        writer.close();
    }  
}
