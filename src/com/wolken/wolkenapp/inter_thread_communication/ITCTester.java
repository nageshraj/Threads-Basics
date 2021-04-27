package com.wolken.wolkenapp.inter_thread_communication;

public class ITCTester {
	public static void main(String[] args) {

		Grocery grocery = new Grocery();

		Thread1 thread1 = new Thread1(grocery);
		Thread2 thread2 = new Thread2(grocery);
		thread1.start();
		thread2.start();

	}

}

class Thread2 extends Thread {
	Grocery grocery;

	public Thread2(Grocery grocery) {
		this.grocery = grocery;
	}

	@Override
	public void run() {
		grocery.waitForFiveAM();

	}

}

class Thread1 extends Thread {
	Grocery grocery;

	public Thread1(Grocery grocery) {
		this.grocery = grocery;
	}

	@Override
	public void run() {
		grocery.purchaseGrocery(4);
	}

}

class Grocery {
	int start = 5;
	int end = 10;
	int currentTime;

	synchronized void purchaseGrocery(int currentTime) {
		this.currentTime = currentTime;
		System.out.println("Going to purchase");
		if (this.currentTime < 5 || this.currentTime > 10) {
			System.out.println("Inside If");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Purchase done");

	}

	synchronized void waitForFiveAM() {
		System.out.println("Waiting for 6 AM");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		System.out.println("Current time is 6 AM");
		notify();
	}
}
