package ca.tonsker.DodgeTHIS;

import java.awt.Graphics2D;

import ca.tonsaker.SimpleGameEngine.engine.EngineFrame;
import ca.tonsaker.SimpleGameEngine.engine.graphics.Sprite;

public class MainMenuScreen implements EngineFrame{
	
	Sprite background;
	
	Main main;

	public MainMenuScreen(Main m){
		main = m;
	}
	
	@Override
	public void init() {
		background = new Sprite(0, 0, main.getWidth()+10, main.getHeight()+10, "res/main_menu_background.jpg");
	}

	@Override
	public void render(Graphics2D g) {
		background.render(g);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
