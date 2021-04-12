package ejb.interceptors;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InterceptorServlet")
public class InterceptorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InitialContext initalContext;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try {
			initalContext = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryBeanRemote libraryBean = null;
		try {
			libraryBean = (LibraryBeanRemote) initalContext.lookup(LibraryBeanRemote.class.getName());
		}catch (NamingException e) {
			// TODO: handle exception
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
	
	private String getEnteredBooks(LibraryBeanRemote libraryBean) {

		List<String> booksList = libraryBean.getBooks();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Book(s) entered so far: " + booksList.size());
		int i = 0;
		for (String book : booksList) {
			stringBuilder.append("<br>" + (i + 1) + ". " + book);
			i++;
		}
		return stringBuilder.toString();
	}


}
