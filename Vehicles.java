package TrafficSim;

import java.awt.Graphics;

public class Vehicles {

	int x;
	int y;
	int width = 0;
	int height = 0;
	int speed = 0;
	
	public Vehicles(int newx, int newy) {
		x = newx;
		y = newy;
	}
	
	public void paintMethod(Graphics g) {
		
		
		
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int newx) {
		x = newx;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int newy) {
		y = newy;
	}
	
	public int getWidth() {
		return width;
	}
	
}
