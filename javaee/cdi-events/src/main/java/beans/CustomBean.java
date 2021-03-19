package beans;

import java.util.Random;

import javax.annotation.PostConstruct;

public abstract class CustomBean {
	
	private static final Random RANDOM = new Random();
	
	private Integer randomInt;
	
	@PostConstruct
	public void configure() {
		randomInt = RANDOM.nextInt(100);
	}
	
	public Integer getRandomInt() {
		return randomInt;
	}
	
	public void setRandomInt(Integer randomInt) {
		this.randomInt = randomInt;
	}
}
