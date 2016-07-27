package com.threaddemo;

import java.util.Random;

public class ConsumerThread implements Runnable {

	ResourceClass resourceInst;
	Random random;
	int randomInt;

	ConsumerThread(ResourceClass resource) {
		this.resourceInst = resource;
		random = new Random();
	}

	void consumeData() {
		randomInt = random.nextInt() % 10;
		randomInt = 0;
		// sleep for some random time(say time to generate)
		try {
			Thread.sleep(Math.abs(randomInt * 1000));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void run() {
		for (int iteration = 0; iteration < 10; iteration++) {

			consumeData();
			System.out.println("Consumer turn: " + resourceInst.listRemover());
		}

	}

}
