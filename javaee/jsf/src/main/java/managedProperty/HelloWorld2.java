package managedProperty;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloWorld2 {
	
	private static Logger LOGGER = Logger.getLogger(HelloWorld2.class.getName());
	
	@Inject
	@ManagedProperty(value = "#{message}")
	private Message messageBean;
	private String message;
	
	public HelloWorld2() {
		LOGGER.info("HelloWorld2 Started");
	}
	
	public String getMessage() {
		if(messageBean !=null) {
			message = messageBean.getMessage();
		}
		return message;
	}
	
	public void setMessageBean(Message messageBean) {
		this.messageBean = messageBean;
	}
}
