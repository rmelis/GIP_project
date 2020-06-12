package testProject;

import java.util.Random;

import javax.swing.ImageIcon;

public class testExplosion extends testSprite {
	public int x;
	public int y;
	public int countToRemoveFromDisplay = 50;
	boolean big = false;
	Random random = new Random();
    ImageIcon[] iconarray = {new ImageIcon("src/Images/explosion.gif"), new ImageIcon("src/Images/explosion2.gif"), new ImageIcon("src/Images/Explosion3.gif")};
    public testExplosion(int x, int y) {
    	this.x = x;
    	this.y = y;
    	int nextInt = random.nextInt(iconarray.length);
    	System.out.println(nextInt);
    	image = iconarray[nextInt].getImage();
    	if (nextInt == 2) {
    		countToRemoveFromDisplay = 30;
    		big = true;
    	}
    }
    
}
