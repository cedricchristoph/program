/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Image;

/**
 * Class for creating a fighter inside the game
 * @author Cedric Christoph
 */
public class Fighter {
    
    // VARIABLES
    private String name;
    private Integer phaserPower, rocketPower, hp;
    private Integer x, y;
    private Image image;
    
    // CONSTRUCTORS
    public Fighter(Image image) {
        this.x = 0;
    }
}
