import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;



public class BlokusPanel extends JPanel{
	BlokusBoard board;
	private int GameTurn=0;
	Location firstClick;
	Piece selectedP;
	Block selectedB;
	List<Player> playerList = new ArrayList<Player>();
	 	Player player1;
		Player player2;
		Player player3;
		Player player4;
	MyListener listen= new MyListener(this);
	//player blue's turn = 0
	//player yellow's turn = 1
	//player red's turn = 2
	//player green's turn = 3
	List<Piece> piecesAvailable = new ArrayList<Piece>();
	List<Piece> piecesUsed = new ArrayList<Piece>();
	public BlokusPanel(){
		super();
		this.addMouseListener(listen);
		addMouseMotionListener(listen);
		setPreferredSize(new Dimension(BlokusFrame.width,BlokusFrame.height));
		board = new BlokusBoard(this);
		//setUpTimer();
		setUpPlayers();
		//test();
		//testForPieceFlip();
	}

	private void setUpPlayers() {
		// TODO Auto-generated method stub
		player1 = new Player(Color.blue,0);
		player2 = new Player(Color.yellow,1);
		player3 = new Player(Color.red,2);
		player4 = new Player(Color.green,3);
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);

	}

	private void testForPieceFlip() {
		// TODO Auto-generated method stub
		Piece p = new Corner(playerList.get(0),10,10);
		int i = 1;
		for(Block b : p.blockList){
			int x = b.getRelativeLoc().getX();
			int y = b.getRelativeLoc().getY();
			System.out.println("Block " + i + " x: " + x + " y: " + y);
			
			
		}
		
		p.flipHorizontally();
		System.out.println("Flipped horizontally");
		for(Block b : p.blockList){
			int x = b.getRelativeLoc().getX();
			int y = b.getRelativeLoc().getY();
			System.out.println("Block " + i + " x: " + x + " y: " + y);
			
			
		}
		p.flipHorizontally();
		p.flipVertically();
		System.out.println("Flipped Vertically");
		for(Block b : p.blockList){
			int x = b.getRelativeLoc().getX();
			int y = b.getRelativeLoc().getY();
			System.out.println("Block " + i + " x: " + x + " y: " + y);
			
			
		}
	}

	private void setUpTimer() {
		// TODO Auto-generated method stub

	}

	public void addAllPieces(){
		// we're gonna need to hard code all the pieces individually onto the board I think since
		// we're doing a separate class for each class...
		// also that will give us more control when determining each piece's characteristics
		// all pieces will go into pieces Available list
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		board.draw(g);
		if(whosturn() != null)
			for(Piece p : whosturn().getAvailablePieces()){
				p.draw(g);
			}
		}
	

	private void test() {
		// TODO Auto-generated method stub
		Piece p = new ThreeLong(new Player(Color.red,0), 800, 700);
		Piece p2 = new Corner(new Player(Color.red,1), 800, 600);
		Player player1 = new Player(Color.red,3);
		player1.getAvailablePieces().add(p2);
		player1.getAvailablePieces().add(p);
		playerList.add(player1);
		//piecesAvailable.add(p2);
		//piecesAvailable.add(p);

	}
	public Player whosturn(){
		int x = GameTurn%4;
		for(Player z: this.playerList){
			if(z.getTurn()==x){
				return z;
			}
		}
		return null;
	}


	public boolean selectPiece(int x, int y) {
		Player myTurn = whosturn();
		if(myTurn!=null && myTurn.getAvailablePieces().size() > 0){
			for(Piece z: myTurn.getAvailablePieces()){
				for(Block v: z.blockList){
					if(v.contains(x,y)){
						firstClick= new Location(x,y);
						selectedB=v;
						selectedP=z;
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean dropPiece(int x, int y){
		Location secondClick = new Location (x,y);
		Location secondClkBrd = secondClick.convertToGrid();
		if(board.onGrid(secondClkBrd)){
			if(board.validPlay(x,y,selectedB,selectedP)){
				this.piecesUsed.add(selectedP);
				for(Block block : selectedP.getBlockList()){
					board.add(block);
				}
				boolean remove = false;
				Player myTurn = whosturn();
				myTurn.getAvailablePieces().remove(selectedP);
				System.out.print("Valid move");
			}
			else{
				System.out.println("Invalid move");
				selectedP.follow(firstClick.getX(), firstClick.getY());
				repaint();
			}
		}
		firstClick = null;
		selectedP = null;
		selectedB = null;
		return false;
	}


	public Block getSelectedBlock() {
		// TODO Auto-generated method stub
		return this.selectedB;
	}

	public Piece getSelectedPiece() {
		// TODO Auto-generated method stub
		return this.selectedP;
	}

	public void nextTurn() {
		// TODO Auto-generated method stub
		this.GameTurn++;
	}





}
