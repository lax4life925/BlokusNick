
public class Corner extends Piece {

	public Corner(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(p.getColor(), this, 0, 0));
		blockList.add(new Block(p.getColor(), this, 0, 1));
		blockList.add(new Block(p.getColor(), this, 1, 0));
	}
}
