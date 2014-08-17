package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Gold {

	int x = (int) (Math.random() * 750);
	int y = (int) (Math.random() * (550 - 25) + 25);
	private BufferedImage gold;
	
	public Gold() {
		try {
			gold = ImageIO.read(getClass().getClassLoader().getResource("assets/gold.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void draw(Graphics g){
		g.drawImage(gold, x, y, 50, 50, null);
	}
}
