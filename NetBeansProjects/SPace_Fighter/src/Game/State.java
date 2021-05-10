/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Graphics;

public abstract class State {

	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected Game game;
	
	public State(Game game) {
		this.game  = game;
	}
	
	//classes
	public abstract void tick();
	public abstract int getX();
	public abstract int getY();
	public abstract void decHP();
	public abstract int getHP();
	public abstract void render (Graphics g); 
}