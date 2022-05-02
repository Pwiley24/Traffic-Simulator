package TrafficSim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sports extends Vehicles{
	
	//Haven't finished the edits for the image to work the way I want so I will submit it with just block images.
	//Image myImage;

	public Sports(int newx, int newy) {
		super(newx, newy);
		width = 70;
		height = 30;
		speed = 15;
		/*
		try{
			myImage = ImageIO.read(new File("sportscar.jpeg"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}*/
	}
	
	public void paintMethod(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
		//g.drawImage(myImage, x, y, null);
	}
	
}
