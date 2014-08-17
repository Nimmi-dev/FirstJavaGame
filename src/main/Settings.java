package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

public class Settings {

	Graphics2D g2d;
	
	public Settings(){
		
	}
	public void draw(Graphics g){
		g2d = (Graphics2D) g;
		g.setColor(Color.decode("#cccccc"));
		g.fillRect(250, 100, 300, 400);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
		g2d.drawRect(250, 100, 300, 400);
		
		g2d.setColor(Color.decode("#555555"));
		g2d.fill(new RoundRectangle2D.Float(275, 425, 250, 50, 25, 25));
		g2d.setColor(Color.BLACK);
		g2d.draw(new RoundRectangle2D.Float(275, 425, 250, 50, 25, 25));
		g2d.setFont(new Font("sans-serif", Font.TRUETYPE_FONT, 18));
		g2d.drawString("Return to Game", 362, 455);
	}
}
