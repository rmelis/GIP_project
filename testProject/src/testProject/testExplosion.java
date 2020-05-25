package testProject;

import java.awt.Image;
import javax.swing.ImageIcon;

public class testExplosion extends testSprite {
	public int x;
	public int y;
    Image ImgIcon = new ImageIcon("src/Images/1211112.gif").getImage();
    
    public testExplosion(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    
}
