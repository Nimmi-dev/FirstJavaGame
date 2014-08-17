package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Keyboard implements KeyListener, MouseListener {

	static boolean keys[] = new boolean[1000];
	int mouseX;
	int mouseY;
	
	public Keyboard() {
		
	}
	public void resetPos() {
		mouseX = 0;
		mouseY = 0;
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
	}
	public static boolean isKeyPressed(int keyCode){
		return keys[keyCode];
	}
	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
