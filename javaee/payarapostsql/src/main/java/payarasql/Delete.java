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

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/postgresql")
	DataSource dataSource;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * get params
		 * create sql
		 * connect to db
		 * execute sql
		 */
		if(request.getParameter("tableName") == null) {
			response.getWriter().print("Error: Missing values");
			response.getWriter().close();
			return;
		}
		
		String tableName = request.getParameter("tableName");
		String sql = "DROP TABLE IF EXISTS " + tableName;
		
		try(Connection connection = dataSource.getConnection()){
			Statement statement = connection.createStatement();
			statement.execute(sql);
			response.getWriter().print("Table Deleted!");
			response.getWriter().close();
		}catch (SQLException ex) {
			response.getWriter().print("<br>An error occured: " + ex);
			response.getWriter().close();
		}
	}

}
