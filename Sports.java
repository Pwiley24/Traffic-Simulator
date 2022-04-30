package TrafficSim;

import java.awt.Color;
import java.awt.Graphics;

public class Sports extends Vehicles{
	
	Image myImage;

	public Sports(int newx, int newy) {
		super(newx, newy);
		width = 70;
		height = 30;
		speed = 15;
		try{
			myImage = ImageIO.read(new File("sportscar.png");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void paintMethod(Graphics g) {
		/*g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);*/
		g.drawImage(myImage, x, y, null);
	}
	
}
