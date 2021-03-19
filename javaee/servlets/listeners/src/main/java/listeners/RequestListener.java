package listeners;

import java.util.logging.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//Listens for servlet requests
@WebListener
public class RequestListener implements ServletRequestListener {
	
	private static final Logger LOGGER = Logger.getLogger(RequestListener.class.getName());

	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		LOGGER.info("Servlet request intialized");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		LOGGER.info("Servlet request destroyed");
	}
}
