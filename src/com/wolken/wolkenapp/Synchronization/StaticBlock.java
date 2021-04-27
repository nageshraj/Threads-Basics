package com.wolken.wolkenapp.Synchronization;

public class StaticBlock {
	public static void main(String[] args) {

		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
		System.out.println();

		N1 n1 = new N1();
		N2 n2 = new N2();
		N3 n3 = new N3();
		N4 n4 = new N4();

		n1.start();
		n2.start();
		n3.start();
		n4.start();

	}

}

class N1 extends Thread {
	@Override
	public void run() {
		Addition.add(5);
	}
}

class N2 extends Thread {
	@Override
	public void run() {
		Addition.add(10);
	}
}

class N3 extends Thread {
	@Override
	public void run() {
		Addition.add(15);
	}
}

class N4 extends Thread {
	@Override
	public void run() {
		Addition.add(20);
	}
}

class Addition {
	synchronized static void add(int number) {

		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
		System.out.println();

		int temp = 0;
		for (int i = 0; i < 10; i++) {
			temp = temp + number;
			System.out.println("Number: " + temp);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
