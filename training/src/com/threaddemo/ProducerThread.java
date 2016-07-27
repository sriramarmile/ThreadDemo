package com.threaddemo;

import java.util.Random;

public class ProducerThread implements Runnable {

	ResourceClass resourceInst;
	Random random;
	int randomInt;

	ProducerThread(ResourceClass resource) {
		this.resourceInst = resource;
		random = new Random();
	}

	int generteData() {
		randomInt = random.nextInt() % 10;
		randomInt = 0;
		// sleep for some random time(say time to generate)
		try {
			Thread.sleep(Math.abs(randomInt * 1000));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		randomInt = random.nextInt() % 1000;
		return randomInt;

	}

	@Override
	public void run() {

		int generatedData;
		for (int iteration = 0; iteration < 10; iteration++) {

			generatedData = generteData();
			System.out.println("Producer turn: " + generatedData);
			resourceInst.listAdder(generatedData);
		}
	}

}
