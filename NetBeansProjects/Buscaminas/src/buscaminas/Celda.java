package buscaminas;

/**
 *
 * @author Cedric Christoph
 * @since 1.0
 * @version 1.0
 */
public abstract class Celda {
    private boolean selected;
    
    public Celda ()
    {
        selected = false;
    }
    
    public abstract boolean esMina();
    
    public void select() 
    {
        selected = true;
    }

    public boolean isSelected() 
    {
        return selected;
    }
    
    
}
