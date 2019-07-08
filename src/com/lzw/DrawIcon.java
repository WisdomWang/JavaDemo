package com.lzw;

import java.awt.*;
import javax.swing.*;

public class DrawIcon implements Icon {
	
	private int width;
	private int height;
	public int  getIconHeight() {
		return	this.height;
	}
	public int  getIconWidth() {
		return	this.width;
	}
	public DrawIcon(int width,int height) {
		
		this.width = width;
		this.height = height;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		g.fillOval(x, y, width, height);
	}
	public static void main(String args[]) {
		
		DrawIcon icon =new DrawIcon(15, 15);
		JLabel jLabel = new JLabel("测试",icon,SwingConstants.CENTER);
		JFrame jFrame = new JFrame("这是一个窗口");
		Container container= jFrame.getContentPane();
		container.add(jLabel);
		jFrame.setVisible(true);
		jFrame.setSize(200, 150);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
