package io.github.kalinchan.javasamples.javaee.cdiscopes;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class ExampleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/*
	 * private Message message;
	 * 
	 * @Override public void init() { message = new MessageB(); }
	 * 
	 * Without CDI you would have to do this in order to get an instance of Message
	 * 
	 */

	@Inject
	private TestBean bean;

	/*
	 * private TestBean bean =
	 * javax.enterprise.inject.spi.CDI.current().select(TestBean.class).get(); You
	 * can Inject a bean programatically by doing the above.
	 */
	/*
	 * With CDI you can use the @Inject annotation to inject an instance of Message
	 * at runtime The CDI runtime looks for classes that implement the Message
	 * interface, finds the MessageB class creates a new instance of it and injects
	 * it into the servlet at runtime To manage the lifecycle of the new instance,
	 * the CDI runtime needs to know what the scope of the instance should be
	 * 
	 */

	/*
	 * @RequestScoped - A user's interaction with a web application in a single HTTP
	 * request.
	 * 
	 * @SessionScoped - A user's interaction with a web application across multiple
	 * HTTP requests.
	 * 
	 * @ApplicationScoped - Shared state across all users' interactions with a web
	 * application.
	 * 
	 * @Dependent - The default scope if none is specified; it means that an object
	 * exists to serve exactly one client (bean) and has the same lifecycle as that
	 * client (bean).
	 * 
	 * @ConversationScoped - A user's interaction with a servlet, including
	 * JavaServer Faces applications. The conversation scope exists within
	 * developer-controlled boundaries that extend it across multiple requests for
	 * long-running conversations. All long-running conversations are scoped to a
	 * particular HTTP servlet session and may not cross session boundaries.
	 * 
	 * @SessionScoped and @ConversationScoped are both passivating. Passivation is
	 * the act of moving an idle object that is held in memory auxiliary storage.
	 */

	/*
	 * A bean is passivation-capable if it is either a stateful session bean or any
	 * other managed bean that is both serializable and has no non-serializable
	 * interceptors and decorators.
	 * 
	 */

	/*
	 * bean-discovery-mode="ALL" turns on scanning of all classes in an archive.
	 * This is called an "explicit archive".
	 * 
	 * bean-discovery-mode="ANNOTATED", makes the archive an implicit archive. In
	 * this case, the container will scan for beans with annotated scope types.
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getOutputStream().println(bean.getValue());
	}
}
