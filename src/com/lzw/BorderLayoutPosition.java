package com.lzw;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BorderLayoutPosition extends JFrame {

	String[] borderStrings = {BorderLayout.CENTER,BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.WEST,BorderLayout.EAST};
	String[] buttonName = {"center button","north button","south button","west button","east button",};
	
	public BorderLayoutPosition() {
		// TODO Auto-generated constructor stub
		setTitle("这个窗体使用边界布局管理器");
		Container container = getContentPane();
		setLayout(new BorderLayout());
		for (int i = 0; i < borderStrings.length; i++) {
			container.add(borderStrings[i],new JButton(buttonName[i]));
		}
		setSize(350, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BorderLayoutPosition();

	}

}
