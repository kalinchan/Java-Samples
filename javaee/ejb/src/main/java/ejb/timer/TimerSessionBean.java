package ejb.timer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

import org.jboss.logging.Logger;

@Stateless
public class TimerSessionBean implements TimerSessionBeanRemote {

	/*
	 * EJB Timer Service is a service provided by EJB container, which helps to
	 * create timer and to schedule callback when timer expires.
	 */
	private static Logger LOGGER = Logger.getLogger(TimerSessionBean.class.getName());

	@Resource
	private SessionContext context;

	public void createTimer(long duration) {
		context.getTimerService().createTimer(duration, "Hello World!");
	}

	@Timeout
	public void timeOutHandler(Timer timer) {
		LOGGER.info("timeoutHandler : " + timer.getInfo());
		timer.cancel();
	}
}
