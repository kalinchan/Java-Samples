package ejb.timer;

import java.io.IOException;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TimerServlet")
public class TimerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private InitialContext initalContext;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			initalContext = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			TimerSessionBeanRemote timerServiceBean = (TimerSessionBeanRemote) initalContext
					.lookup(TimerSessionBeanRemote.class.getName());

			resp.getWriter().print("[" + (new Date()).toString() + "]" + "timer created.");
			timerServiceBean.createTimer(2000);

		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}
}
