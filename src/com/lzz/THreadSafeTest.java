package com.lzz;

public class THreadSafeTest implements Runnable {

	int num = 20;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized ("") {
				if (num>0) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("tickets"+ --num);
				}
			}
		}

	}
	
	public static void main(String args[]) {
		THreadSafeTest t = new THreadSafeTest();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
