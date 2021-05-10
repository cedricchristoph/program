package Game;

/**
 * Interpretor class. This class is used to convert strings into playground maps.
 * @author Cedric Christoph
 * @since 1.0.0
 * @version 1.0.0
 */
public class Interpretor {
    
    /**
     * Empty constructor
     */
    public Interpretor()
    {
        
    }
    
    /**
     * This function is used to get a playground map given a certain String
     * @param input String
     * @return A playground map (Field[][])
     */
    public Field[][] convert (String input) {
        int counter = 0;
        for (char c : input.toCharArray()) {
            if (Character.toString(c).equals("|"))
                counter += 1;
        }
        if (counter != 64)
            return null;
        System.out.println(input);
        String[] splitted = input.split("\\|");
        Field[][] map = new Field[8][8];
        counter = 0;
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                switch (splitted[counter].replaceAll(" ", "")){
                    case "S":
                        map[i][j] = new Field(i, j);
                        map[i][j].setOccupied(true);
                        break;
                    case "\nS":
                        map[i][j] = new Field(i, j);
                        map[i][j].setOccupied(true);
                        break;
                    case "H":
                        map[i][j] = new Field(i, j);
                        map[i][j].setOccupied(true);
                        map[i][j].setHit(true);
                        break;
                    case "\nH":
                        map[i][j] = new Field(i, j);
                        map[i][j].setOccupied(true);
                        map[i][j].setHit(true);
                        break;
                    case "W":
                        map[i][j] = new Field(i, j);
                        map[i][j].setHit(true);
                        break;
                    case "\nW":
                        map[i][j] = new Field(i, j);
                        map[i][j].setHit(true);
                        break;
                    default:
                        map[i][j] = new Field(i, j);
                        break;                     
                }
                System.out.println("Valor en " + i + " " + j + "  " + splitted[counter].replaceAll(" ", ""));
                counter += 1;
            }
        }        
        return map;
    }
}
