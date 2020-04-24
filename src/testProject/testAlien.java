package testProject;

import java.awt.Image;
import javax.swing.ImageIcon;

public class testAlien {
	private int x;
	private int y;
	private Image image;
	
	public testAlien(int x, int y) {

        loadImage(x, y);
    }

    private void loadImage(int x, int y) {
    	this.x = x;
    	this.y = y;
    	ImageIcon ImgIcon = new ImageIcon("src/Images/Tie fighter.png");
        image = ImgIcon.getImage();
    }
}
