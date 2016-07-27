package com.example;

import java.util.concurrent.locks.Lock;

public class ThreadDemo extends Thread {
	
	@Override
	public synchronized void run()
	{
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo tdem= new ThreadDemo();
		
		tdem.start();
		try {
			tdem.join(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done with execution of thread");

	}

}
