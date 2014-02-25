package com.jtp;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Panel extends JPanel {
	Font HudFont = new Font("Verdana", Font.BOLD, 24);
	public void frame(){
		JFrame f = new JFrame();
		f.setSize(400,200);
		f.setResizable(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.add(this);
		f.setVisible(true);
	}
	public void paint(Graphics g){
	super.paint(g);
	Main m = new Main();
	try {
		m = new Main();	
		g.setFont(HudFont);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.WHITE);
		g.drawString("U" + m.inputtime[0], 9, 20);
		g.drawString("D" + m.inputtime[1], 109, 24);
		g.drawString("L" + m.inputtime[2], 209, 24);
		g.drawString("R" + m.inputtime[3], 309, 24);
	} catch (Exception e){}
	repaint();
	}
}
