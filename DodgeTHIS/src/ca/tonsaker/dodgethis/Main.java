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
	private static int currentScreen = 0;
	
	//Host to connect to and/or port to host on
	public static int port = 25544;
	public static byte[] ip = {127,0,0,1};
	
	//Screen Classes
	public MainMenuScreen mainMenuScreen;
	public HostScreen     hostScreen;

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
	
	public void switchScreen(int screen){
		Main.currentScreen = screen;
		switch(currentScreen){
			case(SCREEN_MAIN_MENU): mainMenuScreen.init(); break;
			case(SCREEN_CONNECT): break;
			case(SCREEN_HOST): hostScreen.init(); break;
			case(SCREEN_PLAY): break;
			default: throw new IllegalStateException("Unknown screen requested!");
		}
	}

	@Override
	public void init(){
		mainMenuScreen = new MainMenuScreen(this);
		hostScreen = new HostScreen(this);
		switchScreen(Main.SCREEN_MAIN_MENU);
	}

	@Override
	public void update() {
		switch(currentScreen){
			case(SCREEN_MAIN_MENU): mainMenuScreen.update(); break;
			case(SCREEN_CONNECT): break;
			case(SCREEN_HOST): hostScreen.update(); break;
			case(SCREEN_PLAY): break;
			default: throw new IllegalStateException("Unknown screen requested!");
		}
	}

	@Override
	public void render(Graphics2D g) {
		switch(currentScreen){
			case(SCREEN_MAIN_MENU): mainMenuScreen.render(g); break;
			case(SCREEN_CONNECT): break;
			case(SCREEN_HOST): hostScreen.render(g); break;
			case(SCREEN_PLAY): break;
			default: throw new IllegalStateException("Unknown screen requested!");
		}
	}
	
}
