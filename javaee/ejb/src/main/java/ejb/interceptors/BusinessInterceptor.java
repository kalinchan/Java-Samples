package ejb.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

public class BusinessInterceptor {
	/*
	 * An interceptor method is called by ejbContainer before business method call it is intercepting.
	 */
	private static Logger LOGGER = Logger.getLogger(BusinessInterceptor.class.getName());
	
	@AroundInvoke
	public Object methodInterceptor(InvocationContext ctx) throws Exception {
		LOGGER.info("*** Intercepting call to LibraryBean method: " + ctx.getMethod().getName());
		return ctx.proceed();
	}
}
