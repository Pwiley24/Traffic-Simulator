package TrafficSim;

import java.awt.Color;
import java.awt.Graphics;

public class Sports extends Vehicles{

	public Sports(int newx, int newy) {
		super(newx, newy);
		width = 70;
		height = 30;
		speed = 15;
	}
	
	public void paintMethod(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	
}
