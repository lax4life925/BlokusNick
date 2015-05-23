
public class Corner extends Piece {

	public Corner(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 0, 1));
		blockList.add(new Block(this, 1, 0));
	}

	public Corner(Player p) {
		// TODO Auto-generated constructor stub
		this(p,800,700);
	}
}
