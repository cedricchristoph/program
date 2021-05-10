/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Graphics;
import java.util.Random;

public class Enemy extends Creature {

	private long lastFiredLaser = 0;
	private long fireDelay = 2500;

	public Enemy(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		y=y+1;

		if (this.y > 0) {
			Random random = new Random();
			int randNum = random.nextInt(100);
			if (randNum == 0 && lastFiredLaser + fireDelay < System.currentTimeMillis()) {
				lastFiredLaser = System.currentTimeMillis();
				Game.lasers.add(new EnemyLaser((int) (this.x + 32), (int) (this.y + 64)));
			}
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.enemy,(int)x,(int)y,null);   
	}
	
	public int getX() {
		return (int) x;
	}
	
	public int getY() {
		return (int) y;
	}

}