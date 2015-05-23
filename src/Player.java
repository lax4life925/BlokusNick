import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;


public class Player {

	private Color color;
	private int turn;
	private List<Piece> usablePieces;
	private boolean firstMove = true;
	private Location startingLoc;
	//player blue's turn = 0
	//player yellow's turn = 1
	//player red's turn = 2
	//player green's turn = 3
	public Player(Color c, int t) {
		// TODO Auto-generated constructor stub
		usablePieces = new ArrayList<Piece>();
		turn = t;
		color = c;		
		Piece.fill(usablePieces,this);

		startingLoc = new Location(1,1);
		
		switch (turn){
		case 0: startingLoc = new Location(1,20);
				break;
		case 1: startingLoc = new Location(1,1);
				break;
		case 2: startingLoc = new Location(20,1);
				break;
		case 3: startingLoc = new Location(20,20);
				break;
		}
		System.out.println("The player with color " + c + " starts at Location (" + startingLoc.getX() + "," + startingLoc.getY() + ").");
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	public int getTurn(){
		return turn;
	}
	public List<Piece> getAvailablePieces(){
		return usablePieces;
	}
	public boolean firstMove(){
		return firstMove;
	}

	public Location getStartingLocation() {
		// TODO Auto-generated method stub
		return startingLoc;
	}

	public void firstMoveComplete() {
		// TODO Auto-generated method stub
		firstMove = false;
	}
}
