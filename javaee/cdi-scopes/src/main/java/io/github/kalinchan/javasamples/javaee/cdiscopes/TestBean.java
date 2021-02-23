package io.github.kalinchan.javasamples.javaee.cdiscopes;

import java.util.Random;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TestBean {
	private final int value = new Random().nextInt(100);
	
	public int getValue() {
		return value;
	}
}
