package ca.tonsaker.dodgethis.gui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ca.tonsaker.simplegameengine.engine.InputHandler;

public class TextField implements MouseListener{
	
	protected Rectangle rect;
	
	public String text;
	public int x;
	public int y;
	public int width;
	public int height;
	
	public boolean fill = true;
	
	protected InputHandler input;
	protected boolean hasFocus = false;
	
	public TextField(int x, int y, int w, int h, String startText, InputHandler in){
		input = in;
		rect = new Rectangle();
		this.setLocation(x, y);
		this.setWidth(w);
		this.setHeight(h);
		this.setText(startText);
	}

	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return this.text;
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
		rect.setLocation(x, y); 
	}
	
	public void setLocation(Point p){
		this.setLocation(p.x, p.y);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setWidth(int w){
		this.width = w;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public void setHeight(int h){
		this.height = h;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	protected void resizeRectangle(){
		rect.setBounds(x, y, width, height);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if(rect.contains(e.getPoint())){
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	public void render(Graphics2D g){
		if(fill){
			g.draw(rect);
		}else{
			g.fill(rect);
		}
	}
}
