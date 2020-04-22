package testProject;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

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

    private void loadImage() {
        
        ImageIcon ImgIcon = new ImageIcon("src/Images/X-wing.png");
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

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
        
    }

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
