package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Upgrades {

	Graphics2D g2d;
	
	private BufferedImage goldIcon;
	public int goldMultiplicator = 1;
	public boolean visible = false;
	
	public Upgrades(){
		
	}
	public void draw(Graphics g){
		//Window
		g2d = (Graphics2D) g;
		g.setColor(Color.decode("#cccccc"));
		g.fillRect(250, 100, 300, 400);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
		g2d.drawRect(250, 100, 300, 400);
		
		//Gold Multiplicator
			g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2d.drawRect(275, 125, 250, 50);
			try {
				goldIcon = ImageIO.read(getClass().getClassLoader().getResource("assets/gold.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g2d.drawImage(goldIcon, 280, 130, 40, 40, null);
			g2d.setFont(new Font("sans-serif", Font.BOLD, 17));
			if(goldMultiplicator < 32) {
				g2d.drawString("x" + goldMultiplicator * 2, 323, 155);
				g2d.drawRect(440, 140, 50, 20);
				g2d.drawImage(goldIcon, 473, 142, 15, 15, null);
				g2d.setFont(new Font("sans-serif", Font.BOLD, 15));
				g2d.drawString(Integer.toString(goldMultiplicator*50), 445, 155);
			}
			else {
				g2d.drawString("x32", 323, 155);
				g2d.drawRect(440, 140, 50, 20);
				g2d.drawImage(goldIcon, 468, 142, 15, 15, null);
				g2d.setFont(new Font("sans-serif", Font.BOLD, 15));
				g2d.drawString("----", 445, 155);
			}
		
		//Back to Game
		g2d.setColor(Color.decode("#555555"));
		g2d.fill(new RoundRectangle2D.Float(275, 425, 250, 50, 25, 25));
		g2d.setColor(Color.BLACK);
		g2d.draw(new RoundRectangle2D.Float(275, 425, 250, 50, 25, 25));
		g2d.drawString("Return to Game", 340, 455);
	}
}
