package com.wolken.wolkenapp.Synchronization;

public class ThreadSynchronization {

	public static void main(String[] args) {
		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("Thread Priority: " + Thread.currentThread().getPriority());

		Table table = new Table();

		Thread1 t1 = new Thread1(table);
		Thread thread1 = new Thread(t1);
		System.out.println(thread1.getState());
		Thread2 thread2 = new Thread2(table);

		thread1.start();
		thread2.start();

		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
	}

}

class Thread1 implements Runnable {
	Table table;

	public Thread1(Table table) {
		this.table = table;
	}

	@Override
	public void run() {

		table.tableOf(11);
	}

}

class Thread2 extends Thread {
	Table table;

	public Thread2(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		table.tableOf(15);

	}
}

class Table {
	synchronized void tableOf(int tableOf) {
		for (int i = 0; i <= 10; i++) {
			System.out.println(tableOf + " * " + i + " = " + (tableOf * i));
		}
	}
}
