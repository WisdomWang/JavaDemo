package com.lzw;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class MyFrame extends JFrame {
	
	public static void main(String args[]) {
		new MyFrame();	
	}
	public MyFrame() {
		
		Container container = getContentPane();
		container.setLayout(null);
		JLabel jLabel = new JLabel("这是一个JFrame窗体");
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jLabel);
		JButton jButton = new JButton("弹出对话框");
		jButton.setBounds(10, 10, 100, 21);
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyJDialog(MyFrame.this).setVisible(true);
			}
		});
		container.add(jButton);
		this.setBounds(120, 120, 200, 200);;
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	class MyJDialog extends JDialog {
		public MyJDialog(MyFrame frame) {
			super(frame,"第一个MyJDialo窗体",true);
			Container container = getContentPane();
			container.add(new JLabel("这是一个对话框"));
			setBounds(120, 120, 100, 100);
		}	
	}
}

