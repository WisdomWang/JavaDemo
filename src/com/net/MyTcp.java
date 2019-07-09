package com.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTcp {
	
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	void getserver() {
		
		try {
			server = new ServerSocket(8998);
			System.out.println("服务器套接字已经创建成功");
			while (true) {
				System.out.println("等待客户机的连接");
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
private void getClientMessage() {
	try {
		while (true) {
			System.out.println("客户机："+reader.readLine());
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	try {
		if (reader!=null) {
			reader.close();
		}
		if (socket!=null) {
			socket.close();
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTcp tcp = new MyTcp();
		tcp.getserver();
	}

}
