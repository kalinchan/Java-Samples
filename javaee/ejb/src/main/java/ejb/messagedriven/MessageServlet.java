package ejb.messagedriven;

import java.io.IOException;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.persistence.Book;
import ejb.persistence.LibraryPersistentBeanRemote;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {

	/*
	 * Message driven bean is a stateless bean and is used to do task
	 * asynchronously.
	 * 
	 * Steps to create:-
	 * 
	 * Step 1 − Create table in database.
	 * 
	 * Step 2 − Create Entity class corresponding to table 
	 * 
	 * Step 3 − Create DataSource and Persistence Unit
	 * 
	 * Step 4 − Create a stateless EJB having EntityManager instance 
	 * 
	 * Step 5 − Update stateless ejb.Add methods to add records and get records from
	 * database via entity manager
	 * 
	 * Step 6 − Create a Queue
	 * 
	 * Step 7 − Create a Message driven bean, which will use the stateless bean to
	 * persist the client data.
	 * 
	 * Step 8 − EJB Container will call the above message driven bean and
	 * pass it the message that client will be sending to.
	 * 
	 */
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
		try {
			Queue queue = (Queue) initalContext.lookup("BookQueue");
			QueueConnectionFactory factory = (QueueConnectionFactory) initalContext.lookup("jms/ConnectionFactory");
			QueueConnection connection = factory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);
			Book book = new Book();
			book.setName(req.getParameter("bookName"));
			ObjectMessage objectMessage = session.createObjectMessage(book);
			sender.send(objectMessage);
			resp.getWriter().print(getEnteredBooks(libraryBean));

		} catch (JMSException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
