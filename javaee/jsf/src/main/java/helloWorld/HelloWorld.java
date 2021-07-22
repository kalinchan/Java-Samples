package helloWorld;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloWorld {
	
	/*
	 * Uses CDI as @MangedBean is deprecated
	 */
	
	private static Logger LOGGER = Logger.getLogger(HelloWorld.class.getName());
	
	public HelloWorld() {
		LOGGER.info("HelloWorld Started");
	}
	
	public String getMessage() {
		return "Hello World";
	}
}
