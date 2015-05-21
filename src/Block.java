import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Block {

	public static final int SIZE = 30;
	private Color color;
	private Location relativeLoc;
	private Location screenLoc;
	private Piece piece;
	public Block(Color red,Piece p, int relX, int relY) {
		// TODO Auto-generated constructor stub
		piece = p;
		color = red;
		relativeLoc = new Location(relX,relY);
		screenLoc = new Location(relX*Block.SIZE + p.getX(), relY*Block.SIZE + p.getY());
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.red;
	}
	//relative to piece
	public void setRelativeLoc(int x, int y){
		relativeLoc = new Location(x,y);
	}
	//on screen, top left corner
	public void setScreenLoc(int x, int y){
		screenLoc = new Location(x,y);
	}
	
	public Location getScreenLoc(){
		return screenLoc;
	}
	
	public Location getRelativeLoc(){
		return relativeLoc;
	}


	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(screenLoc.getX(),screenLoc.getY(),SIZE,SIZE);
		return rect.contains(x, y);
			
	}

	public void setScreenLoc(Location screen) {
		// TODO Auto-generated method stub
		screenLoc = screen;
	}
	
	
}
