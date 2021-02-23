package io.github.kalinchan.javasamples.javaee.cdiscopes;

import java.util.Random;

import javax.enterprise.context.RequestScoped;

@RequestScoped // The duration of this is a user's interaction with a web app in a single HTTP
				// request
//This class is a CDI Bean
public class MessageB implements Message {

	@Override
	public Integer get() {
		return (new Random().nextInt(100));
	}
}
