package ca.tonsaker.dodgethis.gui;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import ca.tonsaker.simplegameengine.engine.InputHandler;

//TODO Text Alignment
public class TextField implements MouseListener{
	
	public static final int ALIGNMENT_CENTER = 0;
	public static final int ALIGNMENT_LEFT = 1;
	public static final int ALIGNMENT_RIGHT = 2;
	
	protected Rectangle rect;
	
	public String text;
	public int textAlignment = ALIGNMENT_CENTER;
	
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
		in.addKeyListener(new KeyListener(){

			private int specialID = 0;
			
			@Override
			public void keyPressed(KeyEvent e) {
				specialID = e.getKeyCode();
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {
				if(specialID == KeyEvent.VK_BACK_SPACE){
					System.out.println("BAC");
					setText(getText().substring(0, getText().length()-1));
				}else if(specialID == KeyEvent.VK_DELETE){
					//TODO Delete last character
				}
				if(hasFocus){
					setText(getText()+e.getKeyChar());
				}
			}
			
		});
	}

	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return this.text;
	}
	
	public void setTextAlignment(int alignment){
		if(textAlignment == TextField.ALIGNMENT_CENTER ||
				textAlignment == TextField.ALIGNMENT_LEFT ||
				textAlignment == TextField.ALIGNMENT_RIGHT){
		}else{
			throw new IllegalArgumentException("TextField textAlignment is set to an illegal value: "+textAlignment);
		}
		this.textAlignment = alignment;
	}
	
	public int getTextAlignment(){
		return textAlignment;
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
		resizeRectangle();
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
		resizeRectangle();
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public void setHeight(int h){
		this.height = h;
		resizeRectangle();
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
			System.out.println(e.getPoint()); //TODO Debug
			hasFocus = true;
		}else{
			hasFocus = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	public void render(Graphics2D g){
		if(fill && rect != null){
			g.draw(rect);
		}else if(rect != null){
			g.fill(rect);
		}
		if(textAlignment == TextField.ALIGNMENT_CENTER){
			FontMetrics fm = g.getFontMetrics();
			Rectangle2D t = fm.getStringBounds(getText(), g);
			g.drawString(getText(), (float)(x+width/2-t.getWidth()/2), (float)(y+height/2+t.getHeight()/2));
		}else if(textAlignment == TextField.ALIGNMENT_LEFT){
			//TODO Complete
		}else if(textAlignment == TextField.ALIGNMENT_RIGHT){
			//TODO Complete
		}else{
			throw new IllegalStateException("TextField textAlignment is set to an illegal value: "+textAlignment);
		}
	}
}
