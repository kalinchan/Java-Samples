package listeners;

import java.util.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//Listens for session creation and destruction
@WebListener
public class SessionListener implements HttpSessionListener {
	
	private static final Logger LOGGER = Logger.getLogger(SessionListener.class.getName());

	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		LOGGER.info("Session Created ");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		LOGGER.info("Session Destroyed");
	}
}
