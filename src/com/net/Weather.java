package com.net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Weather extends Thread {
	
	String weather = "节目预报：八点有大型晚会，请收听";
	int port = 9898;
	InetAddress iAddress = null;
	MulticastSocket socket = null;
	Weather() {
		try {
			iAddress = InetAddress.getByName("224.255.10.0");
			socket = new MulticastSocket(port);
			socket.setTimeToLive(1);
			socket.joinGroup(iAddress);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void run() {
		while (true) {
			DatagramPacket packet = null;
			byte data[] = weather.getBytes();
			packet = new DatagramPacket(data, data.length, iAddress,port);
			System.out.println(new String(data));
			try {
				socket.send(packet);
				sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("java.net.prefelPv4Stack", "true");
		Weather weather = new Weather();
		weather.start();
		
	}
}
