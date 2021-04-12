package ejb.persistence;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersistenceServlet")
public class PersistenceServlet extends HttpServlet {

	/*
	 * Entity − A persistent object representing the data-store record. It is good
	 * to be serializable.
	 * 
	 * EntityManager − Persistence interface to do data operations like
	 * add/delete/update/find on persistent object(entity). It also helps to execute
	 * queries using Query interface.
	 * 
	 * Persistence unit (persistence.xml) − Persistence unit describes the
	 * properties of persistence mechanism.
	 * 
	 * Data Source (*ds.xml) − Data Source describes the data-store related
	 * properties like connection url. user-name,password etc.
	 * 
	 * Create EJB
	 * 
	 * Step 1 − Create table in database.
	 * 
	 * Step 2 − Create Entity class corresponding to table.
	 * 
	 * Step 3 − Create Data Source and Persistence Unit.
	 * 
	 * Step 4 − Create a stateless EJB having EntityManager instance.
	 * 
	 * Step 5 − Update stateless EJB. Add methods to add records and get records
	 * from database via entity manager.
	 * 
	 * Step 6 − A console based application client will access the stateless EJB to
	 * persist data in database.
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
		LibraryPersistentBeanRemote libraryBean = null;
		try {
			libraryBean = (LibraryPersistentBeanRemote) initalContext
					.lookup(LibraryPersistentBeanRemote.class.getName());
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
		Book book = new Book();
		book.setName(req.getParameter("bookName"));
		libraryBean.addBook(book);
		resp.getWriter().print(getEnteredBooks(libraryBean));

	}

	private String getEnteredBooks(LibraryPersistentBeanRemote libraryBean) {

		List<Book> booksList = libraryBean.getBooks();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Book(s) entered so far: " + booksList.size());
		int i = 0;
		for (Book book : booksList) {
			stringBuilder.append("<br>" + (i + 1) + ". " + book.getName());
			i++;
		}
		return stringBuilder.toString();
	}
}
