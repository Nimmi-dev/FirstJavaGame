package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	static Frame frame;
	
	public static void main(String[] args) {
		
		frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,625));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setBackground(Color.WHITE);
		frame.setVisible(true);
		
		frame.makestrat();
		
		long firstFrame = System.currentTimeMillis();
		while(true) {
			
			long thisFrame = System.currentTimeMillis();
			float timeSinceLastFrame = (float) ((thisFrame - firstFrame)/1000.0);
			firstFrame = thisFrame;
			
			frame.update(timeSinceLastFrame);
			frame.repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
