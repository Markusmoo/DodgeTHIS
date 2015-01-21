package ca.tonsaker.dodgethis;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.tonsaker.dodgethis.gui.TextField;
import ca.tonsaker.simplegameengine.engine.EngineFrame;

public class HostScreen implements EngineFrame, ActionListener{

	Main main;
	TextField textFieldPort;
	
	public HostScreen(Main main){
		this.main = main;
	}
	
	
	@Override
	public void init() {
		textFieldPort = new TextField(main.getWidth()/4, main.getHeight()/2+main.getHeight()/4,100,50,"    ",main.input); //Integer.toString(Main.port)
		main.addMouseListener(textFieldPort);
	}

	@Override
	public void render(Graphics2D g) {
		textFieldPort.render(g);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
