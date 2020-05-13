package testProject;

import javax.swing.ImageIcon;

//Here we will set coordinates for the bomb.
//The "image" word will be used later for showing the alien ship.
public class testAlien extends testSprite {
	public int x;
	public int y;
	
//  Here we call the method that will load the image of the alien ship.
	public testAlien(int x, int y) {

        loadImage(x, y);
    }
	
//	This method will set the coordinates and from here we'll the image used for the alien.
    private void loadImage(int x, int y) {
    	this.x = x;
    	this.y = y;
    	ImageIcon ImgIcon = new ImageIcon("src/Images/Tie fighter.png");
        image = ImgIcon.getImage();
    }
}
