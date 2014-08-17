package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Frame extends JFrame {

	private BufferStrategy strat;
	private BufferedImage bg;
	private Player player = new Player(50,50);
	private Displaybar bar = new Displaybar();
	private Keyboard key = new Keyboard();
	private Upgrades upgrades;
	private Settings settings;
	private int goldMultiplicator = 1;
	Menu menu;
	private Gold gold;
	public Graphics g;
	private Thread replaceGold;
	Thread Displaybar;
	
	public Frame() {
		super("Game");
		try {
			bg = ImageIO.read(getClass().getClassLoader().getResource("assets/bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		addKeyListener(key);
		addMouseListener(key);
		gold = new Gold();
		Displaybar = new Thread(new Displaybar());
		Displaybar.start();
	}
	
	public void makestrat(){
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}
	public void repaint() {
		g = strat.getDrawGraphics();
		clear(g);
		draw(g);
		//strat.dispose();
		strat.show();
	}
	public void draw(Graphics g) {
		g.drawImage(bg, 0, 25, null);
		player.draw(g);
		bar.draw(g);
		if(gold != null){gold.draw(g);}
		if(menu != null){menu.draw(g);}
		if(upgrades != null){upgrades.draw(g);}
		if(settings != null){settings.draw(g);}
	}
	public void update(float tslf) {
		if(menu != null){menuListener();}
		if(upgrades != null){upgradeListener();}
		if(settings != null){settingListener();}
		player.update(tslf);
		if(gold != null) {hitGold();}
		isMenu();
		key.resetPos();
	}
	public void settingListener() {
		if(key.mouseX > 275 && key.mouseX < 525 && key.mouseY > 425 && key.mouseY < 475) {settings = null;}
	}
	public void upgradeListener() {
		if(key.mouseX > 440 && key.mouseX < 485 && key.mouseY > 140 && key.mouseY < 160 && bar.goldAmount >= 50) {goldMultiplicator = 2;bar.goldAmount -= 50;}
		else if(key.mouseX > 275 && key.mouseX < 525 && key.mouseY > 425 && key.mouseY < 475) {upgrades = null;}
	}
	public void menuListener() {
		if(key.mouseX > 275 && key.mouseX < 525 && key.mouseY > 125 && key.mouseY < 175) {menu = null;}
		else if(key.mouseX > 275 && key.mouseX < 525 && key.mouseY > 225 && key.mouseY < 275) {menu = null; upgrades = new Upgrades();}
		else if(key.mouseX > 275 && key.mouseX < 525 && key.mouseY > 325 && key.mouseY < 375) {menu = null; settings = new Settings();}
		else if(key.mouseX > 275 && key.mouseX < 525 && key.mouseY > 425 && key.mouseY < 475) {System.exit(0);}
	}
	public void isMenu() {
		if(bar.isSettingsClicked(key.mouseX, key.mouseY)){
			 menu = new Menu();
		}
	}
	public void hitGold(){
		if((player.posx < gold.x + 50 && player.posx > gold.x)||(player.posx + 50 > gold.x && player.posx + 50 < gold.x + 50)) {
			if((player.posy < gold.y + 50 && player.posy > gold.y)||(player.posy + 50 > gold.y && player.posy + 50 < gold.y + 50)) {
				bar.goldAmount += goldMultiplicator;
				replaceGold = new Thread(){
					public void run(){
						try {
							gold = null;
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						gold = new Gold();
					}
				};
				replaceGold.start();
			}
		}
	}
	public void clear(Graphics g){
		g.clearRect(0, 0, 800, 625);
	}
}
