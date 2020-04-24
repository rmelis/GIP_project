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

import javax.swing.JPanel;
import javax.swing.Timer;

public class testBoard extends JPanel implements ActionListener {
	private testSpaceShip spaceship;
	private final int DELAY = 10;
	private Timer timer;
	private List<testBomb> bombList = new ArrayList<>();
	private List<testAlien> AlienList = new ArrayList<>();
	
	public testBoard() {
		setSize(1000, 1000);
		initializeBoard();
	}
	
	private void initializeBoard() {
		addKeyListener(new TAdapter());
		setBackground(Color.white);
		setFocusable(true);
		
		spaceship = new testSpaceShip();
		
		
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(), this);
		for (testBomb b : bombList) {
			if (b.y < 0) {
				bombList.remove(b);
			}
			g2d.drawImage(b.ImgIcon, b.x, b.y, this);
			b.y--;
		}
	}
	
	private void fire() {
		testBomb bomb = new testBomb();
		bomb.x = spaceship.getX();
		bomb.y = spaceship.getY();
		bombList.add(bomb); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		step();
	}
	
	private void step() {
		spaceship.move();
		repaint();
	}
	
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
