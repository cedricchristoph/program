package local;

/**
 * Playground for each player includes the map and the methods for shooting, etc.
 * @author Cedric Christoph
 * @since 1.0.0
 * @version 1.0.0
 */
public class Playground {
    String player;
    Field[][] map;
    
    public Playground (String player)
    {
        this.player = player;
        map = new Field[8][8];
    }
    
    public Playground (String player, Field[][] map) 
    {
        this.player = player;
        this.map = map;
    }

    public String getPlayer() {
        return player;
    }

    public Field[][] getMap() {
        return map;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setMap(Field[][] map) {
        this.map = map;
    }
    
    
    /**
     * Function to shoot a field
     * @param x Row to shoot
     * @param y Column to shoot
     * @return Boolean true if ship has been hitted
     */
    public boolean shoot(int x, int y) {
        return map[x][y].hit();
    }
    
    @Override
    public String toString() {
        String text = "";
        int lineCount = 0;
        for (Field[] line : map) {
            lineCount += 1;
            for (Field f : line) {
                text = text + " " + f.toString() + " |";
            }
            if (!(lineCount == 8))
                text = text + "\n";
        }
        return text;
    }
    
    
}
