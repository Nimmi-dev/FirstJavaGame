package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

public class Menu{
	
	Graphics2D g2d;
	
	public Menu() {
		
	}
	public void draw(Graphics g){
		g2d = (Graphics2D) g;
		g.setColor(Color.decode("#cccccc"));
		g.fillRect(250, 100, 300, 400);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
		g2d.drawRect(250, 100, 300, 400);

		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.setColor(Color.decode("#555555"));
		menuButton(275,125,250,50, "Back to Game", 349, 155);
		g2d.setColor(Color.decode("#555555"));
		menuButton(275,225,250,50, "Upgrades", 364, 255);
		g2d.setColor(Color.decode("#555555"));
		menuButton(275,325,250,50, "Settings", 366, 355);
		g2d.setColor(Color.decode("#555555"));
		menuButton(275,425,250,50, "Exit Game", 362, 455);
	}
	public void menuButton(int x, int y, int width, int height, String txt, int txtX, int txtY) {
		g2d.fill(new RoundRectangle2D.Float(x, y, width, height, 25, 25));
		g2d.setColor(Color.BLACK);
		g2d.draw(new RoundRectangle2D.Float(x, y, width, height, 25, 25));
		g2d.setFont(new Font("sans-serif", Font.TRUETYPE_FONT, 18));
		g2d.drawString(txt, txtX, txtY);
	}
}
