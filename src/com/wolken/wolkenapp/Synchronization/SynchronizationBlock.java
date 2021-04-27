package com.wolken.wolkenapp.Synchronization;

public class SynchronizationBlock {
	public static void main(String[] args) {
		Multiple multiple = new Multiple();

		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
		System.out.println();

		T1 t1 = new T1(multiple);
		T2 t2 = new T2(multiple);

		t1.start();
		t2.start();

	}

}

class T1 extends Thread {

	Multiple multiple;

	public T1(Multiple multiple) {
		this.multiple = multiple;
	}

	@Override
	public void run() {
		multiple.tableOf(20);
	}
}

class T2 extends Thread {

	Multiple multiple;

	public T2(Multiple multiple) {
		this.multiple = multiple;
	}

	@Override
	public void run() {
		multiple.tableOf(10);
	}
}

class Multiple {

	void tableOf(int tableOf) {

		synchronized (this) {

			System.out.println("Thread name: " + Thread.currentThread().getName());
			System.out.println("Thread ID: " + Thread.currentThread().getId());
			System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
			System.out.println();

			for (int i = 0; i <= 10; i++) {
				System.out.println(tableOf + " * " + i + " = " + (tableOf * i));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}