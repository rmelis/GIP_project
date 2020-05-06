package testProject;

import java.awt.Image;
import java.util.Random;

public class testSprite {
	private boolean visible;
	private Image image;
	private boolean dying;
	int x;
	int y;
	int dx;
	
	int randomX;
	int min = 1;
    int max = 1000;
	
	public testSprite() {
		visible = true;
	}
	
	public void die() {
		visible = false;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	protected void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setRandomX(int randomX) {
		Random r = new Random();
    	randomX = r.nextInt((max - min) + min);
		this.randomX = randomX;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getRandomX() {
		
    	return randomX;
    }
	
	public void setDying(boolean dying) {
		this.dying = dying;
	}
	
	public boolean isDying() {
		return this.dying;
	}
}
