package io.github.kalinchan.threads;

public class Main implements Runnable {// Defining and starting a thread

	@Override
	public void run() {
		System.out.println("Message from thread");
	}

	public static void main(String[] args) throws InterruptedException {
		(new Thread(new Main())).start();
		sleepExample();
	}

	// Subclass Thread implements Runnable, an application can subclass Thread
	// providing their own implementation of the run method

	// Execution can be paused with the sleep method
	public static void sleepExample() throws InterruptedException {
		String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy",
				"A kid will eat ivy too" };

		for (int i = 0; i < importantInfo.length; i++) {
			// Pause for 4 seconds
			Thread.sleep(4000);
			// Print a message
			System.out.println(importantInfo[i]);
		}
	}

	// An interrupt is an indication to a thread that it should stop what it is
	// doing and do something else
	// The interrupt mechanism is implemented using an internal flag known as the
	// interrupt status. Invoking Thread.interrupt sets this flag

	// The join method allows one thread to wait for the completion of another

}
