package testProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class testBoard extends JPanel implements ActionListener {
	private Timer timer;
	private final int DELAY = 10;
	private testSpaceShip spaceship;
	private List<testAlien> alienList;
	private List<testExplosion> explosionList =  new ArrayList<testExplosion>();
	private List<testExplosion> explosionsToRemove =  new ArrayList<testExplosion>();
	List<testShot> shotToRemove = new ArrayList<testShot>();
	private testExplosion explosion;
//	private testShot shot;
	private List<testShot> shotList = new ArrayList<>();
	private int killcount = 0;
	private int score = 0;
	private String message = "Game Over";
		
	public testBoard() {
		initializeBoard();
	}
	
	/**
	 * Create the aliens and add them to the list of aliens, create the player, 
	 * create a list for the fired shots, create a timer and let it start.
	 */
	
	private void initializeBoard() {
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		
		alienList = new ArrayList<>();
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				testAlien alien = new testAlien(100 * i, -100 * i);
				alien.setRandomX();
				alienList.add(alien);
			}
		}
		
		spaceship = new testSpaceShip();
		
		timer = new Timer(DELAY, this);
		timer.addActionListener(createMovementActionListener());
		timer.start();
	}

	private ActionListener createMovementActionListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				List<testAlien> aliensToRemove = new ArrayList<testAlien>();
				for (testAlien alien : alienList) {
					alien.y++;
					if (isHit(alien)) {
						System.out.println("Explosion");
						aliensToRemove.add(alien);
//						remove shot from shotlist && show explosion on x & y coordinates
						explosionList.add(new testExplosion(alien.randomX, alien.y));
					}
				}
				for (testShot shot : shotList) {
//					System.out.println("shot op positie: " + shot.x + " - " + shot.y);
					if (shot.y < 0) {
						shotToRemove.add(shot);
					}
					shot.y = shot.y - 4;
				}
				
				for (testExplosion explosion : explosionList) {
					explosion.countToRemoveFromDisplay--;
					if (explosion.countToRemoveFromDisplay <= 0) {
						explosionsToRemove.add(explosion);
					}
				}
				alienList.removeAll(aliensToRemove);
				explosionList.removeAll(explosionsToRemove);
				explosionsToRemove.clear();
				shotList.removeAll(shotToRemove);
				shotToRemove.clear();
			}
		};
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("src/Images/space-background.jpg").getImage(), 0,0, 1000, 1000,null);
	
//		Font f = g.getFont();
//	    g.setFont(new Font(f.getName(), Font.BOLD, 24));
//	    g.setColor(Color.CYAN);
//		g.drawString("Kills: " + killcount, 450, 20);
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	/**
	 * Draw the player, the aliens, and the shots that are fired.
	 */
	private void doDrawing(Graphics g) {
		drawSpaceship(g);
		drawAlien(g);
		drawShot(g);
		drawExplosion(g);
	}
	
	private void drawExplosion(Graphics g) {
		for (testExplosion expl :explosionList) {
			g.drawImage(expl.getImage(), expl.x - 35, expl.y - 40, 120, 120, this);
		}
	}

	private void drawSpaceship(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(),60,70, this);
	}
	
	private void drawAlien(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (testAlien alien : alienList) {
			g2d.drawImage(alien.getImage(), alien.randomX, alien.y, 45, 28, this);
		}
	}
	
	private void drawShot(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (testShot shot : shotList) {
			g2d.drawImage(shot.ImgIcon, shot.x, shot.y, 5, 15, this);
			g2d.drawImage(shot.ImgIcon, shot.x2, shot.y, 5, 15, this);
		}
	}

	/**
	 * Checks if an alien is hit.
	 */
	
	public boolean isHit(testAlien alien) {
		for (testShot shot : shotList) {
			//left cannon
			if (shot.x < alien.randomX + 30 && shot.x > alien.randomX - 30) {
//				x-axis
				if (shot.y < alien.y + 30 && shot.y > alien.y - 30) {
//					hit detected
					System.out.println("Hit detected");
					shotToRemove.add(shot);
					killcount++;
					score = score + 10;
					return true;
				}
			}
			//right cannon
			if (shot.x2 < alien.randomX + 30 && shot.x2 > alien.randomX - 30) {
//				x-axis
				if (shot.y < alien.y + 30 && shot.y > alien.y - 30) {
//					hit detected
					System.out.println("Hit detected");
					shotToRemove.add(shot);
					killcount++;
					score = score + 10;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * A shot is fired by the spaceship and added to the list of shots.
	 */
	private void fire() {
		testShot shot = new testShot();
		shot.x = spaceship.getX() + 5;
		shot.x2 = spaceship.getX() + 50;
		shot.y = spaceship.getY();;
		shotList.add(shot); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		step();
	}
	
	/**
	 * When the player moves, the background will cover up the trace of the spaceship.
	*/
	private void step() {
		spaceship.move();
		repaint();
	}
	
/**
 * The player presses the spacebar, a shot will be fired when the player releases the spacebar.
*/
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
