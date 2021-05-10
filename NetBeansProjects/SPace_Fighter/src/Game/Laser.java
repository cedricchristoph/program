
package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Laser {
    private int x, y, speed;
    
    public Laser(int x, int y) {
        this.x = x;
        this.y = y;
        speed = 10;
    }
    
    public void tick() {
        y -= speed;
    }
    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.drawImage(Assets.laser, x-13, y-4, null);
    }
    
    public int getX() {
        return y;
    }
    
    public int getY() {
        return y;
    }
}
