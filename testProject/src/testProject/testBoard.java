package testProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class testBoard extends JPanel implements ActionListener {
	private Timer timer;
	private final int DELAY = 10;
	private testSpaceShip spaceship;
	private List<testAlien> alienList;
	private List<testShot> shotList = new ArrayList<>();
	private int killcount = 0;
	private String explosionImg = "src/Images/Explosion.jpg";
	
//	Here we will set the size of the Board,
//	and call the method "initializeBoard()".
	public testBoard() {
		setSize(1000, 1000);
		initializeBoard();
	}
	
//	In this method, we will recieve key events, set the background color, and set the focusable state of the board.
//	We make a new spaceship, a new timer, and let it start.
	private void initializeBoard() {
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		
		alienList = new ArrayList<>();
		
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {
				testAlien alien = new testAlien(100 * j,
						1 + 100 * i);
				alienList.add(alien);
			}
		}
		
		spaceship = new testSpaceShip();
		shotList = new ArrayList<>();
		
		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
//	This method will make sure the spaceship and shots are visible on the screen.
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(), this);
		
		for (testShot shot : shotList) {
			if (shot.y < 0) {
				shotList.remove(shot);
			}
			g2d.drawImage(shot.ImgIcon, shot.x, shot.y, this);
			shot.y--;
		}
		
		for (testAlien alien : alienList) {
			g2d.drawImage(alien.getImage(), alien.getRandomX(), alien.y, this);
//			alien.x = alien.getRandomX();
            alien.y++;
		}
	}
	
//	In this method, a shothot is fired by the spaceship and added to the list of shots.
	private void fire() {
		testShot shot = new testShot();
		shot.x = spaceship.getX();
		shot.y = spaceship.getY();
		shotList.add(shot); 
	}
	
//	This method will call the "step()" function.
	@Override
	public void actionPerformed(ActionEvent e) {
		step();
	}
	
//	Here the function "move()" is called.
//	The background will show no trace of a spaceship moving around.
	private void step() {
		spaceship.move();
		repaint();
	}
	
//	If the spacebar is released, the spaceship will fire a bomb.
	private class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	        	fire();
	        }
			spaceship.keyReleased(e);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			spaceship.keyPressed(e);
		}
	}
}
