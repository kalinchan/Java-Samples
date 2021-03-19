package events;

import java.io.Serializable;

public final class CustomEvent  implements Serializable{

	private static final long serialVersionUID = 1L;

	private final int value;
	 
	public CustomEvent(int value) {
		this.value =value;
	}
	
	public int getValue() {
		return value;
	}
}
