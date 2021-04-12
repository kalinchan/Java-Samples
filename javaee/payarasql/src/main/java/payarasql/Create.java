package payarasql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/Create")
public class Create extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/mariadbpool")
	DataSource dataSource;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Connect to db get all parameters check if creation is table count how many
		 * fields create sql statement fill in statement
		 * 
		 */
		resp.setContentType("text/html");
		String tableName = "";
		HashMap<String, String> columns = new HashMap<>();
		if (req.getParameter("tableName") == null) {
			resp.getWriter().print("No table name provided");
			resp.getWriter().close();
			return;
		}
		tableName = req.getParameter("tableName");
		for (String param : req.getParameterMap().keySet()) {
			if (param.startsWith("name")) {
				String count = param.replaceAll("\\D+", "");
				if (req.getParameter("dataType" + count) == null) {
					resp.getWriter().print("Error finding corresponding datatype");
					resp.getWriter().close();
					return;
				}
				columns.putIfAbsent(req.getParameter(param), req.getParameter("dataType" + count));
			}

		}
		// CREATE TABLE table_name(name datatype, name datatype...);
		String sqlStatement = "CREATE TABLE " + tableName + "(";
		for (String colum : columns.keySet()) {
			sqlStatement += colum + " " + columns.get(colum) + ", ";
		}
		sqlStatement = sqlStatement.substring(0, sqlStatement.length() - 2);
		sqlStatement += ");";

		try (Connection connection = dataSource.getConnection()) {
			Statement statement = connection.createStatement();
			resp.getWriter()
					.print("Connection established! Columns: " + columns + "<br> sqlStatement: " + sqlStatement);
			statement.executeUpdate(sqlStatement);
			resp.getWriter().print("<br>Table created successfully");
			resp.getWriter().close();
		} catch (SQLException ex) {
			resp.getWriter().print("<br>An error occured: " + ex);
			resp.getWriter().close();
		}
	}
}
