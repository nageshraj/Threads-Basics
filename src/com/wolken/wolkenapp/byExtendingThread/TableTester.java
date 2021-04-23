package com.wolken.wolkenapp.byExtendingThread;

import com.wolken.wolkenapp.byImplementingRunnable.ThirteenTable1;
import com.wolken.wolkenapp.byImplementingRunnable.ThirteenTable2;

public class TableTester {
	public static void main(String[] args) {

		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());

		TenTable1 table1 = new TenTable1();
		TenTable2 table2 = new TenTable2();

		ThirteenTable1 thirteenTable1 = new ThirteenTable1();
		ThirteenTable2 thirteenTable2 = new ThirteenTable2();

		Thread thread1 = new Thread(thirteenTable1);
		Thread thread2 = new Thread(thirteenTable2);

		table1.start();
		table2.start();

		thread1.start();
		thread2.start();

	}

}
