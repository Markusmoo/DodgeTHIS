package ca.tonsaker.dodgethis;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.tonsaker.dodgethis.gui.Button;
import ca.tonsaker.simplegameengine.engine.EngineFrame;
import ca.tonsaker.simplegameengine.engine.graphics.Sprite;

public class MainMenuScreen implements EngineFrame, ActionListener{
	
	Sprite background;
	
	Button buttonPlay;
	Button buttonConnect;
	Button buttonHost;
	
	Main main;

	public MainMenuScreen(Main m){
		main = m;
	}
	
	@Override
	public void init() {
		background = new Sprite(0, 0, main.getWidth()+10, main.getHeight()+10, "res/main_menu_background.jpg");
		
		buttonPlay = new Button(main.getWidth()/2-50,main.getHeight()/4+main.getHeight()/2+25,100,50,"2 Player", Color.BLACK, "res/BlackOutlined_Button.png");
		buttonConnect = new Button(main.getWidth()/4-50,main.getHeight()/4+main.getHeight()/2+25,100,50,"Connect", Color.BLACK, "res/BlackOutlined_Button.png");
		buttonHost = new Button(main.getWidth()/4+main.getWidth()/2-50,main.getHeight()/4+main.getHeight()/2+25,100,50,"Host", Color.BLACK, "res/BlackOutlined_Button.png");
		
		buttonPlay.setImageClicked("res/GreenOutlined_Button.png");
		buttonConnect.setImageClicked("res/GreenOutlined_Button.png");
		buttonHost.setImageClicked("res/GreenOutlined_Button.png");
		
		main.addMouseListener(buttonPlay);
		main.addMouseListener(buttonConnect);
		main.addMouseListener(buttonHost);
		
		buttonPlay.addActionListener(this);
		buttonConnect.addActionListener(this);
		buttonHost.addActionListener(this);
	}

	@Override
	public void render(Graphics2D g) {
		background.render(g);
		buttonPlay.render(g);
		buttonConnect.render(g);
		buttonHost.render(g);
	}

	@Override
	public void update() {}
	
	private void cleanup(){
		main.removeMouseListener(buttonPlay);
		main.removeMouseListener(buttonConnect);
		main.removeMouseListener(buttonHost);
		main = null;
		buttonPlay = null;
		buttonConnect = null;
		buttonHost = null;
		background = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == buttonPlay){
			System.out.println("Switching Screens: PLAY");
			main.switchScreen(Main.SCREEN_PLAY);
			cleanup();
		}else if(src == buttonConnect){
			System.out.println("Switching Screens: CONNECT");
			main.switchScreen(Main.SCREEN_CONNECT);
			cleanup();
		}else if(src == buttonHost){
			System.out.println("Switching Screens: HOST");
			main.switchScreen(Main.SCREEN_HOST);
			cleanup();
		}
	}

}
