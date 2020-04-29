package testProject;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

//Here we will set coordinates for the bomb.
//The "image" word will be used later for showing the alien ship.
public class testAlien {
	public int x;
	public int y;
	private Image image;
	
//  Here we call the method that will load the image of the alien ship.
	public testAlien(int x, int y) {

        loadImage(x, y);
    }
	
//	This method will set the coordinates and from here we'll the image used for the alien ship.
    private void loadImage(int x, int y) {
    	this.x = x;
    	this.y = y;
    	ImageIcon ImgIcon = new ImageIcon("src/Images/Tie fighter.png");
        image = ImgIcon.getImage();
    }
    
    public int getX() {
    	
    	return x;
    }
    
    int min = 1;
    int max = 1000;
    public int getRandomX() {
    	Random r = new Random();
    	int randomX = r.nextInt();
    	return randomX;
    }
    
    public int getY() {
        
        return y;
    }
    
    public Image getImage() {
        
        return image;
    }
}
