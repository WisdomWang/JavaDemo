package com.net;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class MyClien extends JFrame {
	private PrintWriter writer;
	Socket socket;
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	Container cc;
	public MyClien(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane();
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf,"South");
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				writer.println(tf.getText());
				ta.append(tf.getText()+'\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText("");
			}
		});
	}
  private void connect() {
	ta.append("尝试连接\n");
	try {
		socket = new Socket("127.0.0.1",8998);
		writer = new PrintWriter(socket.getOutputStream(),true);
		ta.append("完成连接\n");
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClien clien = new MyClien("向服务器送数据");
		clien.setSize(200,200);
		clien.setVisible(true);
		clien.connect();
	}

}
