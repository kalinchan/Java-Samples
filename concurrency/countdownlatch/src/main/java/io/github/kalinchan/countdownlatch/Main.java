package io.github.kalinchan.countdownlatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main implements Runnable {

	// We can use countdown latch to cause a thread to block until other threads
	// have completed a given task

	// Countdown latch has a counter field which you can decrement as we require,
	// which can then be used to block a calling thread until it's been counted down
	// to zero

	private List<String> outputScraper;
	private CountDownLatch countDownLatch;

	public Main(List<String> outputScraper, CountDownLatch countDownLatch) {
		this.outputScraper = outputScraper;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		outputScraper.add("Counted down");
		countDownLatch.countDown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(5);
	    List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
	    List<Thread> workers = Stream
	    	      .generate(() -> new Thread(new Main(outputScraper, countDownLatch)))
	    	      .limit(5)
	    	      .collect(Collectors.toList()); //Creates 5 workers and adds them to a list
	    workers.forEach(Thread::start); // starts each worker
	    countDownLatch.await(); // wait until all of the workers have ran
	    outputScraper.add("Latch released");
	    System.out.println(outputScraper);
	}
	//This is an example of blocking a parent thread until some child threads have finished.
}
