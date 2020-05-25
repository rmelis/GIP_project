package testProject;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

//Here we will set the starting, and current coordinates of the spaceship.
//The width, height & the "image" word will be used later for showing the spaceship.
public class testSpaceShip {
	private int x = 500;
    private int y = 900;
	private int dx;
    private int dy;
    private int width;
    private int height;
    private Image image;
    
    public testSpaceShip() {

        loadImage();
    }
    
    /**
     * The image that will be used to show the player's spaceship.
     */
    private void loadImage() {
        
        ImageIcon ImgIcon = new ImageIcon("src/Images/spaceship2.png");
        image = ImgIcon.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void move() {
        
        x = x + dx;
        y = y + dy;
    }

    public int getX() {
        
        return x;
    }
    
    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return width;
    }
    
    public int getHeight() {
        
        return height;
    }    
    public Image getImage() {
        
        return image;
    }
    
    /**
     * Move left and right by using the left and right arrow keys.
     */
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -3;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 3;
        }
    }
    
    /**
     * When the arrow key is released, the player will stop moving.
     */
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
