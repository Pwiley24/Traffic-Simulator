package TrafficSim;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TrafficCode implements ActionListener, Runnable {

	JFrame frame = new JFrame("Traffic Simulation");
	
	Container left = new Container();
	JButton semiBtn = new JButton("Semi");
	JButton sportsBtn = new JButton("Sports Car");
	JButton suvBtn = new JButton("SUV");
	
	Container south = new Container();
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	Road road = new Road();
	
	boolean running = false;
	
	public TrafficCode() {
		//Layout for the Frame:
		frame.setSize(800, 600);
		frame.setLayout(new BorderLayout());
		frame.add(road, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		//Layout for button panel
		south.setLayout(new GridLayout(1,2));
		south.add(start);
		start.addActionListener(this);
		south.add(stop);
		stop.addActionListener(this);
		frame.add(south, BorderLayout.SOUTH);
		
		left.setLayout(new GridLayout(3, 1));
		left.add(semiBtn);
		semiBtn.addActionListener(this);
		left.add(sportsBtn);
		sportsBtn.addActionListener(this);
		left.add(suvBtn);
		suvBtn.addActionListener(this);
		frame.add(left, BorderLayout.LINE_START);
	
		
		
	}
	
	public static void main(String[] args) {
		new TrafficCode();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(start)) {
			if(running == false) {
				running = true;
				Thread t = new Thread(this);
				t.start();
			}
		
		}else if (event.getSource().equals(stop)) {
			running = false;
		}else if(event.getSource().equals(semiBtn)) {//if semi is added
			Semi semi = new Semi(0, 40);
			road.addCar(semi);
			for(int x = 0; x < road.ROAD_WIDTH; x = x + 20) { //add a semi to one of the lanes for x
				for(int y = 40; y < 600; y = y + road.LANE_HEIGHT) {//add a semi to one of the lanes for y
					semi.setX(x);
					semi.setY(y);
					if(road.collision(x, y, semi.getWidth(), semi) == false) {
						frame.repaint();
						return;
					}
				}
			}
		}else if(event.getSource().equals(suvBtn)) {//if suv is added
			SUV suv = new SUV(0, 40);
			road.addCar(suv);
			for(int x = 0; x < road.ROAD_WIDTH; x = x + 20) { //add a suv to one of the lanes for x
				for(int y = 40; y < 600; y = y + road.LANE_HEIGHT) {//add a suv to one of the lanes for y
					suv.setX(x);
					suv.setY(y);
					if(road.collision(x, y, suv.getWidth(), suv) == false) {
						frame.repaint();
						return;
					}
				}
			}
		}else if(event.getSource().equals(sportsBtn)) {//if sport is added
			Sports sports = new Sports(0, 40);
			road.addCar(sports);
			for(int x = 0; x < road.ROAD_WIDTH; x = x + 20) { //add a sport to one of the lanes for x
				for(int y = 40; y < 600; y = y + road.LANE_HEIGHT) {//add a sport to one of the lanes for y
					sports.setX(x);
					sports.setY(y);
					if(road.collision(x, y, sports.getWidth(), sports) == false) {
						frame.repaint();
						return;
					}
				}
			}
		}
			
		
	}

	@Override
	public void run() {
		while(running == true) {
			road.step();
			frame.repaint();
			try {
				Thread.sleep(100);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	

}
