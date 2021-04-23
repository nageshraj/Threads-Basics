package com.wolken.wolkenapp.byImplementingRunnable;

public class ThirteenTable1 implements Runnable {

	@Override
	public void run() {

		int number = 13;

		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());

		for (int i = 1; i <= 10; i++) {
			System.out.println(number + " * " + i + " = " + (number * i));
		}

		System.out.println("End of " + Thread.currentThread().getName());

	}

}
