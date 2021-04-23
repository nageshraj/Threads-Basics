package com.wolken.wolkenapp.byExtendingThread;

public class TenTable2 extends Thread {

	@Override
	public void run() {

		int number = 10;

		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());

		for (int i = 10; i <= 20; i++) {
			System.out.println(number + " * " + i + " = " + (number * i));
		}

		System.out.println("End of " + Thread.currentThread().getName());

	}

}
