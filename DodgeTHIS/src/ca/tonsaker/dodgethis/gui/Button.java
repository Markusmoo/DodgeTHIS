package ca.tonsaker.dodgethis.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import ca.tonsaker.simplegameengine.engine.graphics.Sprite;

public class Button implements MouseListener{

	protected Sprite b;
	protected String text;
	protected Color textColour;
	protected BufferedImage preClickedImage;
	protected BufferedImage clickedImage;
	
	protected ArrayList<ActionListener> listeners;
	
	protected boolean buttonContainsClick = false;
	
	public Button(int x, int y, int w, int h, String text, Color textColour, String img){
		listeners = new ArrayList<ActionListener>();
		b = new Sprite(x, y, w, h, img);
		setImagePreClicked(img);
		if(textColour == null) textColour = Color.black;
		setText(text, textColour);
	}
	
	public void setText(String text, Color col){
		this.text = text;
		this.textColour = col;
	}
	
	public String getText(){
		return text;
	}
	
	public Color getTextColour(){
		return textColour;
	}
	
	public void setX(int x){
		b.setX(x);
	}
	
	public int getX(){
		return b.getX();
	}
	
	public void setY(int y){
		b.setY(y);
	}
	
	public int getY(){
		return b.getY();
	}
	
	public void setWidth(int w){
		b.setWidth(w);
	}
	
	public int getWidth(){
		return b.getWidth();
	}
	
	public void setHeight(int h){
		b.setHeight(h);
	}
	
	public int getHeight(){
		return b.getHeight();
	}
	
	public void setImagePreClicked(String path){
		try {
			preClickedImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		b.setImage(preClickedImage);
	}
	
	public void setImagePreClicked(BufferedImage image){
		b.setImage(image);
		preClickedImage = image;
	}
	
	public BufferedImage getImagePreClicked(){
		return b.getImage();
	}
	
	public void setImageClicked(String path){
		try {
			clickedImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setImageClicked(BufferedImage image){
		clickedImage = image;
	}
	
	public BufferedImage getImageClicked(){
		return clickedImage;
	}
	
	public boolean contains(Point p){
		if(b.contains(p)){
			return true;
		}else{
			return false;
		}
	}

	public void render(Graphics2D g){
		Rectangle2D text = g.getFontMetrics().getStringBounds(getText(), g);
		Color orgColour = g.getColor();
		g.setColor(textColour);
		b.render(g);
		g.drawString(getText(), (float) (getX()+getWidth()/2-text.getWidth()/2), (float) (getY()+getHeight()/2+text.getHeight()/2));
		g.setColor(orgColour);
	}
	
	public void addActionListener(ActionListener actionListener){
		listeners.add(actionListener);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if(b.contains(e.getPoint())){
			buttonContainsClick = true;
			if(clickedImage != null) b.setImage(clickedImage);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(buttonContainsClick && b.contains(e.getPoint())){
			for(ActionListener a : listeners){
				a.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "CLICK"));
				if(preClickedImage != null) b.setImage(preClickedImage);
			}
		}else{
			buttonContainsClick = false;
			if(preClickedImage != null) b.setImage(preClickedImage);
		}
	}

}
