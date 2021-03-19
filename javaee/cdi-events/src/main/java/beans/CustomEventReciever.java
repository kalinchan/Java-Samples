package beans;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import events.CustomEvent;
import qualifiers.Admin;

@ApplicationScoped
public class CustomEventReciever {
	
	private static final Logger LOGGER = Logger.getLogger(CustomEventReciever.class.getName());
	
	private int eventsRecieved = 0;
	private int adminEventsRecieved = 0;
	
	public void observeNormalEvent(@Observes CustomEvent event) {
		LOGGER.info("Observed normal event: " + event.getValue());
		eventsRecieved++;
	}
	
	public void observeAdminEvent(@Observes @Admin CustomEvent event) {
		LOGGER.info("Observed admin event: " + event.getValue());
		adminEventsRecieved++;
	}
	
}
