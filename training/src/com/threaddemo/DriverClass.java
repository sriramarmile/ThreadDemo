package com.threaddemo;

import java.util.ArrayList;

public class DriverClass {

	public static void main(String[] args) {
		ResourceClass resourceInst = new ResourceClass(new ArrayList<Integer>(), 5);
		new Thread(new ProducerThread(resourceInst), "producer").start();
		new Thread(new ConsumerThread(resourceInst), "consumer").start();
	}

}
