package ajax;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getWelcomeMessage() {
		return "Hello " + name;
	}
}
