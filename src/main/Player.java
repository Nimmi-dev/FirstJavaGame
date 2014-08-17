package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {

	float posx;
	float posy;
	int speedx;
	int speedy;
	int boost;
	BufferedImage pl;
	
	public Player(int posx, int posy){
		this.posx = posx;
		this.posy = posy;
		
		try {
			pl = ImageIO.read(getClass().getClassLoader().getResource("assets/pl.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics g) {
		g.drawImage(pl, (int)posx, (int)posy, null);
	}
	public void update(float tslf){
		speedx = 0;
		speedy = 0;
		boost = 1;
		if(Keyboard.isKeyPressed(KeyEvent.VK_SPACE) && Displaybar.energie > 0) {boost = 2;}
		if(Keyboard.isKeyPressed(KeyEvent.VK_W)) {speedy = -200 * boost;}
		if(Keyboard.isKeyPressed(KeyEvent.VK_S)) {speedy = 200 * boost;}
		if(Keyboard.isKeyPressed(KeyEvent.VK_A)) {speedx = -200 * boost;}
		if(Keyboard.isKeyPressed(KeyEvent.VK_D)) {speedx = 200 * boost;}
		posx += speedx * tslf;
		posy += speedy * tslf;
		if(posx < 0) {posx = 0;}
		if(posx > 750) {posx = 750;}
		if(posy < 25) {posy = 25;}
		if(posy > 575) {posy = 575;}
	}
}
