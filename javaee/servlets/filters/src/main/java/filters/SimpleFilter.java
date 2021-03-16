package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleFilter implements Filter {

	//Intercept HTTP requests
	//Must implement Filter and configure in web.xml
	@Override
	public void init(FilterConfig filterConfig) throws ServletException { //called when first loaded
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) //Interception method
			throws IOException, ServletException {
		String param = request.getParameter("param");
		
		if("block".equals(param)) {
			chain.doFilter(request, response); //Request forwarded
		}else {
			
			response.getWriter().write("Request Denied");
		}
	}

	@Override
	public void destroy() {
	}
}
