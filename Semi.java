package TrafficSim;

import java.awt.Color;
import java.awt.Graphics;

public class Semi extends Vehicles{

	
	public Semi(int newx, int newy) {
		super(newx, newy); //super = Vehicles() in the Vehicles class
		width = 120;
		height = 50;
		speed = 5;
	}
	
	public void paintMethod(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		
		
	}
	
}
