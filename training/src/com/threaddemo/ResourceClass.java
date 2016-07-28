package com.threaddemo;

import java.util.List;

public class ResourceClass {
	List<Integer> resource;
	int size;
	public final Object LOCK1 = new Object();
	public final Object LOCK2 = new Object();

	public ResourceClass() {

	}

	public ResourceClass(List<Integer> resource, int size) {
		this.resource = resource;
		this.size = size;
	}

	public boolean isFull() {
		if (resource.size() == size)
			return true;
		return false;

	}

	public boolean isEmpty() {
		return resource.size() == 0;
	}

	public void listAdder(int element)

	{
		synchronized (this) {
			while (isFull()) {
				try {
					this.wait();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			resource.add(element);
			this.notifyAll();
		}

	}

	public int listRemover()

	{
		int ele;
		synchronized (this) {
			while (isEmpty()) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			ele = resource.remove(0);
			this.notifyAll();
		}

		return ele;
	}
}
