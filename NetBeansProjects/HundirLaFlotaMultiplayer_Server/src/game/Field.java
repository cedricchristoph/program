package Game;

/**
 * This class builds a field in a playground map.
 * @author Cedric Christoph
 * @since 1.0.0
 * @version 1.0.0
 */
public class Field {
    
    /**
     * Integer variables for the fields position.
     */
    private int x, y;
    
    /**
     * Boolean variables for if the field is occupied by a ship and if the field has been hitted.
     */
    private boolean occupied, hit;
    
    /**
     * Constrcutor given X and Y position of the field
     * @param x Integer X position
     * @param y Integer Y position
     */
    public Field (int x, int y)
    {
        this.x = x;
        this.y = y;
        occupied = false;
        hit = false;
    }
    
    /**
     * Constructor given X and Y position of the field as well as Boolean if occuppied.
     * @param x Integer X position
     * @param y Integer Y position
     * @param occupied Boolean if occupied
     */
    public Field (int x, int y, boolean occupied)
    {
        this.x = x;
        this.y = y;
        this.occupied = occupied;
        hit = false;
    }

    /**
     * Funtion that returns X value
     * @return Integer X
     */
    public int getX()
    {
        return x;
    }

    /**
     * Function that returns Y value
     * @return Integer Y
     */
    public int getY()
    {
        return y;
    }

    /**
     * Function that returns occupied value
     * @return Boolean occupied
     */
    public boolean isOccupied()
    {
        return occupied;
    }

    /**
     * Function that returns hit value
     * @return Boolean hit
     */
    public boolean isHit()
    {
        return hit;
    }

    /**
     * Method to set X value
     * @param x Integer X
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Method to set Y value
     * @param y Integer Y
     */
    public void setY(int y) 
    {
        this.y = y;
    }

    /**
     * Method to set occupied value
     * @param occupied Boolean
     */
    public void setOccupied(boolean occupied)
    {
        this.occupied = occupied;
    }

    /**
     * Function to set hit value
     * @param hit Boolean
     */
    public void setHit(boolean hit)
    {
        this.hit = hit;
    }
    
    /**
     * Method to call when shooting this field
     * @return Boolean occupied (hit or not hit)
     */
    public boolean hit()
    {
        this.hit = true;
        return occupied;
    }
    
    @Override
    /**
     * Function that returns the field as String.
     * X means ship has been hitted
     * 0 can be ship that has not been hitted or just water
     */
    public String toString() 
    {
        if (occupied && hit)
            return "X";
        else if (!(occupied) && hit) 
            return "0";
        //else if (occupied && !(hit))
          //return "!";
        else
            return " ";
    }
}
