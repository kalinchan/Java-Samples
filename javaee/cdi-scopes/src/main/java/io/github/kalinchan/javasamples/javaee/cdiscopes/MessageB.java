package io.github.kalinchan.javasamples.javaee.cdiscopes;

import javax.enterprise.context.RequestScoped;

@RequestScoped // The duration of this is a user's interaction with a web app in a single HTTP
				// request
//This class is a CDI Bean
public class MessageB implements Message {

	@Override
	public String get() {
		return "message b";
	}
}
