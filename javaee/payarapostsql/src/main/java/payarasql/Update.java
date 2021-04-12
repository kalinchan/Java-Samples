package payarasql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/")
public class Update extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/postgresql")
	DataSource dataSource;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Check params
		 * Connect to db
		 * run update query
		 */
		resp.setContentType("text/html");
		if (req.getParameter("tableName") == null || req.getParameter("columnName") == null || req.getParameter("newValue") == null) {
			resp.getWriter().print("Error: Missing values");
			resp.getWriter().close();
			return;
		}
		String tableName = req.getParameter("tableName");
		String columnName = req.getParameter("columnName");
		String newValue = req.getParameter("newValue");
		
		String sql = "UPDATE " + tableName + " set " + columnName + "="+newValue+";";
		try(Connection connection = dataSource.getConnection()){
			Statement statement = connection.createStatement();
			statement.execute(sql);
			resp.getWriter().print("Table Updated!");
			resp.getWriter().close();
		}catch (SQLException ex) {
			resp.getWriter().print("<br>An error occured: " + ex);
			resp.getWriter().close();
		}
	}
}
