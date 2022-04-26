package TrafficSim;

import java.awt.Color;
import java.awt.Graphics;

public class SUV extends Vehicles{
	
	public SUV(int newx, int newy) {
		super(newx, newy);
		width = 85;
		height = 35;
		speed = 8;
	}
	
	public void paintMethod(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

}
