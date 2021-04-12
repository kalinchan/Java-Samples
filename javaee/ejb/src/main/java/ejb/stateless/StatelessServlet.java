package ejb.stateless;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StatelessServlet")
public class StatelessServlet extends HttpServlet {
	
	/*-
	 * Type of enterprise bean which is normally used to perform independent
	 * operations. 
	 * 
	 * Doesn't have any associated client state, but it may preserve its
	 * instance state. 
	 * 
	 * EJB Container normally creates a pool of few stateless
	 * bean's objects and use these objects to process client's requests.
	 * 
	 * Due to the pool, instance variable values are not guaranteed to be 
	 * the same across lookups/method calls
	 */
	
	/*-
	 * Steps to create stateless EJB:
	 * -Create a remote/local interface exposing the business methods
	 * -This interface will be used by EJB client application
	 * -Use @Local annotation, if EJB client is in same environment 
	 * where EJB session bean is to be deployed
	 * -Use @Remote annotation, if EJB client is in different environment 
	 * where EJB session bean is to be deployed.
	 * -Create a stateless session bean, implementing the above interface.
	 * -Use @Stateless annotation to signify it a stateless bean. 
	 * EJB Container automatically creates the relevant configurations or 
	 * interfaces required by reading this annotation during deployment.
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
		LibrarySessionBeanRemote libraryBean = null;
		try {
			libraryBean = (LibrarySessionBeanRemote) initalContext.lookup(LibrarySessionBeanRemote.class.getName());
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

	private String getEnteredBooks(LibrarySessionBeanRemote libraryBean) {

		List<String> booksList = libraryBean.getBooks();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Book(s) entered so far: " + booksList.size());
		int i = 0;
		for (String book : booksList) {
			stringBuilder.append("<br>" + (i + 1) + ". " + book);
			i++;
		}
		LibrarySessionBeanRemote libraryBean1 = null;
		try {
			libraryBean1 = (LibrarySessionBeanRemote) initalContext.lookup(LibrarySessionBeanRemote.class.getName());
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
