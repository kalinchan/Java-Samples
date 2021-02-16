package io.github.kalinchan.semaphores;

import java.util.concurrent.Semaphore;

public class Main {
	private Semaphore semaphore;

	// Semaphores can be used to limit the number of concurrent threads accessing a
	// specific resource
	public Main(int slotLimit) {
		semaphore = new Semaphore(slotLimit);
	}

	boolean tryLogin() {
		return semaphore.tryAcquire(); // returns true if a permit is available immediately and acquire it otherwise
										// return false
	}

	void logout() {
		semaphore.release(); // release a permit 
	}

	int availableSlots() {
		return semaphore.availablePermits(); // returns number of currently available permits
	}

}
