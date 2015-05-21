import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import javax.swing.event.MouseInputAdapter;


public class MyListener extends MouseInputAdapter implements ActionListener {
	BlokusPanel panel;
	boolean active = false;
	public MyListener(BlokusPanel bp){
		super();
		panel = bp;
		setUpKeyActions();
	}
	
	private void setUpKeyActions() {
		// TODO Auto-generated method stub
		Action flipH = new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubs
				System.out.println("flip H");
				
				if(active){
					panel.getSelectedPiece().flipHorizontally();
					panel.repaint();
				}
			}
			
		};
		Action flipV = new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("flip V");

				if(active){
					panel.getSelectedPiece().flipVertically();
					panel.repaint();
				}
			}
			
		};
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"flipH");
		panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "flipH");
		panel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "flipV");
		panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "flipV");

		panel.getActionMap().put("flipH", flipH);
		panel.getActionMap().put("flipH", flipV);

		
	}

	public void mousePressed(MouseEvent e){
		
		int x = e.getX();
		int y = e.getY();
		if(panel.insideUsablePiece(x,y))
			if(panel.firstClick==null){
				if(panel.selectPiece(x,y))
					active = true;
			}
			else if(panel.firstClick!=null){
				panel.dropPiece(x, y);
				active = false;
				panel.firstClick = null;
		}
	}
	
	public void mouseMoved(MouseEvent e){
		if(active){
			panel.getSelectedPiece().follow(e.getX(),e.getY());
			panel.repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
	
}
