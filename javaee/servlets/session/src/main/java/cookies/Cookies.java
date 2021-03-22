package cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookies")
public class Cookies extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		if (req.getCookies() == null) {
			resp.getWriter().print("NO COOKIES");
			resp.getWriter().close();
			return;
		}
		// Get cookies
		Cookie cookies[] = req.getCookies();
		for (Cookie c : cookies) {
			resp.getWriter().print(String.format(
					"<big style=\"color:#ff4040\">Cookie name:</big> %s<big style=\"color:#ff4040\"> Value:</big> %s",
					c.getName(), c.getValue()));
			resp.getWriter().print("<br>");
		}
		resp.getWriter().close();

	}
}
