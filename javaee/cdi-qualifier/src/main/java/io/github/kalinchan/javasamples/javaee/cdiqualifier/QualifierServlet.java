package io.github.kalinchan.javasamples.javaee.cdiqualifier;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class QualifierServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private RacquetBean racquetBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getOutputStream().println("Racquet Power: " + racquetBean.getRacquetPower());
		response.getOutputStream().println("Spin Power: " + racquetBean.getRacquetSpin());
		response.getOutputStream().close();
	}

}
