
package Game;

import java.awt.image.BufferedImage;

public class Assets {
    
    public static BufferedImage player, enemy, background, laser, explosion, gameover, enemyLaser, hp, menuBackground;
    public static void init() {
        player = ImageLoader.loadImage("Data/space_fighter.png");
        enemy = ImageLoader.loadImage("Data/space_fighter.png");
        background = ImageLoader.loadImage("Data/game_background.png");
        laser = ImageLoader.loadImage("Data/laser_red.png");
        explosion = ImageLoader.loadImage("Data/explosion.png");
        
    }

}
