import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Player {

	private Color color;
	private int turn;
	private List<Piece> usablePieces;
	//player blue's turn = 0
	//player yellow's turn = 1
	//player red's turn = 2
	//player green's turn = 3
	public Player(Color c, int x) {
		// TODO Auto-generated constructor stub
		usablePieces = new ArrayList<Piece>();
		Piece.fill(usablePieces,this);
		turn = x;
		color = c;
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

}
