package listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// Triggered when servlet lifecycle changes
@WebListener
public class ContextListener implements ServletContextListener{
	
	private static final Logger LOGGER = Logger.getLogger(ContextListener.class.getName());

	//Happens before any servlets or filters are initialized
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOGGER.info("Context Listener initialized");
	}
	
	//Happens after all servlets and filters are destroyed
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOGGER.info("Context Listener Destroyed");
	}
}
