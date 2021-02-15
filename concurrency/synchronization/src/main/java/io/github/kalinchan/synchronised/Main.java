package io.github.kalinchan.synchronised;

import java.util.ArrayList;
import java.util.List;

public class Main {

	// Synchronized methods enable a simple strategy for preventing thread
	// interference and memory consistency errors

	// If an object is visible to more than one thread, all read or writes to that
	// object's variables are done through synchronized methods
	
	private int c = 0;
	private String lastName = "";
	private int nameCount = 0;
	private List<String> nameList = new ArrayList<>();

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
    
    //Another way to create synchronized code is with synchronized statements 
    //synchronized statements must specify the object that provides the intrinsic lock:
    public void addName(String name) {
        synchronized(this) {
            lastName = name;
            nameCount++;
        }
        nameList.add(name);
    }
    
}
