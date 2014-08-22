package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Displaybar implements Runnable{

	static float energie = 100;
	static float health = 100;
	int goldAmount = 0;
	private Graphics2D g2d;
	private BufferedImage goldIcon;
	private BufferedImage settingsIcon;
	 
	public Displaybar() {

	}
	public void draw(Graphics g){
		g2d = (Graphics2D) g;
		g.setColor(Color.decode("#555555"));
		g.fillRect(0, 0, 800, 25);
		g.setColor(Color.BLACK);
		g.drawLine(0, 24, 800, 24);
		
		//Gold Bar
		try {
			goldIcon = ImageIO.read(getClass().getClassLoader().getResource("assets/gold.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(goldIcon, 13, 3, 19, 19, null);
		g.setFont(new Font("sans-serif", Font.BOLD, 18));
		g.drawString(Integer.toString(goldAmount), 35, 19);
		
		//Health Bar
		g.setColor(Color.decode("#cccccc"));
		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
		g2d.drawRect(498, 4, 103, 17);
		g.setColor(Color.RED);
		g.fillRect(500, 5, (int)health, 15);
		g.fillRect(499, 5, 1, 15);
		g.setColor(Color.BLACK);
		g.setFont(new Font("sans-serif", Font.BOLD, 15));
		g.drawString("/100", 547, 18);
		if(health == 100) {g.drawString(new String(Integer.toString(((int)health))), 522, 18);}
		else if(health < 100 && health >= 10) {g.drawString(new String(Integer.toString(((int)health))), 530, 18);}
		else if(health < 10) {g.drawString(new String(Integer.toString(((int)health))), 538, 18);}
		
		//Energie Bar
		g.setColor(Color.decode("#cccccc"));
		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
		g2d.drawRect(648, 4, 103, 17);
		g.setColor(Color.YELLOW);
		g.fillRect(650, 5, (int)energie, 15);
		g.fillRect(649, 5, 1, 15);
		g.setColor(Color.BLACK);
		g.setFont(new Font("sans-serif", Font.BOLD, 15));
		g.drawString("/100", 697, 18);
		if(energie == 100) {g.drawString(new String(Integer.toString(((int)energie))), 672, 18);}
		else if(energie < 100 && energie >= 10) {g.drawString(new String(Integer.toString(((int)energie))), 680, 18);}
		else if(energie < 10) {g.drawString(new String(Integer.toString(((int)energie))), 688, 18);}
		
		//Settings 
		try {
			settingsIcon = ImageIO.read(getClass().getClassLoader().getResource("assets/settings.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(settingsIcon, 765, 3, 19, 19, null);
		
	}
	public void addGold() {
		System.out.println("One Gold added!");
	}
	public boolean isSettingsClicked(int mouseX, int mouseY){
		if(mouseX > 765 && mouseX < 784 && mouseY > 3 && mouseY < 21) {
			return true;
		}
		else {return false;}
	}
	
	@Override
	public void run() {
		while(true){
			if(Keyboard.isKeyPressed(KeyEvent.VK_SPACE)){if(energie > 0){energie -= 1;}}
			if(energie < 100 &&  Keyboard.isKeyPressed(KeyEvent.VK_SPACE) == false){energie += 0.25;}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
