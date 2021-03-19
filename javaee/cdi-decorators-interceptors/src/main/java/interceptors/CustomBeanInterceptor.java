package interceptors;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@CustomInterceptorBinding
@Priority(Interceptor.Priority.APPLICATION)
public class CustomBeanInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(CustomBeanInterceptor.class.getName());

	@AroundInvoke
	public Object logMethodEntry(InvocationContext invocationContext) throws Exception{
		final Object result = invocationContext.proceed();
		LOGGER.info(() -> String.format("Invoking custom bean method %s. Result : %s",
				invocationContext.getMethod().getName(), result));
		return result;
	}
	
	@AroundConstruct
	public Object logBeanCreation(InvocationContext invocationContext) throws Exception{
		final Object result = invocationContext.proceed();
		LOGGER.info(() -> String.format("Custom bean constructed %s", result));
		return result;
	}

}
