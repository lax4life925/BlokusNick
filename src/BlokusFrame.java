import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;


public class BlokusFrame extends JFrame {
	int playerNum = 0;
	public static final int width = 1200;
	public static final int height = 800;

	public BlokusFrame(){
		super("Blokus");
		setLayout(new BorderLayout());
		createMenus();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(0,0,width,height);
		pack();
		addPanel();
		setResizable(false);
		
	}

	private void addPanel() {
		BlokusPanel bp = new BlokusPanel();
		this.add(bp);
		pack();
	}

	private void createMenus() {
		// TODO Auto-generated method stub
		
	}
	
}
