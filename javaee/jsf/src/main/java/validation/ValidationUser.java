package validation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ValidationUser {
	
	private long age;
	
	public long getAge() {
		return age;
	}
	
	public void setAge(long age) {
		this.age = age;
	}
}
