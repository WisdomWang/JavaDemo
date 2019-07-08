package com.lzw;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.sun.java.swing.plaf.windows.resources.windows;

public class FlowLayoutPosition extends JFrame {
	
	public FlowLayoutPosition() {
		
		setTitle("本窗体使用流布局管理器");
		Container container = getContentPane();
		setLayout(new FlowLayout(2,10,10));
		for (int i = 0; i < 10; i++) {
			container.add(new JButton("button+i"));
		}
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	}
	
	public static void main(String args[]) {
		new FlowLayoutPosition();
	}

}
