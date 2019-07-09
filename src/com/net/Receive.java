package com.net;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Receive extends JFrame implements Runnable, ActionListener {
	
	int port;
	InetAddress group = null;
	MulticastSocket socket = null;
	JButton ince = new JButton("开始接收");
	JButton stop = new JButton("停止接收");
	JTextArea inceAr = new JTextArea(10,10);
	JTextArea inced = new JTextArea(10,10);
	Thread thread;
	boolean b = false;
	
	public Receive() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("广播数据报");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		thread = new Thread(this);
		ince.addActionListener(this);
		stop.addActionListener(this);
		inceAr.setForeground(Color.blue);
		JPanel north = new JPanel();
		north.add(ince);
		north.add(stop);
		add(north,BorderLayout.NORTH);
		JPanel center = new JPanel();
		center.add(inceAr);
		center.add(inced);
		add(center,BorderLayout.CENTER);
		validate();
		port = 9898;
		try {
			group = InetAddress.getByName("224.255.10.0");
			socket = new MulticastSocket(port);
			socket.joinGroup(group);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setBounds(100,50,360,380);
		setVisible(true);
		
	}

//	public Receive(GraphicsConfiguration gc) {
//		super(gc);
//		// TODO Auto-generated constructor stub
//	}
//
//	public Receive(String title) throws HeadlessException {
//		super(title);
//		// TODO Auto-generated constructor stub
//	}
//
//	public Receive(String title, GraphicsConfiguration gc) {
//		super(title, gc);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == ince) {
			ince.setBackground(Color.red);
			stop.setBackground(Color.yellow);
			if (!(thread.isAlive())) {
				thread = new Thread(this);
			}
			thread.start();
			b = false;
		}
		if (e.getSource() == stop) {
			ince.setBackground(Color.yellow);
			stop.setBackground(Color.red);
			b = true;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			byte data[] = new byte[1024];
			DatagramPacket packet = null;
			packet = new DatagramPacket(data,data.length, group, port);
			try {
				socket.receive(packet);
				String message = new String(packet.getData(),0,packet.getLength());
				inceAr.setText("正在接收的内容：\n"+message);
				inced.append(message+"\n");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (b == true) {
				break;
			}	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Receive rec = new Receive();
		rec.setSize(460, 200);

	}

}
