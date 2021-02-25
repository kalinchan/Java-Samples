package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resultServlet")
public class resultServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("name") == null) {
			resp.getOutputStream().println("No name has been inputted!");
			return;
		}
		if (req.getParameter("name").matches(".*\\d.*")) {
			resp.sendError(400);
		}
		resp.getOutputStream().println("Hello " + req.getParameter("name"));
	}
}
