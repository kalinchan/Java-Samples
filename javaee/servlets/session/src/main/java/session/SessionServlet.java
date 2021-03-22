package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Session")
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Print session
		HttpSession httpSession = req.getSession(false);
		if(httpSession == null) {
			resp.getWriter().print("No session");
			return;
		}
		Object sessionAttribute = httpSession.getAttribute("name") == null ? "No attribute"
				: httpSession.getAttribute("name");
		resp.getWriter().print(sessionAttribute);

	}

}
