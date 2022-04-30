package TrafficSim;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/*
 * List of all vehicles on the road
 * Paint component/graphics of vehicles
 */
public class Road extends JPanel{

	final int LANE_HEIGHT = 145;
	final int ROAD_WIDTH = 800;
	ArrayList<Vehicles> cars = new ArrayList<Vehicles>();
	int carCount = 0;
	
	public Road() {
		super();
	}
	
	
	public void addCar(Vehicles v) {
		cars.add(v);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Draw asphalt 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//Draw lane lines
		g.setColor(Color.WHITE);
		for(int i = LANE_HEIGHT; i < LANE_HEIGHT * 4; i = i + LANE_HEIGHT) { //the lane being drawn
			for(int j = 0; j < getWidth(); j = j + 75) {//the line being drawn
				g.fillRect(j, i, 30, 5);
			}
		}
		
		//Draw Cars
		for(int i = 0; i < cars.size(); i++) {
			cars.get(i).paintMethod(g);
		}
		
	}
	
	//method to move vehicles 
	public void step() {
			for(int i = 0; i < cars.size(); i++) {
				Vehicles v = cars.get(i);
				if(collision(v.getX()+v.getSpeed(),v.getY(), v) == false){//if the car won't collide with something continue straight
					v.setX(v.getX() + v.getSpeed());
					if(v.getX() > ROAD_WIDTH) {
						if(collision(0, v.getY(), v) == false){ //if it won't collide when it wraps around
							v.setX(-10);
							carCount++;
						}
					}
				}else{ //colliding with car if you continue
					if((v.getY() > 40) && 
						(collision(v.getX(), v.getY()-LANE_HEIGHT, v) == false)){ //check to see if can move to left lane
						v.setY(v.getY() - LANE_HEIGHT);
					}
					else if((v.getY() < 40 + 3*LANE_HEIGHT) && 
						(collision(v.getX(), v.getY()+LANE_HEIGHT, v) == false)){ //check to see if can move to right lane
						v.setY(v.getY() + LANE_HEIGHT);
					}
					
						
			}
		}
	
	public boolean collision(int x, int y, Vehicles v) {
		for(int i = 0; i < cars.size(); i++) {
			Vehicles u = cars.get(i);
			if(y == u.getY()) {// if in the same lane
				if(u.equals(v) == false) {//if not checking self
					if(x < u.getX() + u.getWidth() && //cars left side is to the left of the other cars right side
							x + v.getWidth() > u.getX()) {//cars right side is to the right of the other cars left side
						return true;
					}
				}
			}
		}
		return false;
	}
		
	public int getCarCount(){
		return carCount;
	}
	
		
	public void resetCarCount(){
		carCount = 0;
	}
	
}
