package decorators;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import beans.CustomBean;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public class CustomBeanDecorator extends CustomBean{

	
	private static final Logger LOGGER = Logger.getLogger(CustomBeanDecorator.class.getName());
	
	@Inject
	@Delegate
	private CustomBean delegate;
	
	@Override
	public Integer getRandomInt() {
		final int result = delegate.getRandomInt();
		LOGGER.info(() -> String.format("Getting random integer. Result: %s", result));
		return result;
	}
}
