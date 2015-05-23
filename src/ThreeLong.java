
public class ThreeLong extends Piece{

	public ThreeLong(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(p.getColor(), this, 0, 0));
		blockList.add(new Block(p.getColor(), this, 1, 0));
		blockList.add(new Block(p.getColor(), this, 2, 0));

	}

	public ThreeLong(Player p) {
		// TODO Auto-generated constructor stub
		this(p,800,600);
	}

}
