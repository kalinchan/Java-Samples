package listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

//Watches servlets for when attribute are added, modified or deleted
@WebListener
public class AttributeListener implements ServletContextAttributeListener {

	private static final Logger LOGGER = Logger.getLogger(AttributeListener.class.getName());

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		LOGGER.info(() -> String.format("Attribute %s added with value %s", event.getName(), event.getValue()));
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		LOGGER.info(() -> String.format("Attribute %s replaced with value %s", event.getName(), event.getValue()));
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		LOGGER.info(() -> String.format("Attribute %s removed with value %s", event.getName(), event.getValue()));
	}
	
}
