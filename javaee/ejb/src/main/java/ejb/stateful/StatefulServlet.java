package ejb.stateful;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatefulServlet
 */
@WebServlet("/StatefulServlet")
public class StatefulServlet extends HttpServlet {
	
	/*-
	 * Preserves conversational state with client
	 * Keeps associated client state in its instance variables
	 * EJB container creates a separate stateful session bean 
	 * to process client's each request
	 * Session bean is destroyed as soon as request scope is over
	 */
	
	/*-
	 * Create a stateful EJB
	 * 
	 * -Create a remote/local interface exposing the business methods.
	 * -This interface will be used by the EJB client application.
	 * -Use @Local annotation if EJB client is in same environment 
	 * where EJB session bean need to be deployed.
	 * -Use @Remote annotation if EJB client is in different environment 
	 * where EJB session bean need to be deployed.
	 * -Create a stateful session bean, implementing the above interface.
	 * -Use @Stateful annotation to signify it a stateful bean. EJB Container 
	 * automatically creates the relevant configurations or interfaces required 
	 * by reading this annotation during deployment.
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
       
	private InitialContext initalContext;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try {
			initalContext = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryStatefulSessionBeanRemote libraryBean = null;
		try {
			libraryBean = (LibraryStatefulSessionBeanRemote) initalContext.lookup(LibraryStatefulSessionBeanRemote.class.getName());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (libraryBean == null) {
			resp.getWriter().print("Library Bean not initialized!");
			return;
		}
		if (req.getParameter("bookName") == null) {
			resp.getWriter().print(getEnteredBooks(libraryBean));
			return;
		}
		libraryBean.addBook(req.getParameter("bookName"));
		resp.getWriter().print(getEnteredBooks(libraryBean));

	}

	private String getEnteredBooks(LibraryStatefulSessionBeanRemote libraryBean) {

		List<String> booksList = libraryBean.getBooks();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Book(s) entered so far: " + booksList.size());
		int i = 0;
		for (String book : booksList) {
			stringBuilder.append("<br>" + (i + 1) + ". " + book);
			i++;
		}
		LibraryStatefulSessionBeanRemote libraryBean1 = null;
		try {
			libraryBean1 = (LibraryStatefulSessionBeanRemote) initalContext.lookup(LibraryStatefulSessionBeanRemote.class.getName());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> booksList1 = libraryBean1.getBooks();
		stringBuilder.append("<br>****Second lookup**** <br>");
		stringBuilder.append("Book(s) entered so far: " + booksList1.size());
		int x = 0;
		for (String book : booksList1) {
			stringBuilder.append("<br>" + (x + 1) + ". " + book);
			x++;
		}

		return stringBuilder.toString();
	}


}
