package ca.tonsaker.dodgethis;

import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import ca.tonsaker.simplegameengine.engine.EngineFrame;
import ca.tonsaker.simplegameengine.engine.GameEngine;

public class Main extends GameEngine implements EngineFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3244326635983083639L;
	
	//Screens
	public static final int SCREEN_MAIN_MENU = 0;
	public static final int SCREEN_CONNECT = 1;
	public static final int SCREEN_HOST = 2;
	public static final int SCREEN_PLAY = 3;
	
	//Current Screen
	public static int currentScreen = 0;
	
	//Host to connect to and/or port to host on
	public static int port = 25544;
	public static byte[] ip = {127,0,0,1};
	
	//Screen Classes
	public MainMenuScreen mainMenu;

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main(0,0,640,480).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public Main(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.centerWindow();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("DodgeTHIS MiniGame Created by Markus Tonsaker");
		this.setFPS(60);
		this.setUPS(100);
		this.run();
	}

	@Override
	public void init(){
		
		mainMenu = new MainMenuScreen(this);
		
		switch(currentScreen){
			case(SCREEN_MAIN_MENU): mainMenu.init(); break;
			case(SCREEN_CONNECT): break;
			case(SCREEN_HOST): break;
			case(SCREEN_PLAY): break;
			default: throw new IllegalStateException("Unknown screen requested!");
		}
	}

	@Override
	public void update() {
		switch(currentScreen){
			case(SCREEN_MAIN_MENU): mainMenu.update(); break;
			case(SCREEN_CONNECT): break;
			case(SCREEN_HOST): break;
			case(SCREEN_PLAY): break;
			default: throw new IllegalStateException("Unknown screen requested!");
		}
	}

	@Override
	public void render(Graphics2D g) {
		switch(currentScreen){
			case(SCREEN_MAIN_MENU): mainMenu.render(g); break;
			case(SCREEN_CONNECT): break;
			case(SCREEN_HOST): break;
			case(SCREEN_PLAY): break;
			default: throw new IllegalStateException("Unknown screen requested!");
		}
	}
	
}
